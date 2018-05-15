package br.jus.jfpb.cadastro.dao;

import br.jus.jfpb.cadastro.model.Cadastro;
import org.springframework.stereotype.Repository;

@Repository
public class CadastroDAO extends AbstractDAO<Cadastro>{
    public CadastroDAO(){
        super(Cadastro.class);
    }
}
