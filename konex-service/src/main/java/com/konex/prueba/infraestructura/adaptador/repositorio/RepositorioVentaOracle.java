package com.konex.prueba.infraestructura.adaptador.repositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.konex.prueba.aplicacion.comando.ComandoVenta;
import com.konex.prueba.dominio.modelo.Venta;
import com.konex.prueba.dominio.puerto.repositorio.RepositorioVenta;
import com.konex.prueba.infraestructura.VentaRepositorioJPA;
import com.konex.prueba.infraestructura.entidad.VentaEntidad;

@Repository
public class RepositorioVentaOracle implements RepositorioVenta {

	private final VentaRepositorioJPA ventaRepositorioJPA;
	private ModelMapper modelMapper = new ModelMapper();

	public RepositorioVentaOracle(VentaRepositorioJPA ventaRepositorioJPA) {
		this.ventaRepositorioJPA = ventaRepositorioJPA;
	}

	@Override
	public void guardar(Venta venta) {
		VentaEntidad ventaEntidad = modelMapper.map(venta, VentaEntidad.class);
		ventaRepositorioJPA.save(ventaEntidad);
	}

	@Override
	public List<ComandoVenta> obtenerVentas(String fechaInicial, String fechaFinal) {
		List<VentaEntidad> listaVentasEntidad = ventaRepositorioJPA.findByFechaBetween(LocalDate.parse(fechaInicial),
				LocalDate.parse(fechaFinal));
		List<ComandoVenta> listaVentas = new ArrayList<>();
		for (VentaEntidad ventaEntidad : listaVentasEntidad) {
			ComandoVenta venta = modelMapper.map(ventaEntidad, ComandoVenta.class);
			listaVentas.add(venta);
		}
		return listaVentas;
	}

}
