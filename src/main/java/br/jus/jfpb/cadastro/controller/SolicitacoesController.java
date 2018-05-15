package br.jus.jfpb.cadastro.controller;

import br.jus.jfpb.cadastro.excecao.CampoVazioEx;
import br.jus.jfpb.cadastro.excecao.TamanhoEX;
import br.jus.jfpb.cadastro.model.Cadastro;
import br.jus.jfpb.cadastro.model.Solicitacoes;
import br.jus.jfpb.cadastro.service.CadastroService;
import br.jus.jfpb.cadastro.service.SolicitacoesService;
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
@RequestMapping("solicitacoes")
public class SolicitacoesController {

    @Autowired
    private SolicitacoesService solicitacoesService;
    @Autowired
    private CadastroService cadastroService;
    @RequestMapping("excluir/listar")
    public String listarExcluir(ModelMap map){

        List<Solicitacoes> solicitacoes = solicitacoesService.listar();
        map.addAttribute("solicitacao_excluir",solicitacoes);

        return "/solicitacoes/excluir/listar";

    }

    @RequestMapping(method = RequestMethod.GET, value = {"excluir/novo"})
    public String novoExcluir(ModelMap map){
        Solicitacoes solicitacoes = new Solicitacoes();

        map.addAttribute("solicitacoes",solicitacoes);
        map.addAttribute("cadastro",selectCadastro());

        return "/solicitacoes/excluir/novo";
    }

    @RequestMapping("listar")
    public String listarAlterar(ModelMap map){

        List<Solicitacoes> solicitacoes = solicitacoesService.listar();
        map.addAttribute("solicitacao",solicitacoes);

        return "solicitacoes/listar";

    }

    @RequestMapping(method = RequestMethod.GET, value = {"alterar/novo"})
    public String novoAlterar(ModelMap map){
        Solicitacoes solicitacoes = new Solicitacoes();

        map.addAttribute("solicitacoes",solicitacoes);
        map.addAttribute("cadastro",selectCadastro());

        return "/solicitacoes/alterar/novo";
    }

    @RequestMapping(method = RequestMethod.POST, value = {"salvar"})
    public String salvar (@ModelAttribute("solicitacoes") Solicitacoes solicitacoes, RedirectAttributes rm){

        try{
            if(solicitacoes.getCadastro().getNome().equals(null) || solicitacoes.getCadastro().getNome().equals("")) throw new CampoVazioEx("Selecione um nome válido.");
            if(solicitacoes.getObservacoes().length() < 15) throw new TamanhoEX("Tamanho mínimo da solicitação é de 15 caracteres");
            if(solicitacoes.getObservacoes().length() > 1000) throw new TamanhoEX("Tamanho máximo da solicitação é de 1000 caracteres");
            if(solicitacoes.getObservacoes().equals(null) || solicitacoes.getObservacoes().equals("")) throw  new CampoVazioEx("O motivo da solicitação não pode estar vazio.");
            if(solicitacoes.temIdValido()){
                solicitacoesService.atualizar(solicitacoes);
                rm.addFlashAttribute("sucesso","Cadastro atualizado com sucesso!");
            }
            else{
                solicitacoesService.inserir(solicitacoes);
                rm.addFlashAttribute("sucesso","Solicitação enviada com sucesso!");
            }
        }catch (CampoVazioEx e){
            rm.addFlashAttribute(e.getMessage());
        }catch (TamanhoEX e){
            rm.addFlashAttribute(e.getMessage());
        }
        catch (Exception e){
            rm.addFlashAttribute("erro","Erro ao salvar o cadastro!");
        }

        return "redirect:/cadastro/listar";
    }

    @RequestMapping(method = RequestMethod.GET, value = {"deletar/{id}"})
    public String remover(@PathVariable("id") Long id, RedirectAttributes rm){
        Solicitacoes solicitacoes = solicitacoesService.buscaPorId(id);
        if(solicitacoes != null){
            try{
                solicitacoesService.excluir(solicitacoes);
                rm.addFlashAttribute("sucesso","Solicitação deletada com sucesso!");
            }
            catch (Exception e){
                rm.addFlashAttribute("erro","Erro ao deletar cadastro!");
            }
        }
        return "redirect:/cadastro/listar";
    }

    public Map<Long, String> selectCadastro(){
        List<Cadastro> cadastros= cadastroService.listar();
        Map<Long, String> mapa = new HashMap();
        // mapa.put(0L,"Selecione");
        for(Cadastro cadastro:cadastros){
            mapa.put(cadastro.getId(), cadastro.getNome());
        }
        return mapa;
    }

}
