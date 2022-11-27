package br.com.altimus.controleveiculos.opcional;

import javax.persistence.*;
@Entity
@Table(
        name = "opcional"
)
public class Opcional {
    @Id
    @Column(
            name = "opcional_id"
    )
    @SequenceGenerator(
            name = "opcional_sequence",
            sequenceName = "modelo_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "opcional_sequence"
    )
    private Long id;
    private String nome;


    public Opcional() {
    }

    public Opcional(Long id, String nome) {
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
