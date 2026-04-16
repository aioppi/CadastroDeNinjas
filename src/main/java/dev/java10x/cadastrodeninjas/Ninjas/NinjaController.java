package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // GET /ninjas/boasvindas
    @GetMapping("/boasvindas")
    public String boasvindas() {
        return "Essa é minha primeira mensagem nessa rota!";
    }

    // POST /ninjas/criar
    @PostMapping("/criar")
    public NinjaDTO criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        return ninjaService.criarNinja(ninjaDTO);
    }

    // GET /ninjas/listar
    @GetMapping("/listar")
    public List<NinjaModel> mostrarTodosOsNinjas() {
        return ninjaService.listarNinjas();
    }

    // GET /ninjas/listar/{id}
    @GetMapping("/listar/{id}")
    public NinjaModel mostrarNinjaPorID(@PathVariable long id) {
        return ninjaService.listarNinjaPorID(id);
    }

    // PUT /ninjas/alterar/{id}
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaModel) {
        return ninjaService.atualizarNinja(id, ninjaModel);
    }

    // DELETE /ninjas/deletar/{id}
    @DeleteMapping("/deletar/{id}")
    public String deletarNinja(@PathVariable Long id) {
        ninjaService.deletarNinja(id);
        return "Ninja deletado com sucesso!";
    }
}