package br.jus.jfpb.cadastro.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Inheritance(strategy= InheritanceType.JOINED)
@SequenceGenerator(sequenceName="parte_seq", name="parte_id", allocationSize=1)
public class Parte extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "parte_id")
    private Long id;

    @Column
    private String nome;

    private String salvo_por;

    Calendar data_cadastro = Calendar.getInstance();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSalvo_por() {
        return salvo_por;
    }

    public void setSalvo_por(String salvo_por) {
        this.salvo_por = salvo_por;
    }
}
