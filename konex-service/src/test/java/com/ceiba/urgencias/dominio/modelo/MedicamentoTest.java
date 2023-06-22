package com.ceiba.urgencias.dominio.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.dominio.excepcion.ExcepcionFecha;
import com.ceiba.urgencias.dominio.excepcion.ExcepcionMenorQueCero;
import com.ceiba.urgencias.dominio.excepcion.ExcepcionObligatorio;
import com.ceiba.urgencias.testdatabuilder.MedicamentoTestDataBuilder;

public class MedicamentoTest {
	@Test
	void instanciaIdMedicamentoNull() {
		assertThrows(ExcepcionObligatorio.class,
				() -> new Medicamento(null, "Nospirin", "MK", LocalDate.now(), LocalDate.now(), 10L, 10.26));
	}

	@Test
	void instanciaNombreNull() {
		assertThrows(ExcepcionObligatorio.class,
				() -> new Medicamento(100L, null, "MK", LocalDate.now(), LocalDate.now(), 10L, 10.26));
	}

	@Test
	void instanciaFechaIncorrecta() {
		assertThrows(ExcepcionFecha.class,
				() -> new Medicamento(100L, "Nospirin", "MK", null, LocalDate.now(), 10L, 10.26));
	}

	@Test
	void instanciaNumeroMenorFactura() {
		assertThrows(ExcepcionMenorQueCero.class,
				() -> new Venta(100L, "Nospirin", LocalDate.now(), 20000L, 15000000L, 200000L));
	}

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
