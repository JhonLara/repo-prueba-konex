package com.konex.prueba.infraestructura.entidad;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class MedicamentoEntidadTest {
	@Test
	void getter_setter() {

		Long idMedicamento = 100L;
		String nombreMedicamento = "Nospirin";
		String laboratorio = "MK";
		LocalDate fechaIngreso = LocalDate.now();
		LocalDate fechaVencimiento = LocalDate.now();
		Long cantidad = 10L;
		Double valor = 10.26;
		MedicamentoEntidad medicamento = new MedicamentoEntidad(idMedicamento, nombreMedicamento, laboratorio,
				fechaIngreso, fechaVencimiento, cantidad, valor);

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
