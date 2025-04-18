package SimoesGabMatheus.CadastroDeProdutos.Produtos;

import SimoesGabMatheus.CadastroDeProdutos.Categorias.CategoriasDTO;
import SimoesGabMatheus.CadastroDeProdutos.Categorias.CategoriasModel;
import SimoesGabMatheus.CadastroDeProdutos.Categorias.CategoriasService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/produtos/ui")
public class ProdutoControllerUI {

    private final ProdutosService produtosService;
    private final CategoriasService categoriasService;

    public ProdutoControllerUI(ProdutosService produtosService, CategoriasService categoriasService) {
        this.produtosService = produtosService;
        this.categoriasService = categoriasService;
    }

    @GetMapping("/listar")
    public String listarProduto(Model model) {
        List<ProdutosDTO> produtos =  produtosService.listarProdutos();
        model.addAttribute("produtos", produtos);
        return "listarProdutos"; // Tem que retornar o nome da pagina que renderiza
    }

    @GetMapping("/deletar/{id}")
    public String deletarProdutosPorId(@PathVariable Long id) {
        produtosService.deletarProdutoPorId(id);
        return "redirect:/produtos/ui/listar";
    }

    @GetMapping("/listar/{id}")
    public String listarProdutosPorId(@PathVariable Long id, Model model) {
        ProdutosDTO produtos =  produtosService.listarProdutosPorId(id);
        if (produtos !=null) {
            model.addAttribute("produtos", produtos);
            return "detalhesProduto";
        } else {
            model.addAttribute("mensagem", "Produto não encontrado");
            return "listarProdutos";
        }
    }

    @GetMapping("/adicionar")
    public String mostrarFormularioAdicionarProduto(Model model) {
        model.addAttribute("produtos", new ProdutosDTO());
        model.addAttribute("categorias", categoriasService.listarCategorias());
        return "adicionarProduto";
    }

    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute ProdutosDTO produto, @RequestParam(value = "novaCategoria") String novaCategoria, RedirectAttributes redirectAttributes) {
        if (novaCategoria != null && !novaCategoria.isBlank()) {
            CategoriasDTO nova = new CategoriasDTO();
            nova.setNome(novaCategoria);
            CategoriasDTO criada = categoriasService.criarCategoria(nova);
            CategoriasModel categoriaModel = new CategoriasModel();
            categoriaModel.setId(criada.getId());
            categoriaModel.setNome(criada.getNome());
            produto.setCategorias(categoriaModel);
        }

        produtosService.criarProduto(produto);
        redirectAttributes.addFlashAttribute("mensagem", "Produto cadastrado com sucesso!");
        return "redirect:/produtos/ui/listar";
    }

    @GetMapping("/editar/{id}")
    public String editarProduto(@PathVariable Long id, Model model) {
        ProdutosDTO produto = produtosService.listarProdutosPorId(id);
        if (produto != null) {
            model.addAttribute("produtos", produto);
            model.addAttribute("categorias", categoriasService.listarCategorias());
            return "adicionarProduto";
        }
            model.addAttribute("mensagem", "Produto não encontrado");
            return "redirect:/produtos/ui/listar";
    }

}