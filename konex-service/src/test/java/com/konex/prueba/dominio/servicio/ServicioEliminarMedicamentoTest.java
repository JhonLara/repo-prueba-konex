package com.konex.prueba.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.konex.prueba.dominio.puerto.repositorio.RepositorioMedicamento;

class ServicioEliminarMedicamentoTest {

	@Test
	void eliminarMedicamentoNoExistente() {
		RepositorioMedicamento repositorioMedicamento = Mockito.mock(RepositorioMedicamento.class);
		ServicioEliminarMedicamento servicio = new ServicioEliminarMedicamento(repositorioMedicamento);

		assertDoesNotThrow(() -> servicio.ejecutar(1L));
	}

}
