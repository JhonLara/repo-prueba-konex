package com.ceiba.urgencias.dominio.excepcion;

public class ExcepcionMenorQueCero extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExcepcionMenorQueCero(String mensaje) {
		super(mensaje);
	}
}
