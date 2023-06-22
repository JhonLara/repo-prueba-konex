package com.konex.prueba.dominio.puerto.repositorio;

import java.util.List;

import com.konex.prueba.aplicacion.comando.ComandoMedicamento;
import com.konex.prueba.dominio.modelo.Medicamento;

public interface RepositorioMedicamento {

	void guardar(Medicamento medicamento);

	void actualizarExistencias(String nombreMedicamento, Long vendidos);

	void eliminar(Long idMedicamento);

	List<ComandoMedicamento> obtenerMedicamentos();

	ComandoMedicamento obtenerMedicamento(Long idMedicamento);
}
