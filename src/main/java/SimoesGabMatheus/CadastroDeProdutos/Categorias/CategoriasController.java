package SimoesGabMatheus.CadastroDeProdutos.Categorias;

import SimoesGabMatheus.CadastroDeProdutos.Produtos.ProdutosDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categorias")
public class CategoriasController {

    private final CategoriasService categoriasService;

    public CategoriasController(CategoriasService categoriasService) {
        this.categoriasService = categoriasService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarCategoria(@RequestBody CategoriasDTO categorias) {
        CategoriasDTO novaCategoria = categoriasService.criarCategoria(categorias);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Categoria criada com sucesso!" + novaCategoria.getNome());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriasDTO>> listarCategoria() {
        List<CategoriasDTO> listaDeCategorias = categoriasService.listarCategorias();
        return ResponseEntity.ok(listaDeCategorias);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarCategoriaPorId(@PathVariable Long id, @RequestBody CategoriasDTO categoriaAtualizada) {
        CategoriasDTO alterarPorId = categoriasService.atualizarCategoria(id, categoriaAtualizada);
        if (alterarPorId != null) {
            return ResponseEntity.ok(alterarPorId);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Categoria com" + id +" não existe");
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<String> deletarCategoria(@PathVariable Long id) {
        if (categoriasService.listarCategoriasPorId(id) != null) {
            categoriasService.deletarCategoria(id);
            return ResponseEntity.ok("Categoria deletado com sucesso! \nID: " + deletarCategoria(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Categoria não encontrado");
    }

}
