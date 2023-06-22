package com.ceiba.urgencias.aplicacion.manejador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.dominio.servicio.ServicioEliminarMedicamento;

public class ManejadorEliminarMedicamentoTest {
	@Test
	void ejecutar() {
		ServicioEliminarMedicamento service = mock(ServicioEliminarMedicamento.class);
		ManejadorEliminarMedicamento handler = new ManejadorEliminarMedicamento(service);

		assertDoesNotThrow(() -> handler.ejecutar(1L));
	}

}
