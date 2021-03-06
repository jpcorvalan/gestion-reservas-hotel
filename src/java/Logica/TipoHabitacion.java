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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * Clase que mapea un tipo de habitación para la base de datos
 * Esta clase consiste dedicar una tabla exclusiva para los tipos de habitación existentes
 * dentro de la cadena hotelera, pudiendo agregar más tipos de habitaciones si lo es requerido
 * en un futuro por la empresa.
 * La tabla que representa, está pensada para que ya tenga ciertos datos precargados.
 * 
 * @author Corvalán Juan Pablo
 */
@Entity
@Table(name = "tematicas_habitacion")
public class TipoHabitacion implements Serializable {
    
    
    // Variables de instancia
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    @Basic
    @Column(name = "nombre_habitacion")
    private String nombreHabitacion;
    
    @Basic
    @Column(name = "cantidad_personas")
    private int cantidadPersonas;
    
    @Basic
    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
    
    
    
    
    // Constructores
    public TipoHabitacion() {
    }

    public TipoHabitacion(int id, String nombreHabitacion, int cantidadPersonas, String descripcion) {
        this.id = id;
        this.nombreHabitacion = nombreHabitacion;
        this.cantidadPersonas = cantidadPersonas;
        this.descripcion = descripcion;
    }
    
    
    
    
    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombreHabitacion(String nombreHabitacion) {
        this.nombreHabitacion = nombreHabitacion;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
    
    // Getters
    public int getId() {
        return id;
    }

    public String getNombreHabitacion() {
        return nombreHabitacion;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    
    
}
