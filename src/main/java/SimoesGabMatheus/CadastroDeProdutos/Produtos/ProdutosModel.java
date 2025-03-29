package SimoesGabMatheus.CadastroDeProdutos.Produtos;

import SimoesGabMatheus.CadastroDeProdutos.Categorias.CategoriasModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProdutosModel implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nome")
    private String nome;

    @Column (name = "img_url")
    private String imgUrl;

    @Column (name = "quantidade")
    private int quantidade;

    @Column (name = "preco")
    private float preco;

    // Cada produto tem apenas uma categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriasModel categorias;

}
