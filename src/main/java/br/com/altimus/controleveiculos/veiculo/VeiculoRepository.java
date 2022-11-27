package br.com.altimus.controleveiculos.veiculo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    @Query("SELECT v FROM Veiculo v WHERE v.placa = ?1")
    Optional<Veiculo> findVeiculoByPlaca(String placa);

    @Query("SELECT v FROM Veiculo v WHERE v.renavam = ?1")
    Optional<Veiculo> findVeiculoByRenavam(String renavam);

}
