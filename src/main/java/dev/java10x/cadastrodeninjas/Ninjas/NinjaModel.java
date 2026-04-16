package dev.java10x.cadastrodeninjas.Ninjas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Table(name = "tb_cadastro")
@Data
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "img_URL")
    private String imgURL;

    @Column (name = "rank")
    private String rank;

    // ========== RELACIONAMENTO ==========

    @OneToMany
    @JsonIgnore  // ← Evita loop infinito no JSON
    private List<MissoesModel> missoes;
    // mappedBy = "ninja" significa: "O atributo 'ninja' em MissoesModel é quem controla este relacionamento"
    // Ou seja, a FK está na tabela de missões, não aqui
}