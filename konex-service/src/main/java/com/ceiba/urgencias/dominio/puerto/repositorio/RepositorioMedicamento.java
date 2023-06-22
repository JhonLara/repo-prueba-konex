package com.ceiba.urgencias.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.urgencias.aplicacion.comando.ComandoMedicamento;
import com.ceiba.urgencias.dominio.modelo.Medicamento;

public interface RepositorioMedicamento {
	
	void guardar(Medicamento medicamento);
	
	void actualizar(Medicamento medicamento);

	void eliminar(Long idMedicamento);

	List<ComandoMedicamento> obtenerMedicamentos();

	ComandoMedicamento obtenerMedicamento(Long idMedicamento);
}
