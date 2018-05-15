package br.jus.jfpb.cadastro.service;

import br.jus.jfpb.cadastro.dao.SolicitacoesDAO;
import br.jus.jfpb.cadastro.model.Solicitacoes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SolicitacoesService {
    @Autowired
    private SolicitacoesDAO solicitacoesDAO;

    public void inserir(Solicitacoes solicitacoes){
        solicitacoesDAO.inserir(solicitacoes);
    }

    public void atualizar(Solicitacoes solicitacoes){
        solicitacoesDAO.atualizar(solicitacoes);
    }

    public void excluir(Solicitacoes solicitacoes){
        solicitacoesDAO.excluir(solicitacoes);
    }

    public Solicitacoes buscaPorId(Long id){
        Solicitacoes solicitacoes = null;
        solicitacoes = solicitacoesDAO.buscarPorID(id);
        return solicitacoes;
    }

    public List<Solicitacoes> listar(){
        return solicitacoesDAO.listar();
    }
}
