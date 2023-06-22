package com.konex.prueba.dominio.puerto.repositorio;

import java.util.List;

import com.konex.prueba.aplicacion.comando.ComandoVenta;
import com.konex.prueba.dominio.modelo.Venta;

public interface RepositorioVenta {

	void guardar(Venta venta);

	List<ComandoVenta> obtenerVentas(String  fechaInicial, String  fechaFinal);
}
