package com.ceiba.urgencias.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioMedicamento;

public class ServicioEliminarMedicamentoTest {

	@Test
	void eliminarMedicamentoNoExistente() {
		RepositorioMedicamento repositorioMedicamento = Mockito.mock(RepositorioMedicamento.class);
		ServicioEliminarMedicamento servicio = new ServicioEliminarMedicamento(repositorioMedicamento);

		assertDoesNotThrow(() -> servicio.ejecutar(1L));
	}

}
