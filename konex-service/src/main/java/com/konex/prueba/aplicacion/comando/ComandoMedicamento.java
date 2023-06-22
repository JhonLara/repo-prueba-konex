package com.konex.prueba.aplicacion.comando;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idMedicamento")
@AllArgsConstructor
@NoArgsConstructor
public class ComandoMedicamento {

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
