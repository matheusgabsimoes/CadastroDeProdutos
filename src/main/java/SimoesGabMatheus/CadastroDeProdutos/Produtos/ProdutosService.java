package SimoesGabMatheus.CadastroDeProdutos.Produtos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutosService {

    private final ProdutosRepository produtosRepository;
    private final ProdutosMapper produtosMapper;

    public ProdutosService(ProdutosRepository produtosRepository, ProdutosMapper produtosMapper) {
        this.produtosRepository = produtosRepository;
        this.produtosMapper = produtosMapper;
    }

    public List<ProdutosDTO> listarProdutos() {
        List<ProdutosModel> produtos = produtosRepository.findAll();
        return produtos.stream()
                .map(produtosMapper::map)
                .collect(Collectors.toList());
    }

    public ProdutosDTO listarProdutosPorId(Long id) {
        Optional<ProdutosModel> produtosPorId = produtosRepository.findById(id);
        return produtosPorId.map(produtosMapper::map).orElse(null);
    }

    public ProdutosDTO criarProduto(ProdutosDTO criarProdutosDTO) {
        ProdutosModel produto = produtosMapper.map(criarProdutosDTO);
        produto = produtosRepository.save(produto);
        return produtosMapper.map(produto);
    }

    public void deletarProdutoPorId(Long id) {
        produtosRepository.deleteById(id);
    }

    public ProdutosDTO atualizarProduto(Long id, ProdutosDTO produtosDTO) {
        Optional<ProdutosModel> produtoExistente = produtosRepository.findById(id);
        if (produtoExistente.isPresent()) {
            ProdutosModel produtoAtualizado = produtosMapper.map(produtosDTO);
            produtoAtualizado.setId(id);
            ProdutosModel produtoIdSalvo = produtosRepository.save(produtoAtualizado);
            return produtosMapper.map(produtoIdSalvo);
        }
        return null;
    }
}