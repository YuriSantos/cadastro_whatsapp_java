package br.jus.jfpb.cadastro.service;

import br.jus.jfpb.cadastro.dao.ParteDAO;
import br.jus.jfpb.cadastro.model.Parte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ParteService {
    protected EntityManager manager;

    @Autowired
    private ParteDAO parteDAO;

    public void inserir(Parte parte){
        parteDAO.inserir(parte);
    }

    public void atualizar(Parte parte){
        parteDAO.atualizar(parte);
    }

    public void excluir(Parte parte){
        parteDAO.excluir(parte);
    }

    public Parte buscaPorId(Long id){
        Parte parte = null;
        parte = parteDAO.buscarPorID(id);
        return parte;
    }

    public List<Parte> listar(){
        return parteDAO.listar();
    }
}
