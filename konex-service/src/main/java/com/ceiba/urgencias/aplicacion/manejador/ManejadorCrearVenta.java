package com.ceiba.urgencias.aplicacion.manejador;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.ceiba.urgencias.aplicacion.comando.ComandoVenta;
import com.ceiba.urgencias.aplicacion.fabrica.FabricaVenta;
import com.ceiba.urgencias.dominio.modelo.Venta;
import com.ceiba.urgencias.dominio.servicio.ServicioCrearVenta;

@Component
public class ManejadorCrearVenta {
	private final ServicioCrearVenta servicioCrearVenta;
	private final FabricaVenta fabricaVenta;

	public ManejadorCrearVenta(ServicioCrearVenta servicioCrearVenta, FabricaVenta fabricaVenta) {
		this.servicioCrearVenta = servicioCrearVenta;
		this.fabricaVenta = fabricaVenta;
	}

	@Transactional
	public void ejecutar(ComandoVenta comandoVenta) {
		Venta venta = this.fabricaVenta.crearVenta(comandoVenta);
		this.servicioCrearVenta.ejecutar(venta);
	}

}
