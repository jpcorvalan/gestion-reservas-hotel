/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Clase que mapea los datos generales de una habitacion cualquiera de la cadena hotelera
 * 
 * Contiene los datos de: número identificativo, piso donde se encuentra, precio de la misma, y la temática
 * que está dada por la clase TipoHabitacion
 *
 * @author Corvalán Juan Pablo
 */

@Entity
@Table(name = "habitaciones")
public class Habitacion implements Serializable {
    
    // Variables de instancia
    @Id
    @Column(name = "nro_habitacion")
    private int nroHabitacion;
    
    @Basic
    @Column(name = "piso")
    private int piso;
    
    @Basic
    @Column(name = "precio")
    private double precio;
    
    @OneToOne
    @Column(name = "tematica")
    private TipoHabitacion tematica;
    
    
    
    
    // Constructores
    public Habitacion() {
    }

    public Habitacion(int nroHabitacion, int piso, double precio, TipoHabitacion tematica) {
        this.nroHabitacion = nroHabitacion;
        this.piso = piso;
        this.precio = precio;
        this.tematica = tematica;
    }
    
    
    
    
    // Setters
    public void setNroHabitacion(int nroHabitacion) {
        this.nroHabitacion = nroHabitacion;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTematica(TipoHabitacion tematica) {
        this.tematica = tematica;
    }
    
    
    
    
    // Getters
    public int getNroHabitacion() {
        return nroHabitacion;
    }

    public int getPiso() {
        return piso;
    }

    public double getPrecio() {
        return precio;
    }

    public TipoHabitacion getTematica() {
        return tematica;
    }
    
    
    
    
    
}
