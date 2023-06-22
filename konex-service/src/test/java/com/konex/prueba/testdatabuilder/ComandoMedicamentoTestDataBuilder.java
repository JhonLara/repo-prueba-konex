package com.konex.prueba.testdatabuilder;

import java.time.LocalDate;

import com.konex.prueba.aplicacion.comando.ComandoMedicamento;

public class ComandoMedicamentoTestDataBuilder {

	private Long idMedicamento;
	private String nombreMedicamento;
	private String laboratorio;
	private LocalDate fechaIngreso;
	private LocalDate fechaVencimiento;
	private Long cantidad;
	private Double valor;

	public ComandoMedicamentoTestDataBuilder() {
		idMedicamento = 100L;
		nombreMedicamento = "Nospirin";
		laboratorio = "MK";
		fechaIngreso = LocalDate.now();
		fechaVencimiento = LocalDate.now();
		cantidad = 10L;
		valor = 10.26;
	}

	public ComandoMedicamento build() {
		return new ComandoMedicamento(idMedicamento, nombreMedicamento, laboratorio, fechaIngreso, fechaVencimiento,
				cantidad, valor);
	}
}
