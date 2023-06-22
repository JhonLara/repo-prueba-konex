package com.ceiba.urgencias.testdatabuilder;

import java.time.LocalDate;

import com.ceiba.urgencias.dominio.modelo.Venta;

public class FacturaTestDataBuilder {

	private Long idVenta;
	private String nombreMedicamento;
	private LocalDate fecha;
	private Long cantidad;
	private Long valor;
	private Long valorTotal;

	public FacturaTestDataBuilder() {
		idVenta = 1L;
		nombreMedicamento = "Nospirin";
		fecha = LocalDate.now();
		cantidad = 10L;
		valor = 1000L;
		valorTotal = 10000L;
	}

	public Venta build() {
		return new Venta(idVenta, nombreMedicamento, fecha, cantidad, valor, valorTotal);
	}

}
