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
 * Clase que mapea los datos del cargo de los empleados de la cadena hotelera (identificación y nombre del cargo)
 * La tabla que representa, está pensada para que ya tenga ciertos datos precargados. 
 *
 * @author Corvalán Juan Pablo
 */
@Entity
@Table(name = "cargo_empleado")
public class CargoEmpleado implements Serializable {
    
    // Variables de instancia
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    @Basic
    @Column(name = "nombre_cargo")
    private String nombreCargo;
    
    
    
    
    // Constructores
    public CargoEmpleado() {
    }

    public CargoEmpleado(int id, String nombreCargo) {
        this.id = id;
        this.nombreCargo = nombreCargo;
    }
    
    
    
    
    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombreCargo(String nombreCargo) {
        this.nombreCargo = nombreCargo;
    }
    
    
    
    
    // Getters
    public int getId() {
        return id;
    }

    public String getNombreCargo() {
        return nombreCargo;
    }   
    
    
}
