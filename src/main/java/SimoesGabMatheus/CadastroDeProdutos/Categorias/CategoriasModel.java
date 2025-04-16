package SimoesGabMatheus.CadastroDeProdutos.Categorias;

import SimoesGabMatheus.CadastroDeProdutos.Produtos.ProdutosModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Entity
@Table(name = "tb_categoria")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CategoriasModel {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private ProdutosModel categorias;

    // Vários produtos podem ter a mesma categoria
    @OneToMany(mappedBy = "categorias")
    @JsonIgnore
    private List<ProdutosModel> produtos;

}
