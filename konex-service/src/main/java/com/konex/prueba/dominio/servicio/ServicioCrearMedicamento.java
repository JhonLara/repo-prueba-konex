package com.konex.prueba.dominio.servicio;

import com.konex.prueba.dominio.modelo.Medicamento;
import com.konex.prueba.dominio.puerto.repositorio.RepositorioMedicamento;

public class ServicioCrearMedicamento {

	private RepositorioMedicamento repositorioMedicamento;

	public ServicioCrearMedicamento(RepositorioMedicamento repositorioMedicamento) {

		this.repositorioMedicamento = repositorioMedicamento;
	}

	public void ejecutar(Medicamento medicamento) {
		this.repositorioMedicamento.guardar(medicamento);
	}
}
