package com.rest.omei.entity;

import java.io.Serializable;

public class Mesa implements Serializable {

	private static final long serialVersionUID = 7792429080609512713L;

	private Long codigo;
	private Salon salon;
	private String descripcion;

	public Mesa() {

	}
	
	public Mesa(Long codigo){
		this.codigo = codigo;
	}
	
	public Mesa(Long codigo, String descripcion){
		this.codigo = codigo;
		this.descripcion = descripcion;
	}

	public Mesa(Long codigo, Salon salon, String descripcion) {
		this.codigo = codigo;
		this.salon = salon;
		this.descripcion = descripcion;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((salon == null) ? 0 : salon.hashCode());
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
		Mesa other = (Mesa) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (salon == null) {
			if (other.salon != null)
				return false;
		} else if (!salon.equals(other.salon))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Mesa [codigo=" + codigo + ", salon=" + salon + ", descripcion=" + descripcion + "]";
	}

}
