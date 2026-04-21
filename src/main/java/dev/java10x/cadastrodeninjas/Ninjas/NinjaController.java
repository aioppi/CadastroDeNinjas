package dev.java10x.cadastrodeninjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Rota de boas-vindas", description = "Retorna uma mensagem de boas-vindas para os usuários que acessarem essa rota.")
    public String boasvindas() {
        return "Essa é minha primeira mensagem nessa rota!";
    }
    @ApiResponse(responseCode = "201", description = "Ninja criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Requisição inválida")

    // POST /ninjas/criar
    @PostMapping("/criar")
    @Operation(summary = "Criar um novo ninja", description = "Permite criar um novo ninja fornecendo os detalhes necessários no corpo da requisição.")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninjaDTO) {
        NinjaDTO novoNinja = ninjaService.criarNinja(ninjaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso! " + novoNinja.getNome() + " (ID): " + novoNinja.getId().toString());
    }

    // GET /ninjas/listar
    @GetMapping("/listar")
    @Operation(summary = "Listar todos os ninjas", description = "Retorna uma lista de todos os ninjas cadastrados no sistema.")
    public ResponseEntity <List<NinjaDTO>> listarNinjas() {
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.status(HttpStatus.OK).body(ninjas);
    }

    // GET /ninjas/listar/{id}
    @GetMapping("/listar/{id}")
    @Operation(summary = "Listar ninja por ID", description = "Retorna os detalhes de um ninja específico com base no ID fornecido na URL.")
    public ResponseEntity <String> mostrarNinjaPorID(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body("Ninja encontrado! " + ninjaService.listarNinjaPorID(id).getNome() + " (ID): " + id);
    }

    // PUT /ninjas/alterar/{id}
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Alterar ninja por ID", description = "Permite atualizar os detalhes de um ninja específico com base no ID fornecido na URL e nos novos dados fornecidos no corpo da requisição.")
    public ResponseEntity <String> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body("Ninja atualizado com sucesso! " + ninjaService.atualizarNinja(id, ninjaDTO).getNome() + " (ID): " + id.toString());
    }

    // DELETE /ninjas/deletar/{id}
    @DeleteMapping("/deletar/{id}")
    @Operation(summary = "Deletar ninja por ID", description = "Permite deletar um ninja específico com base no ID fornecido na URL.")
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

