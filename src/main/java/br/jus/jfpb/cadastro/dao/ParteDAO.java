package br.jus.jfpb.cadastro.dao;

import br.jus.jfpb.cadastro.model.Parte;
import org.springframework.stereotype.Repository;

@Repository
public class ParteDAO extends AbstractDAO<Parte>{
    public ParteDAO(){
        super(Parte.class);
    }
}
