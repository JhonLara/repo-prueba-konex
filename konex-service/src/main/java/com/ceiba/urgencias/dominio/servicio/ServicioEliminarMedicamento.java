package com.ceiba.urgencias.dominio.servicio;

import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioMedicamento;

public class ServicioEliminarMedicamento {
	private RepositorioMedicamento repositorioMedicamento;

	public ServicioEliminarMedicamento(RepositorioMedicamento repositorioMedicamento) {

		this.repositorioMedicamento = repositorioMedicamento;
	}

	public void ejecutar(Long idMedicamento) {
		this.repositorioMedicamento.eliminar(idMedicamento);
	}
}
