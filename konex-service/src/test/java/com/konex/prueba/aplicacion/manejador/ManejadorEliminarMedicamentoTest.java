package com.konex.prueba.aplicacion.manejador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.konex.prueba.dominio.servicio.ServicioEliminarMedicamento;

class ManejadorEliminarMedicamentoTest {
	@Test
	void ejecutar() {
		ServicioEliminarMedicamento service = mock(ServicioEliminarMedicamento.class);
		ManejadorEliminarMedicamento handler = new ManejadorEliminarMedicamento(service);

		assertDoesNotThrow(() -> handler.ejecutar(1L));
	}

}
