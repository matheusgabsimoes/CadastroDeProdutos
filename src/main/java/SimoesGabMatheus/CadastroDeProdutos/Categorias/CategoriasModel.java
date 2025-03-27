package SimoesGabMatheus.CadastroDeProdutos.Categorias;

import SimoesGabMatheus.CadastroDeProdutos.Produtos.ProdutosModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "tb_categoria")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoriasModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private ProdutosModel categoria;

    // Vários produtos podem ter a mesma categoria
    @OneToMany(mappedBy = "categoria")
    private List<ProdutosModel> produtos;

}
