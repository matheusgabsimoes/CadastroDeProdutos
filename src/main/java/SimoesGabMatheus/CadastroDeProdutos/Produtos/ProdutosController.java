package SimoesGabMatheus.CadastroDeProdutos.Produtos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produtos")
public class ProdutosController {

    //Adicionar produtos
    @PostMapping("/criar")
    public String criarProduto() {
        return "Produto criado";
    }

    //Procurar produtos por ID
    @GetMapping("/listar")
    public String mostrarProdutos() {
        return "Mostrar produtos";
    }

    //Mostrar produtos por ID
    @GetMapping("/listarID")
    public String mostrarProdutosPorId() {
        return "Mostrar produtos por id";
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
