package br.com.gerenciarvacinas.gerenciar.repository;

import br.com.gerenciarvacinas.gerenciar.entities.Vacina;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface VacinaRepository extends MongoRepository<Vacina, String> {

    //Optional<Vacina> findById(String id);
    public Optional<Vacina> findById(String id);
    //public Vacina findById(String id);
}
