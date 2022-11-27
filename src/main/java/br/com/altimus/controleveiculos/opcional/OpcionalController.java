package br.com.altimus.controleveiculos.opcional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/opcional")
public class OpcionalController {
    private final OpcionalService opcionalService;

    @Autowired
    public OpcionalController(OpcionalService opcionalService) {
        this.opcionalService = opcionalService;
    }
    @GetMapping
    public List<Opcional> getOpcionais(){
        return this.opcionalService.getOpcionais();
    }
}
