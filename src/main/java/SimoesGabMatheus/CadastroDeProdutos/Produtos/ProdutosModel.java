package SimoesGabMatheus.CadastroDeProdutos.Produtos;

import SimoesGabMatheus.CadastroDeProdutos.Tipos.TiposModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
public class ProdutosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private List<TiposModel> tipo;
    private int quantidade;
    private float preco;

    public ProdutosModel() {
    }

    public ProdutosModel(String nome, List<TiposModel> tipo, int quantidade, float preco) {
        this.nome = nome;
        this.tipo = tipo;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<TiposModel> getTipo() {
        return tipo;
    }

    public void setTipo(List<TiposModel> tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
