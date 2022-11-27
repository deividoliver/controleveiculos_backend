package br.com.altimus.controleveiculos.modelo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;

    @Autowired
    public ModeloService(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    public List<Modelo> getModelos(){
        return modeloRepository.findAll();
    }

    public Optional<Modelo> getModeloById(Long id){
        Optional<Modelo> modeloById = modeloRepository.findById(id);

        if(!modeloById.isPresent()){
            throw new IllegalStateException("Modelo de veículo não encontrado.");
        }

        return modeloById;
    }

}
