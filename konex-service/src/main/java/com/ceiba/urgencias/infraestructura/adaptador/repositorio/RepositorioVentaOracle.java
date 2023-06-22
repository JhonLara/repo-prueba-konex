package com.ceiba.urgencias.infraestructura.adaptador.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import com.ceiba.urgencias.aplicacion.comando.ComandoVenta;
import com.ceiba.urgencias.dominio.modelo.Venta;
import com.ceiba.urgencias.dominio.puerto.repositorio.RepositorioVenta;
import com.ceiba.urgencias.infraestructura.VentaRepositorioJPA;
import com.ceiba.urgencias.infraestructura.entidad.VentaEntidad;

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
	public List<ComandoVenta> obtenerVentas() {
		List<VentaEntidad> listaVentasEntidad = ventaRepositorioJPA.findAll();
		List<ComandoVenta> listaVentas = new ArrayList<>();
		for (VentaEntidad ventaEntidad : listaVentasEntidad) {
			ComandoVenta venta = modelMapper.map(ventaEntidad, ComandoVenta.class);
			listaVentas.add(venta);
		}
		return listaVentas;
	}

}
