package SimoesGabMatheus.CadastroDeProdutos.Produtos;

import org.springframework.web.bind.annotation.*;

@RestController
public class ProdutosController {

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello world!";
    }

    //Adicionar produtos
    @PostMapping("/criar")
    public String criarProduto() {
        return "Produto criado";
    }

    //Procurar produtos por ID
    @GetMapping("/todos")
    public String mostrarProdutos() {
        return "Mostrar produtos";
    }

    //Mostrar produtos por ID
    @GetMapping("/todosID")
    public String mostrarProdutosPorId() {
        return "Mostrar produtos por id";
    }

    //Alterar dados dos produtos
    @PutMapping("/alterarID")
    public String alterarProdutosPorId() {
        return "Alterar produtos por id";
    }

    //Remover produtos
    @DeleteMapping("/deletarID")
    public String deletarProdutosPorId() {
        return "Deletar produtos por id";
    }

}
