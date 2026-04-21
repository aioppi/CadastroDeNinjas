package dev.java10x.cadastrodeninjas.Missoes;

//Controller é a camada mais proxima do usuario, praticamente um garcom, ele recebe
// as requisições do cliente, processa e retorna a resposta. Ele é responsável por lidar com as rotas e as
// requisições HTTP, e chamar os serviços para realizar as operações necessárias como criar, ler, atualizar ou
// deletar dados. Ele é a ponte entre o cliente e a lógica de negócios da aplicação, garantindo que as requisições sejam
// tratadas corretamente e que as respostas sejam enviadas de volta ao cliente de forma adequada.

import org.springframework.web.bind.annotation.*;

@RestController // @RestController - Indica que esta classe é um controlador REST, ou seja, ela lida com requisições HTTP e retorna respostas em formato JSON ou XML.
@RequestMapping("missoes") // @RequestMapping - Especifica a rota base para as requisições que serão tratadas por este controlador.
// No caso, a rota base é "/missoes", ou seja, todas as rotas definidas neste controlador começarão com "/missoes". Ele ira rastreando as API's, ou seja, as rotas,
// e quando chegar em uma rota que começa com "/missoes", ele vai direcionar a requisição para este controlador.
public class MissoesController {

    // GET - Listar missões
    @GetMapping("/listar")
    public String listarMissoes() {
        // Lógica para listar as missões
        return "Missoes Listadas com sucesso!";
    }

    // POST - Criar missão
    @PostMapping("/criar")
    public String criarMissao() {
        // Lógica para criar uma missão
        return "Missão criada com sucesso!";
    }

    // PUT - Alterar missão
    @PutMapping("/alterar")
    public String alterarMissao() {
        // Lógica para alterar uma missão
        return "Missão alterada com sucesso!";
    }

    // DELETE - Deletar missão
    @DeleteMapping("/deletar")
    public String deletarMissao() {
        // Lógica para deletar uma missão
        return "Missão deletada com sucesso!";
    }
}
// Com isso se cria as rotas para as missões, ou seja, para listar as missões, criar uma missão, alterar uma missão e deletar uma missão.
// Exemplo: missoes/listar -> para listar as missões,
// missoes/criar -> para criar uma missão,
// missoes/alterar -> para alterar uma missão,
// missoes/deletar -> para deletar uma missão.