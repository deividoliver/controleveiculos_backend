package br.com.altimus.controleveiculos.modelo;

import br.com.altimus.controleveiculos.veiculo.Veiculo;
import br.com.altimus.controleveiculos.modelo
        .ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/modelo")
public class ModeloController {

    private final ModeloService modeloService;

    @Autowired
    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping
    public List<Modelo> getModelos(){
        return this.modeloService.getModelos();
    }

}
