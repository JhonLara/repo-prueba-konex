package com.ceiba.urgencias.dominio.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.ceiba.urgencias.testdatabuilder.FacturaTestDataBuilder;

public class VentaTest {

	@Test
	void instanciaCorrecta() {
		Venta factura = new FacturaTestDataBuilder().build();

		assertNotNull(factura);
	}

	@Test
	void gettersAndSetters() {

		Long idVenta = 1L;
		String nombreMedicamento = "Nospirin";
		LocalDate fecha = LocalDate.now();
		Long cantidad = 10L;
		Long valor = 1000L;
		Long valorTotal = 10000L;

		Venta factura = new Venta(idVenta, nombreMedicamento, fecha, cantidad, valor, valorTotal);

		factura.setIdVenta(idVenta);
		factura.setNombreMedicamento(nombreMedicamento);
		factura.setFecha(fecha);
		factura.setCantidad(cantidad);
		factura.setValor(valor);
		factura.setValorTotal(valorTotal);

		assertEquals(idVenta, factura.getIdVenta());
		assertEquals(nombreMedicamento, factura.getNombreMedicamento());
		assertEquals(fecha, factura.getFecha());
		assertEquals(cantidad, factura.getCantidad());
		assertEquals(valor, factura.getValor());
		assertEquals(valor, factura.getValorTotal());

	}
}
