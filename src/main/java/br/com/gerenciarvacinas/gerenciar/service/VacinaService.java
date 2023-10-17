package br.com.gerenciarvacinas.gerenciar.service;

import br.com.gerenciarvacinas.gerenciar.entities.Vacina;
import br.com.gerenciarvacinas.gerenciar.repository.VacinaRepository;
import br.com.gerenciarvacinas.gerenciar.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@Service
public class VacinaService {

    @Autowired
    VacinaRepository vacinaRepository;

    public List<Vacina> obterTodos() {
        return vacinaRepository.findAll();
    }

    public Vacina inserir(Vacina vacina) {
        vacinaRepository.insert(vacina);
        return vacina;
    }

    public Vacina atualizar(String id, Vacina novosDadosDaVacina) {
        Optional<Vacina> vacina = findById(id);

        if (vacina.isPresent()) {
            Vacina novaVacina = vacina.get();
            novaVacina.setCodigo(novosDadosDaVacina.getCodigo());
            novaVacina.setNome(novosDadosDaVacina.getNome());
            novaVacina.setFabricante(novosDadosDaVacina.getFabricante());
            novaVacina.setLote(novosDadosDaVacina.getLote());
            novaVacina.setValidade(novosDadosDaVacina.getValidade());
            novaVacina.setDoses(novosDadosDaVacina.getDoses());
            novaVacina.setIntervaloEntreDoses(novosDadosDaVacina.getIntervaloEntreDoses());
            vacinaRepository.save(novaVacina);
            return novaVacina;
        }
        return null;

    }

    public void remove(String id) {
        Optional<Vacina> vacina = findById(id);

        vacina.ifPresent(value -> vacinaRepository.delete(value));
    }

    public Optional<Vacina> findById(String id) {
        Optional<Vacina> vacina = vacinaRepository.findById(id);

        Vacina entity = vacina.orElseThrow(() -> new EntityNotFoundException("Registro Não Lacalizado!"));

        return Optional.ofNullable(entity);
    }

}
