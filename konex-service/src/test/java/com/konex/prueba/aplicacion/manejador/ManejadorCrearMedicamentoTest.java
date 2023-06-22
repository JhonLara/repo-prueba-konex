package com.konex.prueba.aplicacion.manejador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.konex.prueba.aplicacion.comando.ComandoMedicamento;
import com.konex.prueba.aplicacion.fabrica.FabricaMedicamento;
import com.konex.prueba.dominio.servicio.ServicioCrearMedicamento;
import com.konex.prueba.testdatabuilder.ComandoMedicamentoTestDataBuilder;

class ManejadorCrearMedicamentoTest {
	@Test
	void ejecutar() {
		ComandoMedicamento command = new ComandoMedicamentoTestDataBuilder().build();
		ServicioCrearMedicamento service = mock(ServicioCrearMedicamento.class);
		FabricaMedicamento fabricaMedicamento = new FabricaMedicamento();
		ManejadorCrearMedicamento handler = new ManejadorCrearMedicamento(service, fabricaMedicamento);

		assertDoesNotThrow(() -> handler.ejecutar(command));
	}
}
