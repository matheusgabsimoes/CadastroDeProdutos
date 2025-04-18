package SimoesGabMatheus.CadastroDeProdutos.Categorias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriasDTO {

    private Long id;
    private String nome;
    private CategoriasModel categorias;
}
