package com.ceiba.urgencias.testdatabuilder;

import java.time.LocalDate;

import com.ceiba.urgencias.infraestructura.entidad.MedicamentoEntidad;

public class MedicamentoEntidadTestDataBuilder {

	private Long idMedicamento;
	private String nombreMedicamento;
	private String laboratorio;
	private LocalDate fechaIngreso;
	private LocalDate fechaVencimiento;
	private Long cantidad;
	private Double valor;

	public MedicamentoEntidadTestDataBuilder() {
		idMedicamento = 100L;
		nombreMedicamento = "Nospirin";
		laboratorio = "MK";
		fechaIngreso = LocalDate.now();
		fechaVencimiento = LocalDate.now();
		cantidad = 10L;
		valor = 10.26;
	}

	public MedicamentoEntidad build() {
		return new MedicamentoEntidad(idMedicamento, nombreMedicamento, laboratorio, fechaIngreso, fechaVencimiento,
				cantidad, valor);
	}
}
