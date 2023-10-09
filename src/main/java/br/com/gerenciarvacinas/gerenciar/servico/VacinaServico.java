package br.com.gerenciarvacinas.gerenciar.servico;

import br.com.gerenciarvacinas.gerenciar.entidade.Vacina;
import br.com.gerenciarvacinas.gerenciar.repositorio.VacinaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacinaServico {

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
