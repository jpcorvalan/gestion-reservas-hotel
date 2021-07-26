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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Clase que mapea los datos de un empleado de la cadena hotelera.
 * Contendrá los datos de inicio de sesión dentro de la aplicación y la cantidad de reservas
 * que hizo el empleado
 * 
 * Esta es una clase hija de la clase "Persona"
 *
 * @author Corvalán Juan Pablo
 */
@Entity
@Table(name = "empleados")
@PrimaryKeyJoinColumn(referencedColumnName = "id_persona")
public class Empleado extends Persona implements Serializable{
        
    // Variables de instancia    
    @Basic
    @Column(name = "usuario")
    private String usuario;
    
    @Basic
    @Column(name = "password")
    private String password;
    
    @OneToOne
    private CargoEmpleado cargo;
    
    @Basic
    @Column(name = "cantidad_reservas")
    private int cantidadReservas;
    
    
    
    
    // Constructores
    public Empleado() {
    }

    public Empleado(int id, String dni, String nombre, String apellido, Calendar fechaNacimiento, String direccion, 
                    String usuario, String password, CargoEmpleado cargo, int cantidadReservas) 
    {
        super(id, dni, nombre, apellido, fechaNacimiento, direccion);
        this.usuario = usuario;
        this.password = password;
        this.cargo = cargo;
        this.cantidadReservas = cantidadReservas;
    }
    
    
    
    
    // Setters
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCargo(CargoEmpleado cargo) {
        this.cargo = cargo;
    }

    public void setCantidadReservas(int cantidadReservas) {
        this.cantidadReservas = cantidadReservas;
    }
    
    
    
    
    // Getters
    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }

    public CargoEmpleado getCargo() {
        return cargo;
    }

    public int getCantidadReservas() {
        return cantidadReservas;
    }
    
    
    
}
