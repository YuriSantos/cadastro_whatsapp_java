package br.jus.jfpb.cadastro.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@SequenceGenerator(sequenceName="cadastro_seq", name="cadastro_id", allocationSize=1)
public class Cadastro extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cadastro_id")
    private Long id;

    Calendar data_cadastro = Calendar.getInstance();

    @Column
    private String nome;
    @ManyToOne
    private Parte parte;
    private String telefone;
    private String cpf;
    private String local;
    @ManyToOne
    private Usuario usuario;
    private String salvo_por;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(Calendar data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Parte getParte() {
        return parte;
    }

    public void setParte(Parte parte) {
        this.parte = parte;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getSalvo_por() {
        return salvo_por;
    }

    public void setSalvo_por(String salvo_por) {
        this.salvo_por = salvo_por;
    }
}
