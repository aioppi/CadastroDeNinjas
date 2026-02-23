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

    // GET /ninjas - Lista todos os ninjas
    @GetMapping
    public List<NinjaModel> listarTodos() {
        return ninjaService.listarTodos();
    }

    // GET /ninjas/{id} - Busca ninja por ID
    @GetMapping("/{id}")
    public NinjaModel buscarPorId(@PathVariable Long id) {
        return ninjaService.buscarPorId(id);
    }

    // POST /ninjas - Cria novo ninja
    @PostMapping
    public NinjaModel criar(@RequestBody NinjaModel ninja) {
        return ninjaService.criar(ninja);
    }

    // PUT /ninjas/{id} - Atualiza ninja
    @PutMapping("/{id}")
    public NinjaModel atualizar(@PathVariable Long id, @RequestBody NinjaModel ninja) {
        return ninjaService.atualizar(id, ninja);
    }

    // DELETE /ninjas/{id} - Deleta ninja
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        ninjaService.deletar(id);
    }
}