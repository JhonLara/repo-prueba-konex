package com.ceiba.urgencias.dominio.servicio;

import com.ceiba.urgencias.aplicacion.comando.ComandoMedicamento;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioMedicamento;

public class ServicioConsultarMedicamento {
	private RepositorioMedicamento repositorioMedicamento;

	public ServicioConsultarMedicamento(RepositorioMedicamento repositorioMedicamento) {

		this.repositorioMedicamento = repositorioMedicamento;
	}

	public ComandoMedicamento ejecutar(Long idMedicamento) {
		return this.repositorioMedicamento.obtenerMedicamento(idMedicamento);
	}

}
