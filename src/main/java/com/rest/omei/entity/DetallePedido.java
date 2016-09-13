package com.rest.omei.entity;

import java.io.Serializable;

public class DetallePedido implements Serializable {

	private static final long serialVersionUID = -5596851982028599668L;

	public class CodigoDetallePedido {
		private Pedido pedido;
		private Plato plato;

		public CodigoDetallePedido(Pedido pedido, Plato plato) {
			this.pedido = pedido;
			this.plato = plato;
		}

		public CodigoDetallePedido() {

		}

		public Pedido getPedido() {
			return pedido;
		}

		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}

		public Plato getPlato() {
			return plato;
		}

		public void setPlato(Plato plato) {
			this.plato = plato;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
			result = prime * result + ((plato == null) ? 0 : plato.hashCode());
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
			CodigoDetallePedido other = (CodigoDetallePedido) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (pedido == null) {
				if (other.pedido != null)
					return false;
			} else if (!pedido.equals(other.pedido))
				return false;
			if (plato == null) {
				if (other.plato != null)
					return false;
			} else if (!plato.equals(other.plato))
				return false;
			return true;
		}

		private DetallePedido getOuterType() {
			return DetallePedido.this;
		}

	}

	private CodigoDetallePedido codigo;
	private String subNombre;
	private Double precio;
	private Double cantidad;

	public DetallePedido(CodigoDetallePedido codigo, String subNombre, Double precio, Double cantidad) {
		this.codigo = codigo;
		this.subNombre = subNombre;
		this.precio = precio;
		this.cantidad = cantidad;
	}

	public DetallePedido() {

	}

	public CodigoDetallePedido getCodigo() {
		return codigo;
	}

	public void setCodigo(CodigoDetallePedido codigo) {
		this.codigo = codigo;
	}

	public String getSubNombre() {
		return subNombre;
	}

	public void setSubNombre(String subNombre) {
		this.subNombre = subNombre;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Double getCantidad() {
		return cantidad;
	}

	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		DetallePedido other = (DetallePedido) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "DetallePedido [codigo=" + codigo + ", subNombre=" + subNombre + ", precio=" + precio + ", cantidad="
				+ cantidad + "]";
	}

}
