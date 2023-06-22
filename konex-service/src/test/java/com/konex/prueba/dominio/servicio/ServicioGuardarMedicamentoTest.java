package com.konex.prueba.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.konex.prueba.dominio.modelo.Medicamento;
import com.konex.prueba.dominio.puerto.repositorio.RepositorioMedicamento;
import com.konex.prueba.testdatabuilder.MedicamentoTestDataBuilder;

class ServicioGuardarMedicamentoTest {
	@Test
	void crearMedicamento() {
		Medicamento medicamento = new MedicamentoTestDataBuilder().build();
		RepositorioMedicamento repositorioMedicamento = mock(RepositorioMedicamento.class);
		ServicioCrearMedicamento servicio = new ServicioCrearMedicamento(repositorioMedicamento);

		assertDoesNotThrow(() -> servicio.ejecutar(medicamento));
	}

}
