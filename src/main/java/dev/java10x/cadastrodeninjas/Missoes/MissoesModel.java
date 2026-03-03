package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb_missoes")
@Data
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeMissoes;

    private String dificuldadeMissoes;

    // ========== RELACIONAMENTO ==========

    @ManyToOne  // ← MUITAS missões para UM ninja
    @JoinColumn(name = "ninja_id")  // ← Cria coluna ninja_id aqui na tb_missoes
    private NinjaModel ninja;
    // @ManyToOne: Indica que várias missões podem pertencer ao mesmo ninja
    // @JoinColumn: Cria a coluna "ninja_id" nesta tabela (FK apontando para tb_cadastro.id)

    // ========== CONSTRUTORES ==========

    public MissoesModel() {
    }

    public MissoesModel(String nomeMissoes, String dificuldadeMissoes) {
        this.nomeMissoes = nomeMissoes;
        this.dificuldadeMissoes = dificuldadeMissoes;
    }
}