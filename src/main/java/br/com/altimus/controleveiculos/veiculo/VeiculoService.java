package br.com.altimus.controleveiculos.veiculo;

import br.com.altimus.controleveiculos.modelo.Modelo;
import br.com.altimus.controleveiculos.opcional.Opcional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> getVeiculos(){
        return veiculoRepository.findAll();
    }

    public Optional<Veiculo> getVeiculoById(Long id){
        Optional<Veiculo> veiculoById = veiculoRepository.findById(id);
        if(!veiculoById.isPresent()){
            throw new IllegalStateException("Veiculo não encontrado.");
        }

        return veiculoById;
    }

    public void addNewVeiculo(Veiculo veiculo) {

        Optional<Veiculo> veiculoByPlaca = veiculoRepository.findVeiculoByPlaca(veiculo.getPlaca());
        if(veiculoByPlaca.isPresent()){
            throw new IllegalStateException("Esta placa já pertence a outro veículo.");
        }

        Optional<Veiculo> veiculoByRenavam = veiculoRepository.findVeiculoByRenavam(veiculo.getRenavam());
        if(veiculoByRenavam.isPresent()){
            throw new IllegalStateException("Este RENAVAM já pertence a outro veículo.");
        }
        veiculo.setCadastro(LocalDateTime.now());
        veiculoRepository.save(veiculo);
        System.out.println(veiculo);
    }

    public void deleteVeiculo(Long veiculoId) {

        Optional veiculoById = veiculoRepository.findById(veiculoId);

        if(!veiculoById.isPresent()){
            throw new IllegalStateException("Veiculo não encontrado para excluir!");
        }

        veiculoRepository.deleteById(veiculoId);
    }
    @Transactional
    public void updateVeiculo(Long veiculoId, Modelo modelo, String placa, String renavam, List<Opcional>  opcoes, BigDecimal valor) {
        Veiculo veiculo = veiculoRepository.findById(veiculoId).orElseThrow(()-> new IllegalStateException("Veiculo não encontrado para atualizar"));

        veiculo.setModelo(modelo);

        if(placa != null &&
           placa.length()>0 &&
           !Objects.equals(veiculo.getPlaca(), placa)){
            Optional<Veiculo> veiculoByPlaca = veiculoRepository.findVeiculoByPlaca(placa);
            if(veiculoByPlaca.isPresent()){
                throw new IllegalStateException("Esta placa já pertence a outro veículo.");
            }
            veiculo.setPlaca(placa);
        }

        if(opcoes != null &&
           !Objects.equals(veiculo.getOpcionais(), opcoes)){
            veiculo.setOpcionais(opcoes);
        }

        if(renavam != null &&
           renavam.length()>0 &&
           !Objects.equals(veiculo.getRenavam(), renavam)){
            Optional<Veiculo> veiculoByRenavam = veiculoRepository.findVeiculoByRenavam(renavam);
            if(veiculoByRenavam.isPresent()){
                throw new IllegalStateException("Este RENAVAM já pertence a outro veículo.");
            }

            veiculo.setRenavam(renavam);
        }

        if(valor != null &&
                !Objects.equals(veiculo.getValor(), valor)){
            veiculo.setValor(valor);
        }

    }
}
