package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // Listar todos os ninjas
    public List<NinjaDTO> listarNinjas() {
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }


    // Listar ninja por ID
    public NinjaDTO listarNinjaPorID(Long id) {
        Optional<NinjaDTO> ninjaDTO = ninjaRepository.findById(id)
                .map(ninjaMapper::map);
        return ninjaDTO.orElse(null);
    }

    // Criar novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO) {
        NinjaModel ninjaModel = ninjaMapper.map(ninjaDTO);
        NinjaModel salvo = ninjaRepository.save(ninjaModel);
        return ninjaMapper.map(salvo);
    }

    // Atualizar ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaAtualizado) {
        Optional<NinjaModel> ninjaModel = ninjaRepository.findById(id);
        if (ninjaModel.isPresent()) {
            NinjaModel ninja = ninjaModel.get();
            ninja.setNome(ninjaAtualizado.getNome());
            ninja.setEmail(ninjaAtualizado.getEmail());
            ninja.setIdade(ninjaAtualizado.getIdade());
            ninja.setImgURL(ninjaAtualizado.getImgURL());
            ninja.setRank(ninjaAtualizado.getRank());
            NinjaModel salvo = ninjaRepository.save(ninja);
            return ninjaMapper.map(salvo);
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