package br.com.gerenciarvacinas.gerenciar.repository;

import br.com.gerenciarvacinas.gerenciar.entities.Vacina;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VacinaRepository extends MongoRepository<Vacina, String> {
    Vacina findById(int id);
}
