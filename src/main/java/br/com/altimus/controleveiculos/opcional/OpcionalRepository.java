package br.com.altimus.controleveiculos.opcional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OpcionalRepository extends JpaRepository<Opcional, Long> {

}
