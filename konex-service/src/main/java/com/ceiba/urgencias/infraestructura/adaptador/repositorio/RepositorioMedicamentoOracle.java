package com.ceiba.urgencias.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.ceiba.urgencias.aplicacion.comando.ComandoMedicamento;
import com.ceiba.urgencias.dominio.modelo.Medicamento;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioMedicamento;
import com.ceiba.urgencias.infraestructura.MedicamentoRepositorioJPA;
import com.ceiba.urgencias.infraestructura.entidad.MedicamentoEntidad;

@Repository
public class RepositorioMedicamentoOracle implements RepositorioMedicamento {

	private final MedicamentoRepositorioJPA medicamentoRepositorioJPA;
	private ModelMapper modelMapper = new ModelMapper();

	public RepositorioMedicamentoOracle(MedicamentoRepositorioJPA medicamentoRepositorioJPA) {
		this.medicamentoRepositorioJPA = medicamentoRepositorioJPA;
	}

	@Override
	public void guardar(Medicamento medicamento) {
		MedicamentoEntidad medicamentoEntidad = modelMapper.map(medicamento, MedicamentoEntidad.class);
		medicamentoRepositorioJPA.save(medicamentoEntidad);
	}

	@Override
	public void actualizar(Medicamento medicamento) {
		MedicamentoEntidad medicamentoEntidad = modelMapper.map(medicamento, MedicamentoEntidad.class);
		medicamentoRepositorioJPA.save(medicamentoEntidad);
	}

	@Override
	public void eliminar(Long idMedicamento) {
		medicamentoRepositorioJPA.deleteById(idMedicamento);
	}

	@Override
	public List<ComandoMedicamento> obtenerMedicamentos() {
		List<MedicamentoEntidad> listaMedicamentosEntidad = medicamentoRepositorioJPA.findAll();
		List<ComandoMedicamento> listaMedicamentos = new ArrayList<>();
		for (MedicamentoEntidad medicamentoEntidad : listaMedicamentosEntidad) {
			ComandoMedicamento medicamento = modelMapper.map(medicamentoEntidad, ComandoMedicamento.class);
			listaMedicamentos.add(medicamento);
		}
		return listaMedicamentos;
	}

	@Override
	public ComandoMedicamento obtenerMedicamento(Long idMedicamento) {
		Optional<MedicamentoEntidad> medicamentoEntidad = medicamentoRepositorioJPA.findById(idMedicamento);
		return medicamentoEntidad.isPresent() ? modelMapper.map(medicamentoEntidad.get(), ComandoMedicamento.class)
				: null;
	}

}
