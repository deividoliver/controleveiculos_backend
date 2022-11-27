package br.com.altimus.controleveiculos.veiculo;

import br.com.altimus.controleveiculos.modelo.Modelo;
import br.com.altimus.controleveiculos.modelo.ModeloService;
import br.com.altimus.controleveiculos.opcional.Opcional;
import br.com.altimus.controleveiculos.opcional.OpcionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "api/veiculo")
public class VeiculoController {

    private final VeiculoService veiculoService;
    @Autowired
    private ModeloService modeloService;
    @Autowired
    private OpcionalService opcionalService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService, OpcionalService opcionalService) {
        this.veiculoService = veiculoService;
        this.opcionalService = opcionalService;
    }

    @ResponseBody
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Veiculo>  getVeiculos(){
//        return new ResponseEntity<>(this.veiculoService.getVeiculos(), HttpStatus.OK);
        return this.veiculoService.getVeiculos();
    }

    @ResponseBody
    @GetMapping(path = "{veiculoId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Veiculo> getVeiculo(@PathVariable("veiculoId") Long veiculoId){
        System.out.println("CONSULTA VEICULO");
        return this.veiculoService.getVeiculoById(veiculoId);
    }

    @PostMapping(path = "{modeloId}/create")
    public void  registerNewVeiculo(@PathVariable("modeloId") Long modeloId,@RequestBody Veiculo veiculo, @RequestParam Long[] opcoes){
        Modelo modelo = modeloService.getModeloById(modeloId).get();

        veiculo.setModelo(modelo);

        List<Opcional> opcionais = new ArrayList<>();
        if(opcoes != null){

            for (Long op: opcoes) {
                Optional<Opcional> opcional = opcionalService.getOpcionalById(op);
                if(!opcional.isPresent()){
                    throw new IllegalStateException("Envio de opcionais inválidos.");
                }
                opcionais.add(opcional.get());
            }
        }

        if(opcionais.size()>0){
            veiculo.setOpcionais(opcionais);
        }

        veiculoService.addNewVeiculo(veiculo);
    }

    @DeleteMapping(path = "{veiculoId}")
    public void deleteVeiculo(@PathVariable("veiculoId") Long veiculoId){
        veiculoService.deleteVeiculo(veiculoId);
    }

    @PutMapping(path = "{veiculoId}")
    public void updateVeiculo(@PathVariable("veiculoId") Long veiculoId,
                              @RequestParam(required = false) Long modeloId,
                              @RequestParam(required = false) String placa,
                              @RequestParam(required = false) String renavam,
                              @RequestParam(required = false) Long[] opcoes,
                              @RequestParam(required = false) BigDecimal valor){


        if(modeloId == null){
            throw new IllegalStateException("Envio de modelo de veículo requerido.");
        }

        Optional<Modelo> modeloById = modeloService.getModeloById(modeloId);
        List<Opcional> opcionais = new ArrayList<>();
        if(opcoes != null){

            for (Long op: opcoes) {
                Optional<Opcional> opcional = opcionalService.getOpcionalById(op);
                if(opcional.isPresent()){
                    opcionais.add(opcional.get());
                }
            }
        }

        veiculoService.updateVeiculo(veiculoId, modeloById.get(), placa, renavam, opcionais, valor);

    }

}
