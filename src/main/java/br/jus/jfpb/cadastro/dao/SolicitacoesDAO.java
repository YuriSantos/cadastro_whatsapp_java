package br.jus.jfpb.cadastro.dao;

import br.jus.jfpb.cadastro.model.Solicitacoes;
import org.springframework.stereotype.Repository;

@Repository
public class SolicitacoesDAO extends AbstractDAO<Solicitacoes>{
    public SolicitacoesDAO(){
        super(Solicitacoes.class);
    }
}
