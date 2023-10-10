package br.com.gerenciarvacinas.gerenciar.service;

import br.com.gerenciarvacinas.gerenciar.entities.Vacina;
import br.com.gerenciarvacinas.gerenciar.repository.VacinaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Vacina atualizar(int id, Vacina novosDadosDaVacina) {
        Vacina vacina = selecionarVacinaPeloId(id);

        if (vacina != null) {
            BeanUtils.copyProperties(novosDadosDaVacina, vacina);
            vacinaRepository.save(vacina);
        }

        return vacina;
    }

    public void remove(int id) {
        Vacina vacina = selecionarVacinaPeloId(id);

        if (vacina != null) {
            vacinaRepository.delete(vacina);
        }
    }

    public Vacina selecionarVacinaPeloId(int id) {
        Vacina vacina = vacinaRepository.findById(id);

        return vacina;
    }

}
