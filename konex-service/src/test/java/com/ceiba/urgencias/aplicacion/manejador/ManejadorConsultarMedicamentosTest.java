package com.ceiba.urgencias.aplicacion.manejador;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.aplicacion.comando.ComandoMedicamento;
import com.ceiba.urgencias.dominio.servicio.ServicioConsultarMedicamentos;
import com.ceiba.urgencias.testdatabuilder.ComandoMedicamentoTestDataBuilder;

public class ManejadorConsultarMedicamentosTest {
	@Test
	void ejecutar() {

		ComandoMedicamento command = new ComandoMedicamentoTestDataBuilder().build();
		List<ComandoMedicamento> listaMedicamentos = new ArrayList<>();
		listaMedicamentos.add(command);
		ServicioConsultarMedicamentos service = mock(ServicioConsultarMedicamentos.class);
		doReturn(listaMedicamentos).when(service).ejecutar();
		ManejadorConsultarMedicamentos handler = new ManejadorConsultarMedicamentos(service);

		assertFalse(handler.ejecutar().isEmpty());
	}
}
