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

    //Adicionar produtos
    @PostMapping("/criar")
    public ProdutosModel criarProduto(@RequestBody ProdutosModel produto) {
        return produtosService.criarProduto(produto);
    }

    //Procurar produtos por ID
    @GetMapping("/listar")
    public List<ProdutosModel> mostrarProdutos() {
        return produtosService.listarProdutos();
    }

    //Mostrar produtos por ID
    @GetMapping("/listar/{id}")
    public ProdutosModel listarProdutosPorId(@PathVariable Long id) {
        return produtosService.listarProdutosPorId(id);
    }

    //Alterar dados dos produtos
    @PutMapping("/alterar/{id}")
    public ProdutosModel alterarProdutosPorId(@PathVariable Long id, @RequestBody ProdutosModel produtoAtualizado) {
        return produtosService.atualizarProduto(id, produtoAtualizado);
    }

    //Remover produtos
    @DeleteMapping("/deletar/{id}")
    public void deletarProdutos(@PathVariable Long id) {
        produtosService.deletarProdutoPorId(id);
    }

}