package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os ninjas
    public List<NinjaModel> listarNinjas() {
        return ninjaRepository.findAll();
    }

    // Listar ninja por ID
    public NinjaModel listarNinjaPorID(Long id) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        return ninjaModel.orElse(null);
    }

    // Criar novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        NinjaModel salvo = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(salvo);
    }

    // Atualizar ninja
    public NinjaModel atualizarNinja(Long id, NinjaModel ninjaAtualizado) {
        NinjaModel ninja = listarNinjaPorID(id);
        if (ninjaRepository.existsById(id)) {
            ninja.setNome(ninjaAtualizado.getNome());
            ninja.setIdade(ninjaAtualizado.getIdade());
            ninja.setEmail(ninjaAtualizado.getEmail());
            ninja.setImgURL(ninjaAtualizado.getImgURL());
            ninja.setRank(ninjaAtualizado.getRank());
            return ninjaRepository.save(ninja);
        }
        return null;
    }

    // Deletar ninja
    public void deletarNinja(Long id) {
        ninjaRepository.deleteById(id);
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
*/