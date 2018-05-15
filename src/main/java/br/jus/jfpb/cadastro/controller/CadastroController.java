package br.jus.jfpb.cadastro.controller;

import br.jus.jfpb.cadastro.excecao.CampoVazioEx;
import br.jus.jfpb.cadastro.excecao.TamanhoEX;
import br.jus.jfpb.cadastro.model.Cadastro;
import br.jus.jfpb.cadastro.model.Parte;
import br.jus.jfpb.cadastro.service.CadastroService;
import br.jus.jfpb.cadastro.service.ParteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("cadastro")
public class CadastroController {
    @Autowired
    private CadastroService cadastroService;
    @Autowired
    private ParteService parteService;

    @RequestMapping(method = RequestMethod.GET, value = {"listar"})
    public String list(ModelMap map){
        List<Cadastro> cadastros = cadastroService.listar();

        map.addAttribute("cadastro", cadastros);
        map.addAttribute("filtro", new Cadastro());

        return "/cadastro/listar";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"novo"})
    public String novo(ModelMap map){
        Cadastro cadastro = new Cadastro();

        map.addAttribute("cadastro",cadastro);
        map.addAttribute("parte",selectParte());

        return "/cadastro/novo";
    }

    @RequestMapping(method = RequestMethod.POST, value = {"salvar"})
    public String salvar (@ModelAttribute("cadastro") Cadastro cadastro, RedirectAttributes rm){

        try{
            if(cadastro.getNome().equals(null) || cadastro.getNome().equals("")) throw  new CampoVazioEx("O campo nome não pode ser vazio.");
            if(cadastro.getTelefone().equals(null) || cadastro.getTelefone().equals("")) throw  new CampoVazioEx("O campo telefone não pode ser vazio.");
            if(cadastro.getNome().equals(null) || cadastro.getNome().equals("")) throw  new CampoVazioEx("O campo nome não pode ser vazio.");
            if(cadastro.getNome().length() <=3) throw new TamanhoEX("Nome muito pequeno.");
            if(cadastro.getNome().length() >=255) throw new TamanhoEX("Nome muito grande.");

            if(cadastro.temIdValido()){
                cadastro.setData_cadastro(cadastro.getData_cadastro());
                cadastroService.atualizar(cadastro);
                rm.addFlashAttribute("sucesso","Cadastro atualizado com sucesso!");
            }
            else{
                cadastroService.inserir(cadastro);
                rm.addFlashAttribute("sucesso","Cadastro salvo com sucesso!");
            }
        }catch (CampoVazioEx e){
            rm.addFlashAttribute("erro", e.getMessage());
        }
        catch (TamanhoEX e){
            rm.addFlashAttribute("erro", e.getMessage());
        }
        catch (Exception e){
            rm.addFlashAttribute("erro","Erro ao salvar o cadastro!");
        }

        return "redirect:/cadastro/listar";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"deletar/{id}"})
    public String remover(@PathVariable("id") Long id, RedirectAttributes rm){
        Cadastro cadastro = cadastroService.buscaPorId(id);
        if(cadastro != null){
            try{
                cadastroService.excluir(cadastro);
                rm.addFlashAttribute("sucesso","Cadastro deletado com sucesso!");
            }
            catch (Exception e){
                rm.addFlashAttribute("erro","Erro ao deletar cadastro!");
            }
        }
        return "redirect:/cadastro/listar";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"atualizar/{id}"})
    public String atualizar(@PathVariable("id") Long id, ModelMap map, RedirectAttributes rm) throws Exception{
        Cadastro cadastro = cadastroService.buscaPorId(id);

        map.addAttribute("cadastro",cadastro);
        map.addAttribute("parte",selectParte());

        return "/cadastro/novo";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"mostrar/{id}"})
    public String mostrar(@PathVariable("id") Long id, ModelMap map, RedirectAttributes rm) throws Exception{
        Cadastro cadastro = cadastroService.buscaPorId(id);

        map.addAttribute("cadastro",cadastro);
        map.addAttribute("parte",selectParte());

        return "/cadastro/mostrar";
    }

    public Map<Long, String> selectParte(){
        List<Parte> partes = parteService.listar();
        Map<Long, String> mapa = new HashMap();
        // mapa.put(0L,"Selecione");
        for(Parte parte:partes){
            mapa.put(parte.getId(), parte.getNome());
        }
        return mapa;
    }
}
