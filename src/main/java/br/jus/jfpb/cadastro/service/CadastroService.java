package br.jus.jfpb.cadastro.service;

import br.jus.jfpb.cadastro.dao.CadastroDAO;
import br.jus.jfpb.cadastro.model.Cadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CadastroService {
    protected EntityManager manager;

    @Autowired
    private CadastroDAO cadastroDAO;

    public void inserir(Cadastro cadastro) throws Exception{
        cadastroDAO.inserir(cadastro);
    }

    public void atualizar(Cadastro cadastro) throws Exception{
        cadastroDAO.atualizar(cadastro);
    }

    public void excluir(Cadastro cadastro) throws Exception{
        cadastroDAO.excluir(cadastro);
    }

    public Cadastro buscaPorId(Long id){
        Cadastro cadastro = null;
        cadastro = cadastroDAO.buscarPorID(id);
        return cadastro;
    }

    public List<Cadastro> listar(){
        return cadastroDAO.listar();
    }


}
