package br.com.gerenciarvacinas.gerenciar.entities;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor //cria construtor com todos argumentos
@NoArgsConstructor //cria construtor sem argumentos
@Document(collection = "vacinas")
public class Vacina {
    @Id
    private String id;
    @NotNull
    @Indexed(unique = true)
    private int codigo;
    @NotEmpty
    private String nome;
    @NotEmpty
    private String fabricante;
    @NotNull
    @Min(value = 1)
    private String lote;
    @NotNull
    private Date validade;
    private int doses;
    private String intervaloEntreDoses;
}
