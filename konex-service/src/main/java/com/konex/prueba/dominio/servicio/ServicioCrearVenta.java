package com.konex.prueba.dominio.servicio;

import com.konex.prueba.dominio.modelo.Venta;
import com.konex.prueba.dominio.puerto.repositorio.RepositorioMedicamento;
import com.konex.prueba.dominio.puerto.repositorio.RepositorioVenta;

public class ServicioCrearVenta {

	private RepositorioVenta repositorioVenta;
	private RepositorioMedicamento repositorioMedicamento;

	public ServicioCrearVenta(RepositorioVenta repositorioVenta, RepositorioMedicamento repositorioMedicamento) {
		this.repositorioMedicamento = repositorioMedicamento;
		this.repositorioVenta = repositorioVenta;
	}

	public void ejecutar(Venta venta) {
		this.repositorioMedicamento.actualizarExistencias(venta.getNombreMedicamento(), venta.getCantidad());
		this.repositorioVenta.guardar(venta);

	}

}
