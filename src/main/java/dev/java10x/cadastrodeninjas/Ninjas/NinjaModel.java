package dev.java10x.cadastrodeninjas.Ninjas;

import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
// Entity - Ele transforma a classe em uma entidade do banco de dados, permitindo que seja mapeada para uma tabela e persistida.
// Entity é uma anotação usada para marcar uma classe como uma entidade do banco de dados, indicando que ela deve ser mapeada para
// uma tabela e persistida. Ela é parte da especificação JPA (Java Persistence API) e é usada para definir classes que representam
// tabelas em um banco de dados relacional.
// Simplificando, o que é uma entidade? É uma classe que representa uma tabela no banco de dados, e cada instância dessa classe
// representa uma linha nessa tabela.

@Table(name  = "tb_cadastro")

// JPA - Java Persistence API, é uma especificação que define um conjunto de regras e padrões para o mapeamento de objetos
// Java para bancos de dados relacionais. Ele fornece uma maneira de gerenciar a persistência de dados em aplicações Java,
// permitindo que os desenvolvedores trabalhem com objetos Java em vez de lidar diretamente com consultas SQL.

public class NinjaModel {

    @Id
    @OneToMany(mappedBy = "ninja")
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private int idade;

    //@manytoone - Indica que há uma relação de muitos para um entre a entidade atual e outra entidade. Isso significa
    // que muitos objetos da entidade atual podem estar associados a um único objeto da outra entidade.
    @ManyToOne
    @JoinColumn(name = "missoes_id") // Especifica a coluna de junção que será usada para estabelecer a relação entre
    // as entidades. No caso, a coluna "missoes_id" na tabela do banco de dados será usada para associar os ninjas às missões. - Chave estrangeira
    private List<MissoesModel> missoes;


    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    //Sobrecarga de construtor - É a prática de criar múltiplos construtores em uma classe, cada um com uma
    // assinatura diferente (número e tipo de parâmetros). Isso permite que os objetos sejam criados de maneiras
    // diferentes, dependendo das necessidades do contexto.

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
