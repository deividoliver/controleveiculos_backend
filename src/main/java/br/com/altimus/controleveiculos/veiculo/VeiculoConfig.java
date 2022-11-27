package br.com.altimus.controleveiculos.veiculo;

import br.com.altimus.controleveiculos.modelo.Modelo;
import br.com.altimus.controleveiculos.modelo.ModeloService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

@Configuration
public class VeiculoConfig implements WebMvcConfigurer {

    private ModeloService modeloService;

    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedOrigins("http://localhost:3000").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }

//    @Bean
//    CommandLineRunner commandLineRunner(VeiculoRepository repository){
//
//        modeloService.getModeloById(1L).map(modelo -> {
//
//
//
//                String[] opc = {"VE", "TE", "AL", "AC"};
//                Veiculo ford = new Veiculo(
//                        1L,
//                        modelo,
//                        "qvo-9a08",
//                        "473621jhk423784",
//                        opc,
//                        LocalDateTime.of(2019, Month.JUNE, 5, 0, 0, 0),
//                        58000.00);
//                Veiculo onix = new Veiculo(
//                        2L,
//                        modelo,
//                        "qvi-9a08",
//                        "487421jhk423784",
//                        opc,
//                        LocalDateTime.of(2019, Month.JUNE, 5, 0, 0, 0),
//                        80000.00);
//                repository.saveAll(
//                        List.of(ford, onix)
//                );
//
//
//            return null;
//        });
//
//        return null;
//    }
}
