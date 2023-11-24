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

    @GetMapping("/buscar")
    public List<Vacina> buscarVacinasPorNome(@RequestParam(value = "nome", required = false) String nome) {

        if (nome == null || nome.isEmpty()) {
            // retornando uma lista vazia
            return List.of();
        }

        // Chamando o serviço para buscar vacinas pelo nome, ignorando espaços e diferenças de caixa
        return vacinaService.buscarPorNomeIgnoringCaseAndSpaces(nome);
    }


    @PostMapping
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
