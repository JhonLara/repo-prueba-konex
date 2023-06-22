package com.ceiba.urgencias.aplicacion.manejador;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.aplicacion.comando.ComandoMedicamento;
import com.ceiba.urgencias.aplicacion.fabrica.FabricaMedicamento;
import com.ceiba.urgencias.dominio.servicio.ServicioCrearMedicamento;
import com.ceiba.urgencias.testdatabuilder.ComandoMedicamentoTestDataBuilder;

public class ManejadorCrearMedicamentoTest {
	@Test
	void ejecutar() {
		ComandoMedicamento command = new ComandoMedicamentoTestDataBuilder().build();
		ServicioCrearMedicamento service = mock(ServicioCrearMedicamento.class);
		FabricaMedicamento fabricaMedicamento = new FabricaMedicamento();
		ManejadorCrearMedicamento handler = new ManejadorCrearMedicamento(service, fabricaMedicamento);

		assertDoesNotThrow(() -> handler.ejecutar(command));
	}
}
