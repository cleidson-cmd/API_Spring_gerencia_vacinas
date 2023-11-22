package br.com.gerenciarvacinas.gerenciar.controller;

import br.com.gerenciarvacinas.gerenciar.entity.Vacina;
import br.com.gerenciarvacinas.gerenciar.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vacinas")
public class VacinaController {
    @Autowired
    VacinaService vacinaService;

    @GetMapping
    public List<Vacina> obterTodos() {
        return vacinaService.obterTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vacina> obterVacinaPorId(@PathVariable String id) {
        Optional<Vacina> vacina = vacinaService.findById(id);

        if (vacina.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(vacina.get());
    }

    @PostMapping()
    public ResponseEntity<Vacina> inserir(@RequestBody @Valid Vacina vacina) throws Exception {
        if (vacinaService.inserir(vacina) == null) {
            return ResponseEntity.badRequest().body(vacina);
        }
        return ResponseEntity.created(null).body(vacina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vacina> atualizar(@RequestBody @Valid Vacina novosDadosVacina, @PathVariable String id) {
        Optional<Vacina> vacina = vacinaService.findById(id);

        if (vacina.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Vacina responseVacina = vacinaService.atualizar(id, novosDadosVacina);
        return ResponseEntity.ok().body(responseVacina);
    }

    @PatchMapping("/editar/dose/{id}")
    public ResponseEntity<Vacina> atualizarDose(@RequestParam("dose") int dose, @PathVariable String id) {
        Optional<Vacina> vacina = vacinaService.findById(id);

        if (vacina.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Vacina novosDadosDaVacina = vacina.get();

        novosDadosDaVacina.setDoses(dose);

        vacinaService.atualizar(id, novosDadosDaVacina);

        return ResponseEntity.ok().body(novosDadosDaVacina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Vacina> remover(@PathVariable String id) {
        Optional<Vacina> vacina = vacinaService.findById(id);

        if (vacina.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        vacinaService.remove(id);

        return ResponseEntity.ok().body(null);
    }

}
