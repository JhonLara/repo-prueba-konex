package com.ceiba.urgencias.dominio.servicio;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.dominio.modelo.Medicamento;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioMedicamento;
import com.ceiba.urgencias.testdatabuilder.MedicamentoTestDataBuilder;

public class ServicioGuardarMedicamentoTest {
	@Test
	void crearMedicamento() {
		Medicamento medicamento = new MedicamentoTestDataBuilder().build();
		RepositorioMedicamento repositorioMedicamento = mock(RepositorioMedicamento.class);
		ServicioCrearMedicamento servicio = new ServicioCrearMedicamento(repositorioMedicamento);

		assertDoesNotThrow(() -> servicio.ejecutar(medicamento));
	}

}
