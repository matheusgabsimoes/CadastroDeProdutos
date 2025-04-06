package SimoesGabMatheus.CadastroDeProdutos.Produtos;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosService {

    private ProdutosRepository produtosRepository;

    public ProdutosService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public List<ProdutosModel> listarProdutos() {
        return produtosRepository.findAll();
    }

}
