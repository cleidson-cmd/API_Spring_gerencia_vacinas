package br.com.gerenciarvacinas.gerenciar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.gerenciarvacinas.gerenciar.entity.Vacina;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface VacinaRepository extends MongoRepository<Vacina, String> {
    public Optional<Vacina> findById(String id);

    @Query("{ 'nome': { $regex: ?0, $options: 'i' } }")
    List<Vacina> findByNomeIgnoringCaseAndSpaces(String nome);


}
