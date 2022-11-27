package br.com.altimus.controleveiculos.opcional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpcionalService {
    private final OpcionalRepository opcionalRepository;

    @Autowired
    public OpcionalService(OpcionalRepository opcionalRepository) {
        this.opcionalRepository = opcionalRepository;
    }

    public List<Opcional> getOpcionais(){
        return opcionalRepository.findAll();
    }

    public Optional<Opcional> getOpcionalById(Long id){
        return opcionalRepository.findById(id);
    }
}
