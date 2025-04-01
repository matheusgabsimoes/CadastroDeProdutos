package SimoesGabMatheus.CadastroDeProdutos.Categorias;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    // GET - requisicao de alteracao
    @GetMapping("/listar")
    public String listarCategoria() {
        return "Categoria listada";
    }

    // POST - requisicao de criaacao
    @PostMapping("/criar")
    public String criarCategoria() {
        return "Categoria criada";
    }

    // PUT - requisicao de alterar
    @PutMapping("/alterar")
    public String alterarCategoria() {
        return "Categoria alterada";
    }

    // DELETE - requisicao para deletar
    @DeleteMapping("/deletar")
    public String deletarCategoria() {
        return "Categoria deletada";
    }

}
