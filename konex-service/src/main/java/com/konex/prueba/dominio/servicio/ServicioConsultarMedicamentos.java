package com.konex.prueba.dominio.servicio;

import java.util.List;

import com.konex.prueba.aplicacion.comando.ComandoMedicamento;
import com.konex.prueba.dominio.puerto.repositorio.RepositorioMedicamento;

public class ServicioConsultarMedicamentos {
	private RepositorioMedicamento repositorioMedicamento;

	public ServicioConsultarMedicamentos(RepositorioMedicamento repositorioMedicamento) {

		this.repositorioMedicamento = repositorioMedicamento;
	}

	public List<ComandoMedicamento> ejecutar() {
		return this.repositorioMedicamento.obtenerMedicamentos();
	}
}
