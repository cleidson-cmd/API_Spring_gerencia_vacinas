package br.com.gerenciarvacinas.gerenciar.service;

import br.com.gerenciarvacinas.gerenciar.entity.Vacina;
import br.com.gerenciarvacinas.gerenciar.repository.VacinaRepository;
import br.com.gerenciarvacinas.gerenciar.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.*;

import java.util.List;
import java.util.Optional;


@Service
public class VacinaService {

    @Autowired
    VacinaRepository vacinaRepository;

    public List<Vacina> obterTodos() {
        return vacinaRepository.findAll();
    }

    public ResponseEntity<Map<String, Vacina>> inserir(Vacina vacina) {
        //caso a vacina não seja doze unica o intervalo entre doze é obrigatório.
        Map<String, Vacina> response = new HashMap();
        Date dataAtual = new Date();
        if (vacina.getValidade().after(dataAtual)) {
            if (vacina.getDoses() > 1) {
                if (vacina.getIntervaloEntreDoses() < 1) {
                    response.put("Vacina com mais de 1 doze é obrigatório o intervalo entre doses maior que 1!", (Vacina) vacina);
                    return ResponseEntity.badRequest().body(response);//aqui retorna obrigatoriedade do intervalo entre vacinas ja que não é doze unica
                } else {
                    vacinaRepository.insert(vacina);
                }
            } else {
                vacinaRepository.insert(vacina);
            }
            response.put("Gravado com sucesso!", (Vacina) vacina);
            return ResponseEntity.created(null).body(response);

        }
        response.put("Vacina Com validade vencida.", (Vacina) vacina);
        return ResponseEntity.badRequest().body(response);
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

    public List<Vacina> listarVacinasPorFabricante(String fabricante) {
        return vacinaRepository.findByFabricante(fabricante);
    }

    /*
     * public List<Vacina> listarVacinasPorFabricanteEEstado(String fabricante,
     * String estado) {
     * return vacinaRepository.findByFabricanteAndEstado(fabricante, estado);
     * }
     */

}
