package com.ceiba.urgencias.dominio.servicio;

import com.ceiba.urgencias.dominio.modelo.Venta;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioVenta;

public class ServicioCrearVenta {

	private RepositorioVenta repositorioVenta;

	public ServicioCrearVenta(RepositorioVenta repositorioVenta) {

		this.repositorioVenta = repositorioVenta;
	}

	public void ejecutar(Venta venta) {
		this.repositorioVenta.guardar(venta);
	}

}
