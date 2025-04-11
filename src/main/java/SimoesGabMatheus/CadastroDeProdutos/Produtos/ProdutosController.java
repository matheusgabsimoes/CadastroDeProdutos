package SimoesGabMatheus.CadastroDeProdutos.Produtos;

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
    public ProdutosDTO criarProduto(@RequestBody ProdutosDTO produto) {
        return produtosService.criarProduto(produto);
    }

    @GetMapping("/listar")
    public List<ProdutosDTO> mostrarProdutos() {
        return produtosService.listarProdutos();
    }

    @GetMapping("/listar/{id}")
    public ProdutosDTO listarProdutosPorId(@PathVariable Long id) {
        return produtosService.listarProdutosPorId(id);
    }

    @PutMapping("/alterar/{id}")
    public ProdutosDTO alterarProdutosPorId(@PathVariable Long id, @RequestBody ProdutosDTO produtoAtualizado) {
        return produtosService.atualizarProduto(id, produtoAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarProdutos(@PathVariable Long id) {
        produtosService.deletarProdutoPorId(id);
    }

}