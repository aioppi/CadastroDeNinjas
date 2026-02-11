package dev.java10x.cadastrodeninjas;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// Entity - Ele transforma a classe em uma entidade do banco de dados, permitindo que seja mapeada para uma tabela e persistida.

@Table(name  = "tb_cadastro")

// JPA - Java Persistence API, é uma especificação que define um conjunto de regras e padrões para o mapeamento de objetos
// Java para bancos de dados relacionais. Ele fornece uma maneira de gerenciar a persistência de dados em aplicações Java,
// permitindo que os desenvolvedores trabalhem com objetos Java em vez de lidar diretamente com consultas SQL.

public class NinjaModel {

    @Id
    @GeneratedValue (strategy = jakarta.persistence.GenerationType.IDENTITY)
    Long id;
    String nome;
    String email;
    int idade;

    public NinjaModel() {
    }

    public NinjaModel(String nome, String email, int idade) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

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
