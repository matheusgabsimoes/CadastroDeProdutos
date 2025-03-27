package SimoesGabMatheus.CadastroDeProdutos.Produtos;

import SimoesGabMatheus.CadastroDeProdutos.Categorias.CategoriasModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int quantidade;
    private float preco;

    // Cada produto tem apenas uma categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriasModel categoria;

}
