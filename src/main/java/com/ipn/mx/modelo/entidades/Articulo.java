package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import lombok.Data;

@Data

public class Articulo implements Serializable{
    private int idArticulo;
    private String nombreArticulo;
    private String descripcionArticulo;
    private double precioUnitarioArticulo;
    private int exitenciasArticulo;
    private int stockMinimoArticulo;
    private int stockMaximoArticulo;
    private int idCategoria;
    
}
