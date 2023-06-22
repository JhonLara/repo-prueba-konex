package com.konex.prueba.aplicacion.fabrica;

import org.springframework.stereotype.Component;

import com.konex.prueba.aplicacion.comando.ComandoVenta;
import com.konex.prueba.dominio.modelo.Venta;

@Component
public class FabricaVenta {

	public Venta crearVenta(ComandoVenta comandoVenta) {
		return new Venta(comandoVenta.getIdVenta(), comandoVenta.getNombreMedicamento(), comandoVenta.getFecha(),
				comandoVenta.getCantidad(), comandoVenta.getValor(), comandoVenta.getValorTotal());
	}

}
