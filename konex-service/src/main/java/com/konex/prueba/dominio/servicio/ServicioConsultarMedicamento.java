package com.konex.prueba.dominio.servicio;

import com.konex.prueba.aplicacion.comando.ComandoMedicamento;
import com.konex.prueba.dominio.puerto.repositorio.RepositorioMedicamento;

public class ServicioConsultarMedicamento {
	private RepositorioMedicamento repositorioMedicamento;

	public ServicioConsultarMedicamento(RepositorioMedicamento repositorioMedicamento) {

		this.repositorioMedicamento = repositorioMedicamento;
	}

	public ComandoMedicamento ejecutar(Long idMedicamento) {
		return this.repositorioMedicamento.obtenerMedicamento(idMedicamento);
	}

}
