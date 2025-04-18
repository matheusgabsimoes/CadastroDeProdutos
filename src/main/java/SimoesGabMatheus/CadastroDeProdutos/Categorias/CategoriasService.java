package SimoesGabMatheus.CadastroDeProdutos.Categorias;

import SimoesGabMatheus.CadastroDeProdutos.Produtos.ProdutosDTO;
import SimoesGabMatheus.CadastroDeProdutos.Produtos.ProdutosModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriasService {

    private final CategoriasRepository categoriasRepository;
    private final CategoriasMapper categoriasMapper;

    public CategoriasService(CategoriasRepository categoriasRepository, CategoriasMapper categoriasMapper) {
        this.categoriasRepository = categoriasRepository;
        this.categoriasMapper = categoriasMapper;
    }

    public List<CategoriasDTO> listarCategorias() {
        List<CategoriasModel> categorias = categoriasRepository.findAll();
        return categorias.stream()
                .map(categoriasMapper::map)
                .collect(Collectors.toList());
    }

    public CategoriasDTO listarCategoriasPorId(Long id) {
        Optional<CategoriasModel> categoriasPorId = categoriasRepository.findById(id);
        return categoriasPorId.map(categoriasMapper::map)
                .orElse(null);
    }

    public CategoriasDTO criarCategoria(CategoriasDTO criarCategoriaDTO) {
        CategoriasModel categorias = categoriasMapper.map(criarCategoriaDTO);
        categorias = categoriasRepository.save(categorias);
        return categoriasMapper.map(categorias);
    }

    public void deletarCategoria(Long id) {
        categoriasRepository.deleteById(id);
    }

    public CategoriasDTO atualizarCategoria(Long id, CategoriasDTO categoriasDTO) {
        Optional<CategoriasModel> categoriaExistente = categoriasRepository.findById(id);
        if (categoriaExistente.isPresent()) {
            CategoriasModel categoriaAtualizada = categoriasMapper.map(categoriasDTO);
            categoriaAtualizada.setId(id);
            CategoriasModel categoriaIdSalvo = categoriasRepository.save(categoriaAtualizada);
            return categoriasMapper.map(categoriaIdSalvo);
        }
        return null;
    }
}
