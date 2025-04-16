package SimoesGabMatheus.CadastroDeProdutos.Produtos;
import SimoesGabMatheus.CadastroDeProdutos.Categorias.CategoriasModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutosDTO {

    private Long id;
    private String nome;
    private String imgUrl;
    private int quantidade;
    private float preco;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate validade;
    private CategoriasModel categorias;

}
