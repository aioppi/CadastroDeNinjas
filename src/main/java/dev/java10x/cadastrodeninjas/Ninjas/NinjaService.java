package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NinjaService {

    @Autowired
    private NinjaRepository ninjaRepository;

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
}