package dev.java10x.cadastrodeninjas.Ninjas;

import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

/**
 * O que é Lombok?
 * É uma biblioteca que gera código "chato" automaticamente em tempo de compilação. 
 * Você só coloca anotações e ele cria os métodos por baixo dos panos.
 */

@Entity
// Entity - Ele transforma a classe em uma entidade do banco de dados, ou seja, uma TABELA... 
// (permitindo que seja mapeada para uma tabela e persistida).
// Entity é uma anotação usada para marcar uma classe como uma entidade do banco de dados, indicando que ela deve ser mapeada para
// uma tabela e persistida. Ela é parte da especificação JPA (Java Persistence API) e é usada para definir classes que representam
// tabelas em um banco de dados relacional.
// Simplificando, o que é uma entidade? É uma classe que representa uma tabela no banco de dados, e cada instância dessa classe
// representa uma linha nessa tabela.

@Table(name = "tb_cadastro")
// Table - Especifica o nome da tabela no banco de dados que será usada para armazenar os dados da entidade. 
// No caso, a tabela será chamada "tb_cadastro".

// JPA - Java Persistence API, é uma especificação que define um conjunto de regras e padrões para o mapeamento de objetos
// Java para bancos de dados relacionais. Ele fornece uma maneira de gerenciar a persistência de dados em aplicações Java,
// permitindo que os desenvolvedores trabalhem com objetos Java em vez de lidar diretamente com consultas SQL.

@Data
// @Data - É uma anotação do Lombok que gera automaticamente os métodos getters, setters, equals, hashCode e toString
// para os campos da classe. Isso reduz a quantidade de código boilerplate necessário para criar esses métodos manualmente.

public class NinjaModel {

    // ========== IDENTIFICADOR ==========

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @Id - Marca este campo como chave primária da tabela
    // @GeneratedValue - Define que o valor será gerado automaticamente pelo banco de dados (auto-increment)

    // ========== ATRIBUTOS BÁSICOS ==========

    private String nome;

    @Column(unique = true)
    private String email;
    // @Column(unique = true) - Especifica que a coluna "email" deve ser única no banco de dados, ou seja, 
    // não pode haver dois ninjas com o mesmo email.
    // Column - Especifica detalhes adicionais sobre a coluna no banco de dados. No caso, a anotação @Column(unique = true) indica que
    // a coluna "email" deve ser única, ou seja, não pode haver dois ninjas com o mesmo email.
    // No mundo real, isso seria utilizado para proteger um cpf, ou seja, não pode haver dois ninjas com o mesmo cpf, 
    // ou seja, com o mesmo email.

    @Column(name = "idade")
    private int idade;
    // @Column(name = "idade") - Especifica o nome exato da coluna no banco de dados
    // Se não especificar, o JPA usa o nome do atributo Java automaticamente

    @Column(name = "img_URL")
    private String imgURL;

    // ========== RELACIONAMENTOS ==========

    @OneToMany(mappedBy = "ninja")
    private List<MissoesModel> missoes;
    // @OneToMany - Indica que há uma relação de um para muitos entre a entidade atual e outra entidade. 
    // Isso significa que um ninja pode ter várias missões associadas a ele.
    // mappedBy = "ninja" - Indica que o lado "dono" do relacionamento está na classe MissoesModel, 
    // no atributo chamado "ninja". Ou seja, a tabela de missões (tb_missoes) tem a chave estrangeira, não esta tabela.
    // A chave estrangeira fica na tabela de missões apontando para o ninja.

    // ========== CONSTRUTORES ==========

    // NoArgs constructor - É um construtor que não recebe nenhum argumento. Ele é necessário para que o JPA 
    // possa criar instâncias da entidade.
    // O Lombok (@Data) já gera este construtor automaticamente.

    // Lombok (@Data) também gera automaticamente:
    // - Getters e Setters para todos os campos
    // - toString()
    // - equals() e hashCode()

    // Sobrecarga de construtor - É a prática de criar múltiplos construtores em uma classe, cada um com uma
    // assinatura diferente (número e tipo de parâmetros). Isso permite que os objetos sejam criados de maneiras
    // diferentes, dependendo das necessidades do contexto.
    // Exemplo: você pode ter um construtor que recebe apenas nome e email, outro que recebe nome, email e idade, etc.
}