package br.com.gerenciarvacinas.gerenciar.controller;

import br.com.gerenciarvacinas.gerenciar.entities.Vacina;
import br.com.gerenciarvacinas.gerenciar.service.VacinaService;
import jakarta.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/vacinas")
public class VacinaController {

    @Autowired
    VacinaService vacinaService;

    // Método de Valodação e Exceções
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @GetMapping
    public List<Vacina> obterTodos() {
        return vacinaService.obterTodos();
    }

    @GetMapping("/obter/{id}")
    public ResponseEntity<Vacina> obterVacinaPorId(@PathVariable String id) {
        Optional<Vacina> vacina = vacinaService.findById(id);

        if (vacina.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(vacina.get());
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Vacina> inserir(@RequestBody @Valid Vacina vacina) {
        vacinaService.inserir(vacina);
        return ResponseEntity.created(null).body(vacina);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Vacina> atualizar(@RequestBody Vacina novosDadosVacina, @PathVariable String id) {
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

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<Vacina> remover(@PathVariable String id) {
        Optional<Vacina> vacina = vacinaService.findById(id);

        if (vacina.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        vacinaService.remove(id);

        return ResponseEntity.ok().body(null);
    }

}
