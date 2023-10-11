package br.com.gerenciarvacinas.gerenciar.controller;

import br.com.gerenciarvacinas.gerenciar.entities.Vacina;
import br.com.gerenciarvacinas.gerenciar.service.VacinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacinas")
public class VacinaController {

    @Autowired
    VacinaService vacinaService;

    @GetMapping
    public List<Vacina> obterTodos() {
        return vacinaService.obterTodos();
    }

    @GetMapping("/obter/{id}")
    public ResponseEntity<Vacina> obterVacinaPorId(@PathVariable int codigo) {
        Vacina vacina = vacinaService.selecionarVacinaPorCodigo(codigo);
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
    public ResponseEntity<Vacina> inserir(@RequestBody @Valid Vacina vacina) {
        vacinaService.inserir(vacina);
        return ResponseEntity.created(null).body(vacina);
    }

    @PutMapping("/editar/{codigo}")
    public ResponseEntity<Vacina> atualizar(@RequestBody Vacina novosDadosVacina, @PathVariable int codigo) {
        Vacina vacina = vacinaService.selecionarVacinaPorCodigo(codigo);

        if (vacina == null) {
            return ResponseEntity.notFound().build();
        }

        vacinaService.atualizar(codigo, novosDadosVacina);
        return ResponseEntity.ok().body(vacina);
    }

    @PatchMapping("/editar/dose/{id}")
    public ResponseEntity<Vacina> atualizarDose(@RequestParam("dose") int dose, @PathVariable int id) {
        Vacina vacina = vacinaService.selecionarVacinaPorCodigo(id);

        if (vacina == null) {
            return ResponseEntity.notFound().build();
        }

        vacina.setDoses(dose);

        vacinaService.atualizar(id, vacina);

        return ResponseEntity.ok().body(vacina);
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Vacina> remover(@PathVariable int id) {
        Vacina vacina = vacinaService.selecionarVacinaPorCodigo(id);

        if (vacina == null) {
            return ResponseEntity.notFound().build();
        }

        vacinaService.remove(id);

        return ResponseEntity.ok().body(null);
    }

}
