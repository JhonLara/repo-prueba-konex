package com.ceiba.urgencias.dominio.servicio;

import java.util.List;

import com.ceiba.urgencias.aplicacion.comando.ComandoVenta;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioVenta;

public class ServicioConsultarVentas {
	private RepositorioVenta repositorioVenta;

	public ServicioConsultarVentas(RepositorioVenta repositorioVenta) {

		this.repositorioVenta = repositorioVenta;
	}

	public List<ComandoVenta> ejecutar() {
		return this.repositorioVenta.obtenerVentas();
	}
}
