package br.com.gerenciarvacinas.gerenciar;

import br.com.gerenciarvacinas.gerenciar.entities.Vacina;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
class ApplicationTests {

	@Test
	@DisplayName("deve ser possivel obter todos os pacientes cadastrados")
	public void testObterTodasvacinas() {
		List<Vacina> vacinas = new ArrayList();
		//Arrange
		Vacina vacina = new Vacina();
		vacina.setNome("teste");
		vacina.setCodigo(4);
        vacina.setLote("45");
		vacina.setDoses(4);
		vacina.setValidade(new Date(2023));
		vacina.setFabricante("4");
		vacina.setIntervaloEntreDoses("5555");
		vacinas.add(vacina);

		vacina.setNome("teste2");
		vacina.setCodigo(4);
		vacina.setLote("45");
		vacina.setDoses(4);
		vacina.setValidade(new Date(2023));
		vacina.setFabricante("4");
		vacina.setIntervaloEntreDoses("5555");
		vacinas.add(vacina);
		//mock
        when();
     	//Act

		//Assert

		//verify
	}

}
