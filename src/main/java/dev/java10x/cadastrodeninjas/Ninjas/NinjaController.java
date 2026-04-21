package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.cert.Extension;
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
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso! " + novoNinja.getNome() + " (ID): " + novoNinja.getId().toString());
    }

    // GET /ninjas/listar
    @GetMapping("/listar")
    public ResponseEntity <List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.status(HttpStatus.OK).body(ninjas);
    }

    // GET /ninjas/listar/{id}
    @GetMapping("/listar/{id}")
    public ResponseEntity <String> mostrarNinjaPorID(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body("Ninja encontrado! " + ninjaService.listarNinjaPorID(id).getNome() + " (ID): " + id);
    }

    // PUT /ninjas/alterar/{id}
    @PutMapping("/alterar/{id}")
    public ResponseEntity <String> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body("Ninja atualizado com sucesso! " + ninjaService.atualizarNinja(id, ninjaDTO).getNome() + " (ID): " + id.toString());
    }

    // DELETE /ninjas/deletar/{id}
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity <String> deletarNinjaPorID(@PathVariable Long id) {

        if (ninjaService.listarNinjaPorID(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com ID " + id + " não encontrado.");
        } else {
            NinjaDTO ninjaDTO = ninjaService.listarNinjaPorID(id);
            ninjaService.deletarNinja(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Ninja deletado com sucesso! " + ninjaDTO.getNome() + " (ID): " + ninjaDTO.getId().toString());
        }
    }
}