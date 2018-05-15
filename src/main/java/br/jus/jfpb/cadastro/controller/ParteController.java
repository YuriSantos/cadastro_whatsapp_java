package br.jus.jfpb.cadastro.controller;

import br.jus.jfpb.cadastro.model.Parte;
import br.jus.jfpb.cadastro.service.ParteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("parte")
public class ParteController {
    @Autowired
    private ParteService parteService;

    @RequestMapping(method = RequestMethod.GET, value = {"listar"})
    public String list(ModelMap map){
        List<Parte> partes = parteService.listar();
        map.addAttribute("parte",partes);
        map.addAttribute("filtro",new Parte());
        return "/parte/listar";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"novo"})
    public String novo(ModelMap map){
        Parte parte = new Parte();
        map.addAttribute("parte",parte);
        return "/parte/novo";
    }

    @RequestMapping(method = RequestMethod.POST, value = {"salvar"})
    public String salvar(@ModelAttribute("parte") @Valid Parte parte, RedirectAttributes rm ){
        try{
            if(parte.temIdValido()){
                parteService.atualizar(parte);
                rm.addFlashAttribute("sucesso","Parte atualizada com sucesso!");
            }
            else
            {
                parteService.inserir(parte);
                rm.addFlashAttribute("sucesso","Parte salva com sucesso!");
            }

        }
        catch (Exception e){
            rm.addFlashAttribute("erro","Erro ao salvar a parte.");
        }
        return "redirect:/parte/novo";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/deletar/{id}"})
    public String remover(@PathVariable("id") Long id, RedirectAttributes rm){
        Parte parte = parteService.buscaPorId(id);
        if(parte != null){
            try{
                parteService.excluir(parte);
                rm.addFlashAttribute("sucesso", "Parte deletada com sucesso");
            }catch (Exception e){
                rm.addFlashAttribute("erro","Erro ao deletar a parte");
            }
        }
        return "redirect:/parte/listar";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/atualizar/{id}"})
    public String atualizar(@PathVariable("id") Long id, RedirectAttributes rm, ModelMap map) throws Exception{
        Parte parte = parteService.buscaPorId(id);
        map.addAttribute("parte",parte);

        return "/parte/novo";
    }
}
