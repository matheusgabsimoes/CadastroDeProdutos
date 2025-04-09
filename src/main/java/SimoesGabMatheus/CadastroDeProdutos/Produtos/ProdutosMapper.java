package SimoesGabMatheus.CadastroDeProdutos.Produtos;

import org.springframework.stereotype.Component;

@Component
public class ProdutosMapper {

    public ProdutosModel map(ProdutosDTO produtosDTO) {

        ProdutosModel produtosModel = new ProdutosModel();
        produtosModel.setId(produtosDTO.getId());
        produtosModel.setNome(produtosDTO.getNome());
        produtosModel.setImgUrl(produtosDTO.getImgUrl());
        produtosModel.setQuantidade(produtosDTO.getQuantidade());
        produtosModel.setValidade(produtosDTO.getValidade());
        produtosModel.setPreco(produtosDTO.getPreco());
        produtosModel.setCategorias(produtosDTO.getCategorias());

        return produtosModel;
    }

    public ProdutosDTO map(ProdutosModel produtosModel) {

        ProdutosDTO produtosDTO = new ProdutosDTO();
        produtosDTO.setId(produtosDTO.getId());
        produtosDTO.setNome(produtosDTO.getNome());
        produtosDTO.setImgUrl(produtosDTO.getImgUrl());
        produtosDTO.setQuantidade(produtosDTO.getQuantidade());
        produtosDTO.setValidade(produtosDTO.getValidade());
        produtosDTO.setPreco(produtosDTO.getPreco());
        produtosDTO.setCategorias(produtosDTO.getCategorias());

        return produtosDTO;
    }



}
