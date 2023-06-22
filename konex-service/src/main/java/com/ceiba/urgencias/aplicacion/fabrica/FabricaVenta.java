package com.ceiba.urgencias.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.urgencias.aplicacion.comando.ComandoVenta;
import com.ceiba.urgencias.dominio.modelo.Venta;

@Component
public class FabricaVenta {

	public Venta crearVenta(ComandoVenta comandoVenta) {
		return new Venta(comandoVenta.getIdVenta(), comandoVenta.getNombreMedicamento(), comandoVenta.getFecha(),
				comandoVenta.getCantidad(), comandoVenta.getValor(), comandoVenta.getValorTotal());
	}

}
