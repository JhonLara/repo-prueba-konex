package com.ceiba.urgencias.dominio.servicio;

import java.util.List;

import com.ceiba.urgencias.aplicacion.comando.ComandoMedicamento;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioMedicamento;

public class ServicioConsultarMedicamentos {
	private RepositorioMedicamento repositorioMedicamento;

	public ServicioConsultarMedicamentos(RepositorioMedicamento repositorioMedicamento) {

		this.repositorioMedicamento = repositorioMedicamento;
	}

	public List<ComandoMedicamento> ejecutar() {
		return this.repositorioMedicamento.obtenerMedicamentos();
	}
}
