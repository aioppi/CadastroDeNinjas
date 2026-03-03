package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ninjas")  // Define o caminho base: /ninjas
public class NinjaController {


    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

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
    public List<NinjaModel> mostrarTodosOsNinjas() {
        return ninjaService.listarNinjas();

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