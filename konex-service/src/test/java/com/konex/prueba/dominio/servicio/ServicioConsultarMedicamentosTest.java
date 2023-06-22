package com.konex.prueba.dominio.servicio;

import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.konex.prueba.aplicacion.comando.ComandoMedicamento;
import com.konex.prueba.dominio.puerto.repositorio.RepositorioMedicamento;
import com.konex.prueba.testdatabuilder.ComandoMedicamentoTestDataBuilder;

class ServicioConsultarMedicamentosTest {

	@Test
	void obtenerMedicamentos() {
		RepositorioMedicamento repositorioMedicamento = mock(RepositorioMedicamento.class);
		ComandoMedicamento medicamentoCreado = new ComandoMedicamentoTestDataBuilder().build();
		List<ComandoMedicamento> listaMedicamentos = new ArrayList<ComandoMedicamento>();
		listaMedicamentos.add(medicamentoCreado);
		Mockito.when(repositorioMedicamento.obtenerMedicamentos()).thenReturn(listaMedicamentos);
		ServicioConsultarMedicamentos servicio = new ServicioConsultarMedicamentos(repositorioMedicamento);

		List<ComandoMedicamento> results = servicio.ejecutar();

		assertFalse(results.isEmpty());
	}

}