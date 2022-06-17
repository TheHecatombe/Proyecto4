package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Articulo;
import java.io.Serializable;

public class ArticuloDTO implements Serializable{
    private Articulo entidad;

    public ArticuloDTO() {
	this.entidad = new Articulo();
    }

    public Articulo getEntidad() {
	return entidad;
    }

    public void setEntidad(Articulo entidad) {
	this.entidad = entidad;
    }
}
