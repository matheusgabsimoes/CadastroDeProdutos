package SimoesGabMatheus.CadastroDeProdutos.Produtos;

import SimoesGabMatheus.CadastroDeProdutos.Categorias.CategoriasModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Entity
@Table(name = "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "categorias")
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

    @Column (name = "validade")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate validade;

    @Column (name = "preco")
    private float preco;

    // Cada produto tem apenas uma categoria
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriasModel categorias;


}
