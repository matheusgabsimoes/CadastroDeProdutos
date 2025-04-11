package SimoesGabMatheus.CadastroDeProdutos.Produtos;
import SimoesGabMatheus.CadastroDeProdutos.Categorias.CategoriasModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosDTO {

    private Long id;
    private String nome;
    private String imgUrl;
    private int quantidade;
    private float preco;
    private String validade;
    private CategoriasModel categorias;

}
