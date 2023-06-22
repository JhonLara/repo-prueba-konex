package com.ceiba.urgencias.dominio.modelo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Venta {

	private Long idVenta;
	private String nombreMedicamento;
	private LocalDate fecha;
	private Long cantidad;
	private Long valor;
	private Long valorTotal;

}
