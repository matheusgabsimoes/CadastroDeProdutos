package SimoesGabMatheus.CadastroDeProdutos.Tipos;

import SimoesGabMatheus.CadastroDeProdutos.Produtos.ProdutosModel;
import jakarta.persistence.*;


@Entity
@Table(name = "tb_tipos")
public class TiposModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private ProdutosModel tipo;

    public TiposModel() {
    }

    public TiposModel(String nome, ProdutosModel tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ProdutosModel getTipo() {
        return tipo;
    }

    public void setTipo(ProdutosModel tipo) {
        this.tipo = tipo;
    }
}
