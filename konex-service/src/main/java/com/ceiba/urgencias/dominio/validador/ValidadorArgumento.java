package com.ceiba.urgencias.dominio.validador;

import java.time.LocalDate;

import com.ceiba.urgencias.dominio.excepcion.ExcepcionFecha;
import com.ceiba.urgencias.dominio.excepcion.ExcepcionMenorQueCero;
import com.ceiba.urgencias.dominio.excepcion.ExcepcionObligatorio;

public class ValidadorArgumento {

	public static void validarObligatorio(Object valor, String mensaje) {
		if (valor == null) {
			throw new ExcepcionObligatorio(mensaje);
		}
	}

	public static void validarFecha(LocalDate valor, String mensaje) {
		if (valor.isAfter(LocalDate.now())) {
			throw new ExcepcionFecha(mensaje);
		}
	}

	public static void validarMenorQueCero(Long valor, String mensaje) {
		if (valor < 0L) {
			throw new ExcepcionMenorQueCero(mensaje);
		}
	}
}
