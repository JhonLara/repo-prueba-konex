package com.ceiba.urgencias.dominio.servicio;

import com.ceiba.urgencias.dominio.modelo.Medicamento;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioMedicamento;

public class ServicioActualizarMedicamento {
	
	private RepositorioMedicamento repositorioMedicamento;

	public ServicioActualizarMedicamento(RepositorioMedicamento repositorioMedicamento) {

		this.repositorioMedicamento = repositorioMedicamento;
	}

	public void ejecutar(Medicamento medicamento) {
		this.repositorioMedicamento.guardar(medicamento);
	}

}
