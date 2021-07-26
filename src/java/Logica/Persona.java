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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que mapea los datos generales de una Persona.
 * Esta clase está pensada para tenga subclases, las cuales heredarán todos sus atributos
 *
 * @author Corvalán Juan Pablo
 */
@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Persona implements Serializable {
    
    
    // Variables de instancia
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    @Basic
    @Column(name = "dni")
    private String dni;
    
    @Basic
    @Column(name = "nombre")
    private String nombre;
    
    @Basic
    @Column(name = "apellido")
    private String apellido;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "fecha_nacimiento")
    private Calendar fechaNacimiento;
    
    @Basic
    @Column(name = "direccion")
    private String direccion;
    
    
    
    

    // Constructores
    public Persona() {
    }

    public Persona(int id, String dni, String nombre, String apellido, Calendar fechaNacimiento, String direccion) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }
    
    
    
    
    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    
    
    // Getters
    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }
    
    
        
}
