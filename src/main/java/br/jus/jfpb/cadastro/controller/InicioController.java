package br.jus.jfpb.cadastro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController {
    @RequestMapping("/inicio")
    public String Execute(){
        System.out.println("Executando a pagina inicial");
        return "inicio";
    }
}
