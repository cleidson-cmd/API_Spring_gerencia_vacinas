package br.com.gerenciarvacinas.gerenciar.controller;

import br.com.gerenciarvacinas.gerenciar.entity.Vacina;
import br.com.gerenciarvacinas.gerenciar.service.VacinaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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

    @GetMapping("/obter/{id}")
    public ResponseEntity<Vacina> obterVacinaPorId(@PathVariable String id) {
        Optional<Vacina> vacina = vacinaService.findById(id);

        if (vacina.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(vacina.get());
    }

    @PostMapping("/cadastrar")//@RequestBody @Valid
    public ResponseEntity<Map<String, Vacina>> inserir(@RequestBody Vacina vacina) {
        return vacinaService.inserir(vacina);
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

    @GetMapping("/obter/fabricante/{fabricante}")
    public List<Vacina> listarPorFabricante(@PathVariable String fabricante) {
        return vacinaService.listarVacinasPorFabricante(fabricante);
    }

    /*
     * @GetMapping("/fabricante/estado/{fabricante}")
     * public List<Vacina> listarPorFabricanteEEstado(@PathVariable String
     * fabricante,
     * 
     * @RequestParam(required = false) String estado) {
     * if (estado != null) {
     * return vacinaService.listarVacinasPorFabricanteEEstado(fabricante, estado);
     * } else {
     * return vacinaService.listarVacinasPorFabricante(fabricante);
     * }
     * }
     */

}
