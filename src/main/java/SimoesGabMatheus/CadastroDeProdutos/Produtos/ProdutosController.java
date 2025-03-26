package SimoesGabMatheus.CadastroDeProdutos.Produtos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutosController {

    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Hello world!";
    }
}
