package com.ceiba.urgencias.testdatabuilder;

import java.time.LocalDate;

import com.ceiba.urgencias.dominio.modelo.Medicamento;

public class MedicamentoTestDataBuilder {

	private Long idMedicamento;
	private String nombreMedicamento;
	private String laboratorio;
	private LocalDate fechaIngreso;
	private LocalDate fechaVencimiento;
	private Long cantidad;
	private Double valor;

	public MedicamentoTestDataBuilder() {
		idMedicamento = 100L;
		nombreMedicamento = "Nospirin";
		laboratorio = "MK";
		fechaIngreso = LocalDate.now();
		fechaVencimiento = LocalDate.now();
		cantidad = 10L;
		valor = 10.26;
	}

	public Medicamento build() {
		return new Medicamento(idMedicamento, nombreMedicamento, laboratorio, fechaIngreso, fechaVencimiento, cantidad,
				valor);
	}
}
