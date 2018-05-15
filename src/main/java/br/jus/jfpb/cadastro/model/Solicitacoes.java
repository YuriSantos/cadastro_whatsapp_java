package br.jus.jfpb.cadastro.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@SequenceGenerator(sequenceName="solicitacao_seq", name="solicitacao_id", allocationSize=1)
public class Solicitacoes extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "solicitacao_id")
    private Long id;
    @Temporal(TemporalType.DATE)
    Calendar data_cadastro = Calendar.getInstance();

    @ManyToOne
    private Cadastro cadastro;
    private String Observacoes;
    private String Motivo;
    private int Tipo_Solicitacao;
    private String salvo_por;
    @Transient
    private String TSocilicitacao;

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

    public Cadastro getCadastro() {
        return cadastro;
    }

    public void setCadastro(Cadastro cadastro) {
        this.cadastro = cadastro;
    }

    public String getObservacoes() {
        return Observacoes;
    }

    public void setObservacoes(String observacoes) {
        Observacoes = observacoes;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String motivo) {
        Motivo = motivo;
    }

    public int getTipo_Solicitacao() {
        return Tipo_Solicitacao;
    }

    public void setTipo_Solicitacao(int tipo_Solicitacao) {
        Tipo_Solicitacao = tipo_Solicitacao;
    }

    public String getSalvo_por() {
        return salvo_por;
    }

    public void setSalvo_por(String salvo_por) {
        this.salvo_por = salvo_por;
    }

    public String getTSocilicitacao(){
        List<String> list = new ArrayList<String>(){{
            add("Não Informado");
            add("Exclusão");
            add("Alteração");
        }};

        return list.get(this.Tipo_Solicitacao);
    }
}
