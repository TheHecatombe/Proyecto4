/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ipn.mx.modelo.dto;

import com.ipn.mx.modelo.entidades.Categoria;

/**
 *
 * @author jonathan
 */
public class CategoriaDTO {
    private Categoria entidad;
    
    public CategoriaDTO(){
        entidad = new Categoria();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Clave categoria: ").append(entidad.getIdCategoria());
        sb.append("Nombre categoria: ").append(entidad.getNombreCategoria());
        sb.append("Descripcion categoria: ").append(entidad.getDescripcionCategoria());
        
        return sb.toString();
    }

    public Categoria getEntidad() {
        return entidad;
    }

    public void setEntidad(Categoria entidad) {
        this.entidad = entidad;
    }
    
    
    
}
