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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idVenta")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ComandoVenta {

	private Long idVenta;
	private String nombreMedicamento;
	private LocalDate fecha;
	private Long cantidad;
	private Long valor;
	private Long valorTotal;
}
