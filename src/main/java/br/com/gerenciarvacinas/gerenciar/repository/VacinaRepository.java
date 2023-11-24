package br.com.gerenciarvacinas.gerenciar.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.gerenciarvacinas.gerenciar.entity.Vacina;

import java.util.List;
import java.util.Optional;

public interface VacinaRepository extends MongoRepository<Vacina, String> {
    public Optional<Vacina> findById(String id);

    Vacina findByNome(String nome);

    //Para realizar a consulta flexível que considera espaços antes ou depois do texto e não diferencia maiúsculas de minúsculas
    List<Vacina> findByNomeRegexIgnoreCase(String nome);


    //Vacina findByNomeRegexIgnoreCase(String nome);


}
