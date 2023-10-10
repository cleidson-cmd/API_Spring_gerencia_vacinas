package br.com.gerenciarvacinas.gerenciar.entities;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor //cria construtor com todos argumentos
@NoArgsConstructor //cria construtor sem argumentos
@Document(collection = "vacinas")
public class Vacina {
    @Id
    @NotNull
    private int id;
    private String nome;
    private String fabricante;
    private String lote;
    private Date validade;
    private int doses;
    private String intervaloEntreDoses;
}
