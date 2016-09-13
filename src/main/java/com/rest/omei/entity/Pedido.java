package com.rest.omei.entity;

import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable {

	private static final long serialVersionUID = 3437060827716193992L;

	private long codigo;
	private Mesa mesa;
	private List<DetallePedido> detallePedido;

	public Pedido(long codigo) {
		this.codigo = codigo;
	}

	public Pedido(long codigo, Mesa mesa) {
		this.codigo = codigo;
		this.mesa = mesa;
	}

	public Pedido(long codigo, Mesa mesa, List<DetallePedido> detallePedido) {
		this.codigo = codigo;
		this.mesa = mesa;
		this.detallePedido = detallePedido;
	}

	public Pedido() {
	}

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public List<DetallePedido> getDetallePedido() {
		return detallePedido;
	}

	public void setDetallePedido(List<DetallePedido> detallePedido) {
		this.detallePedido = detallePedido;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		result = prime * result + ((mesa == null) ? 0 : mesa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (codigo != other.codigo)
			return false;
		if (mesa == null) {
			if (other.mesa != null)
				return false;
		} else if (!mesa.equals(other.mesa))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pedido [codigo=" + codigo + ", mesa=" + mesa + "]";
	}

}
