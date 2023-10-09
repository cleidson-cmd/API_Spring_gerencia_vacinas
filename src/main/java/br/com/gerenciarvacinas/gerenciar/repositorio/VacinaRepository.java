package br.com.gerenciarvacinas.gerenciar.repositorio;

import br.com.gerenciarvacinas.gerenciar.entidade.Vacina;
import com.mongodb.client.MongoDatabase;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VacinaRepository extends MongoRepository<Vacina, String> {
    Vacina findById(int id);
}
