package com.konex.prueba.aplicacion.comando;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;

import com.konex.prueba.testdatabuilder.ComandoMedicamentoTestDataBuilder;

class ComandoMedicamentoTest {
	@Test
	void getters() {
		ComandoMedicamento command = new ComandoMedicamento();
		assertNull(command.getIdMedicamento());
		assertNull(command.getNombreMedicamento());
		assertNull(command.getFechaFabricacion());
		assertNull(command.getFechaVencimiento());
	}

	@Test
	void setters() {
		ComandoMedicamento command = new ComandoMedicamentoTestDataBuilder().build();
		command.setFechaFabricacion(null);
		command.setFechaVencimiento(null);
		command.setIdMedicamento(null);
		command.setNombreMedicamento(null);

		assertNull(command.getFechaFabricacion());
		assertNull(command.getIdMedicamento());

	}

	@Test
	void constructor() {
		ComandoMedicamento command = new ComandoMedicamentoTestDataBuilder().build();
		assertNotNull(command.getNombreMedicamento());
		assertNotNull(command.getIdMedicamento());
	}

}
