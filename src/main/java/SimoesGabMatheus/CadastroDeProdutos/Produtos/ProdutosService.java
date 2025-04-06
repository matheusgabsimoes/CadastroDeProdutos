package SimoesGabMatheus.CadastroDeProdutos.Produtos;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosService {

    private ProdutosRepository produtosRepository;

    public ProdutosService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public List<ProdutosModel> listarProdutos() {
        return produtosRepository.findAll();
    }

    public ProdutosModel listarProdutosPorId(Long id) {
        Optional<ProdutosModel> produtosPorId = produtosRepository.findById(id);
        return produtosPorId.orElse(null);
    }

    public ProdutosModel criarProduto(ProdutosModel produtos) {
        return produtosRepository.save(produtos);
    }

    public void deletarProdutoPorId(Long id) {
        produtosRepository.deleteById(id);
    }

    public ProdutosModel atualizarProduto(Long id, ProdutosModel produtoAtualizado) {
        if (produtosRepository.existsById(id)) {
            produtoAtualizado.setId(id);
            return produtosRepository.save(produtoAtualizado);
        }
        return null;
    }
}