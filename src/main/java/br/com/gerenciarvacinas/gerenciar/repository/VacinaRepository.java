package br.com.gerenciarvacinas.gerenciar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.gerenciarvacinas.gerenciar.entity.Vacina;

import java.util.List;
import java.util.Optional;

public interface VacinaRepository extends MongoRepository<Vacina, String> {
    public Optional<Vacina> findById(String id);

    List<Vacina> findByFabricante(String fabricante);

    // List<Vacina> findByFabricanteAndEstado(String fabricante, String estado);
}
