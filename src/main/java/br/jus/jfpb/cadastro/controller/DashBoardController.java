package br.jus.jfpb.cadastro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DashBoardController {
    @RequestMapping("/inicial")
    public String Execute(){
        System.out.println("Executando o login");
        return "home";
    }
}
