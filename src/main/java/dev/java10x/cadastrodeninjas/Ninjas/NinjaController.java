package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping

public class NinjaController {

    @GetMapping ("/boasvindas")// Pegar anotação para criar uma rota do tipo GET, ou seja, para receber requisições do tipo GET.

    public String boasvindas () {
        return "Essa é minha primeira mensagem nessa rota!";
    }


}
