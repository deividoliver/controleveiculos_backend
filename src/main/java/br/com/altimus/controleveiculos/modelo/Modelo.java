package br.com.altimus.controleveiculos.modelo;

import br.com.altimus.controleveiculos.veiculo.Veiculo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "modelo"
)
public class Modelo {
    @Id
    @Column(
            name = "modelo_id"
    )
    @SequenceGenerator(
            name = "modelo_sequence",
            sequenceName = "modelo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "modelo_sequence"
    )
    private Long id;
    private String nome;


    public Modelo() {
    }

    public Modelo(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Modelo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
