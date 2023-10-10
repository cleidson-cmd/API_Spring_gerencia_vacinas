package br.com.gerenciarvacinas.gerenciar.controller;

import br.com.gerenciarvacinas.gerenciar.entities.Vacina;
import br.com.gerenciarvacinas.gerenciar.service.VacinaServico;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacinas")
public class VacinaController {

    @Autowired
    VacinaServico vacinaServico;

    @GetMapping
    public List<Vacina> obterTodos() {
        return vacinaServico.obterTodos();
    }

    @GetMapping("/obter/{id}")
    public ResponseEntity<Vacina> obterVacinaPorId(@PathVariable int id) {
        Vacina vacina = vacinaServico.selecionarVacinaPeloId(id);
        /*
            if (vacina.getId() == id) {
                vacinaSelecionada = vacina;
            }
        }*/
        if (vacina == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(vacina);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Vacina> inserir(@Valid @RequestBody Vacina vacina) {
        vacinaServico.inserir(vacina);
        return ResponseEntity.created(null).body(vacina);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Vacina> atualizar(@RequestBody Vacina novosDadosVacina, @PathVariable int id) {
        Vacina vacina = vacinaServico.selecionarVacinaPeloId(id);

        if (vacina == null) {
            return ResponseEntity.notFound().build();
        }

        vacinaServico.atualizar(id, novosDadosVacina);
        return ResponseEntity.ok().body(vacina);
    }

    @PatchMapping("/editar/dose/{id}")
    public ResponseEntity<Vacina> atualizarDose(@RequestParam("dose") double dose, @PathVariable int id) {
        Vacina vacina = vacinaServico.selecionarVacinaPeloId(id);

        if (vacina == null) {
            return ResponseEntity.notFound().build();
        }

        vacina.setDoses(dose);

        vacinaServico.atualizar(id, vacina);

        return ResponseEntity.ok().body(vacina);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Vacina> remover(@PathVariable int id) {
        Vacina vacina = vacinaServico.selecionarVacinaPeloId(id);

        if (vacina == null) {
            return ResponseEntity.notFound().build();
        }

        vacinaServico.remove(id);

        return ResponseEntity.ok().body(null);
    }

}
