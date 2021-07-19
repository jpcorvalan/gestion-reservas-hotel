/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Clase que mapea los datos del huesped que se va a hacer cargo de la reserva en el hotel
 * Contiene datos heredados de la clase Persona, sumado a la profesión del Huesped, dato necesario
 * para realizar la reserva. 
 *
 * @author Corvalán Juan Pablo
 */
@Entity
@Table(name = "huespedes")
@PrimaryKeyJoinColumn(referencedColumnName = "id_persona")
public class Huesped extends Persona implements Serializable {
    
    // Variables de instancia
    @Basic
    @Column(name = "profesion")
    private String profesion;
    
    
    
    
    // Constructores
    public Huesped() {
    }

    public Huesped(int id, String dni, String nombre, String apellido, Calendar fechaNacimiento, String direccion, String profesion) {
        super(id, dni, nombre, apellido, fechaNacimiento, direccion);
        this.profesion = profesion;
    }
    
    
    
    
    // Setter
    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }
    
    
    
    
    // Getter
    public String getProfesion() {
        return profesion;
    }
    
    
    
    
}
