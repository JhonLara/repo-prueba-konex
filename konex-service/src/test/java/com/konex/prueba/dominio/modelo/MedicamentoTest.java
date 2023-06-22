package com.konex.prueba.dominio.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.konex.prueba.testdatabuilder.MedicamentoTestDataBuilder;

class MedicamentoTest {

	@Test
	void instanciaCorrecta() {
		Medicamento medicamento = new MedicamentoTestDataBuilder().build();

		assertNotNull(medicamento);
	}

	@Test
	void gettersAndSetters() {

		Long idMedicamento = 100L;
		String nombreMedicamento = "Nospirin";
		String laboratorio = "MK";
		LocalDate fechaIngreso = LocalDate.now();
		LocalDate fechaVencimiento = LocalDate.now();
		Long cantidad = 10L;
		Double valor = 10.26;
		Medicamento medicamento = new MedicamentoTestDataBuilder().build();

		medicamento.setIdMedicamento(idMedicamento);
		medicamento.setNombreMedicamento(nombreMedicamento);
		medicamento.setLaboratorio(laboratorio);
		medicamento.setFechaFabricacion(fechaIngreso);
		medicamento.setFechaVencimiento(fechaVencimiento);
		medicamento.setCantidad(cantidad);
		medicamento.setValor(valor);

		assertEquals(idMedicamento, medicamento.getIdMedicamento());
		assertEquals(nombreMedicamento, medicamento.getNombreMedicamento());
		assertEquals(laboratorio, medicamento.getLaboratorio());
		assertEquals(fechaIngreso, medicamento.getFechaFabricacion());
		assertEquals(fechaVencimiento, medicamento.getFechaVencimiento());
		assertEquals(cantidad, medicamento.getCantidad());
		assertEquals(valor, medicamento.getValor());

	}
}
