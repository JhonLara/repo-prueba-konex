package com.konex.prueba.dominio.modelo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class Medicamento {

	@Getter
	@Setter
	private Long idMedicamento;
	@Getter
	@Setter
	private String nombreMedicamento;
	@Getter
	@Setter
	private String laboratorio;
	@Getter
	@Setter
	private LocalDate fechaFabricacion;
	@Getter
	@Setter
	private LocalDate fechaVencimiento;
	@Getter
	@Setter
	private Long cantidad;
	@Getter
	@Setter
	private Double valor;

}
