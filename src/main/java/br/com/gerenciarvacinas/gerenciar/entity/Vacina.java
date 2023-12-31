package br.com.gerenciarvacinas.gerenciar.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor //cria construtor com todos argumentos
@NoArgsConstructor //cria construtor sem argumentos
@Document(collection = "Vacinas")
public class Vacina {
    @Id
    private String id;

    @NotBlank(message = "O nome da vacina não foi informado!")
    @Indexed(unique = true) // Define a restrição de campo único
    @NotNull
    private String nome;

    @NotBlank(message = "O nome do fabricante não foi informado!")
    @NotNull
    private String fabricante;

    @NotBlank(message = "O lote da vacina não foi informado!")
    @Min(value = 1, message = "Informe um número maior que 0!")
    @NotNull
    private String lote;

    @NotNull
    @Future(message = "A data de validade deve ser superior a data atual!")
    private Date validade;

    @NotNull
    @Min(value = 1, message = "Informe um número maior que 0 !")
    private int doses; // Número de doses

    @Min(value = 0, message = "Informe um número positivo!")
    private int intervaloEntreDoses = 0; // Intervalo mínimo entre doses em dias
}
