package SimoesGabMatheus.CadastroDeProdutos.Produtos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
public class ProdutosController {

    private ProdutosService produtosService;

    public ProdutosController(ProdutosService produtosService) {
        this.produtosService = produtosService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarProduto(@RequestBody ProdutosDTO produto) {
        ProdutosDTO novoProduto = produtosService.criarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Produto criado com sucesso! \n" + novoProduto.getNome());
    }

    @GetMapping("/listar")
    public ResponseEntity<List<ProdutosDTO>> mostrarProdutos() {
        List<ProdutosDTO> listaDeProdutos = produtosService.listarProdutos();
        return ResponseEntity.ok(listaDeProdutos);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> listarProdutosPorId(@PathVariable Long id) {
        ProdutosDTO produtoPorId = produtosService.listarProdutosPorId(id);
        if (produtoPorId != null) {
            return ResponseEntity.ok("Produto deletado! \n" + produtoPorId);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Produto com" + id +" não existe");
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<?> alterarProdutosPorId(@PathVariable Long id, @RequestBody ProdutosDTO produtoAtualizado) {
        ProdutosDTO alterarPorId = produtosService.atualizarProduto(id, produtoAtualizado);
        if (alterarPorId != null) {
            return ResponseEntity.ok(alterarPorId);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Produto com" + id +" não existe");
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarProdutos(@PathVariable Long id) {
        if (produtosService.listarProdutosPorId(id) != null) {
            produtosService.deletarProdutoPorId(id);
            return ResponseEntity.ok("Produto deletado com sucesso! \nID: " + deletarProdutos(id));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Produto não encontrado");
    }
}