package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;

@Entity
@Table (name = "tb_missoes")

public class MissoesModel {

    @Id
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)

    private Long id;

    private String nomeMissoes;

    private String dificuldadeMissoes;

    @OneToMany (mappedBy = "missoes")

    // Uma missao pode ter muitos ninjas, ou seja, um ninja pode estar associado a várias missões, mas cada missão pode ter apenas um ninja associado a ela.
    private List<NinjaModel> ninja;

    public MissoesModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeMissoes() {
        return nomeMissoes;
    }

    public void setNomeMissoes(String nomeMissoes) {
        this.nomeMissoes = nomeMissoes;
    }

    public String getDificuldadeMissoes() {
        return dificuldadeMissoes;
    }

    public void setDificuldadeMissoes(String dificuldadeMissoes) {
        this.dificuldadeMissoes = dificuldadeMissoes;
    }

    public NinjaModel getNinja() {
        return (NinjaModel) ninja;
    }

    public void setNinja(NinjaModel ninja) {
        this.ninja = Collections.singletonList(ninja);
    }
}
