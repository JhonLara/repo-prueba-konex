package com.ceiba.urgencias.dominio.puerto.repositorio;

import java.util.List;

import com.ceiba.urgencias.aplicacion.comando.ComandoVenta;
import com.ceiba.urgencias.dominio.modelo.Venta;

public interface RepositorioVenta {

	void guardar(Venta venta);

	List<ComandoVenta> obtenerVentas();
}
