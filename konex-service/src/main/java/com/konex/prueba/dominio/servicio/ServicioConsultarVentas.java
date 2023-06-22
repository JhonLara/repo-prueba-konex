package com.konex.prueba.dominio.servicio;

import java.util.List;

import com.konex.prueba.aplicacion.comando.ComandoVenta;
import com.konex.prueba.dominio.puerto.repositorio.RepositorioVenta;

public class ServicioConsultarVentas {
	private RepositorioVenta repositorioVenta;

	public ServicioConsultarVentas(RepositorioVenta repositorioVenta) {

		this.repositorioVenta = repositorioVenta;
	}

	public List<ComandoVenta> ejecutar(String  fechaInicial, String  fechaFinal) {
		return this.repositorioVenta.obtenerVentas(fechaInicial, fechaFinal);
	}
}
