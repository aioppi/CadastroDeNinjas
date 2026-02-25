package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ninjas")  // Define o caminho base: /ninjas
public class NinjaController {

    @Autowired
    private NinjaService ninjaService;

    // GET /ninjas/boasvindas
    @GetMapping("/boasvindas")
    public String boasvindas() {
        return "Essa é minha primeira mensagem nessa rota!";
    }

    // Adiciona Ninja (CREATE)
    @PostMapping("/criar")
    public String criarNinja() {
        return "Ninja criado com sucesso!";
    }

    // Mostrar todos os ninjas (READ)
    @GetMapping("/listar")
    public String mostrarTodosOsNinjas() {
        return "Mostrar Ninjas!";
    }

    // Mostrar ninja por ID (READ)
    @GetMapping("/listarID")
    public String mostrarNinjaPorID() {
        return "Mostrar Ninja por ID!";
    }

    // Alterar dados do ninja (UPDATE)
    @PutMapping("/alterarID")
    public String alterarNinja() {
        return "Ninja alterado com sucesso!";
    }

    // Deletar ninja (DELETE)
    @DeleteMapping("/deletarID")
    public String deletarNinja() {
        return "Ninja deletado com sucesso!";
    }
}