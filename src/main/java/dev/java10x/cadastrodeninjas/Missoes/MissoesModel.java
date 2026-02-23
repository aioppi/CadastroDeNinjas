package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMissoes;

    private String dificuldadeMissoes;

    // ========== RELACIONAMENTO ==========

    @ManyToOne
    @JoinColumn(name = "ninja_id")
    private NinjaModel ninja;
    // @ManyToOne - Muitas missões podem pertencer a um único ninja
    // @JoinColumn(name = "ninja_id") - Cria a coluna "ninja_id" na tabela tb_missoes (chave estrangeira)
    // Esta é a coluna que vai guardar o ID do ninja responsável por esta missão

    // ========== CONSTRUTORES ==========

    public MissoesModel() {
    }

    public MissoesModel(String nomeMissoes, String dificuldadeMissoes) {
        this.nomeMissoes = nomeMissoes;
        this.dificuldadeMissoes = dificuldadeMissoes;
    }

    // ========== GETTERS E SETTERS ==========

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
        return ninja;
    }

    public void setNinja(NinjaModel ninja) {
        this.ninja = ninja;
    }
}