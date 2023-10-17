package br.com.gerenciarvacinas.gerenciar.repository;

import br.com.gerenciarvacinas.gerenciar.entities.Vacina;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VacinaRepository extends MongoRepository<Vacina, String> {
    public Optional<Vacina> findById(String id);
}
