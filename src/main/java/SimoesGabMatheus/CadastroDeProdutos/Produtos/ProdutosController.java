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
    public String criarProduto() {
        return "Produto criado";
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
    @PutMapping("/alterar")
    public String alterarProdutos() {
        return "Alterar produtos";
    }

    //Remover produtos
    @DeleteMapping("/deletarI")
    public String deletarProdutos() {
        return "Deletar produtos";
    }

}