package com.konex.prueba.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.konex.prueba.aplicacion.comando.ComandoMedicamento;
import com.konex.prueba.dominio.modelo.Medicamento;
import com.konex.prueba.dominio.puerto.repositorio.RepositorioMedicamento;
import com.konex.prueba.infraestructura.MedicamentoRepositorioJPA;
import com.konex.prueba.infraestructura.entidad.MedicamentoEntidad;

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

	@Override
	public void actualizarExistencias(String nombreMedicamento, Long vendidos) {
		Optional<MedicamentoEntidad> medicamentoEntidad = Optional
				.ofNullable(medicamentoRepositorioJPA.findByNombreMedicamento(nombreMedicamento));
		if (medicamentoEntidad.isPresent()) {
			MedicamentoEntidad entidad = medicamentoEntidad.get();
			Long cant = entidad.getCantidad();
			entidad.setCantidad(cant - vendidos);
		}

	}

}
