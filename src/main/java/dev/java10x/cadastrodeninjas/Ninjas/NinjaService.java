package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service

public class NinjaService {


    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // Listar todos os ninjas por ID

    public NinjaModel listarNinjaPorID(Long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }
     // Criar novo ninja

    public NinjaModel criarNinja(NinjaModel ninja) {
        return ninjaRepository.save(ninja);

    }


}









/*
    // Listar todos os ninjas
    public List<NinjaModel> listarTodos() {
        return ninjaRepository.findAll();
    }

    // Buscar ninja por ID
    public NinjaModel buscarPorId(Long id) {
        return ninjaRepository.findById(id).orElse(null);
    }

    // Criar novo ninja
    public NinjaModel criar(NinjaModel ninja) {
        return ninjaRepository.save(ninja);
    }

    // Atualizar ninja
    public NinjaModel atualizar(Long id, NinjaModel ninjaAtualizado) {
        NinjaModel ninja = buscarPorId(id);
        if (ninja != null) {
            ninja.setNome(ninjaAtualizado.getNome());
            ninja.setEmail(ninjaAtualizado.getEmail());
            ninja.setIdade(ninjaAtualizado.getIdade());
            ninja.setImgURL(ninjaAtualizado.getImgURL());
            return ninjaRepository.save(ninja);
        }
        return null;
    }

    // Deletar ninja
    public void deletar(Long id) {
        ninjaRepository.deleteById(id);
    }
}*/