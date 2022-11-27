package br.com.altimus.controleveiculos.veiculo;

import br.com.altimus.controleveiculos.modelo.Modelo;
import br.com.altimus.controleveiculos.opcional.Opcional;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "veiculo")
public class Veiculo {
    @Id
    @Column(
            name = "veiculo_id"
    )
    @SequenceGenerator(
            name = "veiculo_sequence",
            sequenceName = "veiculo_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "veiculo_sequence"
    )

    private Long id;

    private String placa;
    private String renavam;
    private LocalDateTime cadastro;
    private BigDecimal valor;


    @ManyToOne(
            fetch = FetchType.EAGER
    )
    @JoinColumn(
            name = "modelo_id"
    )
    private Modelo modelo;

    @ManyToMany(
            fetch = FetchType.EAGER,
            cascade = {CascadeType.DETACH}
    )
    @JoinTable(
            name = "veiculo_opcional",
            joinColumns = {@JoinColumn(
                    name = "veiculo_id",
                    referencedColumnName = "veiculo_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "opcional_id",
                    referencedColumnName = "opcional_id"
            )}
    )
    private List<Opcional> opcionais = new ArrayList();

    public Veiculo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public List<Opcional> getOpcionais() {
        return opcionais;
    }

    public void setOpcionais(List<Opcional> opcionais) {
        this.opcionais = opcionais;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }


    public LocalDateTime getCadastro() {
        return cadastro;
    }

    public void setCadastro(LocalDateTime cadastro) {
        this.cadastro = cadastro;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", renavam='" + renavam + '\'' +
                ", cadastro=" + cadastro +
                ", valor=" + valor +
                '}';
    }
}
