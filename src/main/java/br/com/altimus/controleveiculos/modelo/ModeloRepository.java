package br.com.altimus.controleveiculos.modelo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    @Query("SELECT m FROM Modelo m WHERE m.nome = ?1")
    Optional<Modelo> findVeiculoByModelo(String nome);

    //List<Modelo> findByVeiculoId(Long veiculoId);
}
