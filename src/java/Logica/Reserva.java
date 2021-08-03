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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Clase que mapea la reserva de la habitación si se cumplen la condiciones necesarias
 *
 * @author Corvalán Juan Pablo
 */
@Entity
@Table(name = "reservas")
public class Reserva implements Serializable {
    
    // Variables de instancia
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "check_in")
    private Calendar checkIn;

    @Temporal(TemporalType.DATE)
    @Column(name = "check_out")
    private Calendar checkOut;
    
    @Basic
    @Column(name = "cantidad_personas")
    private int cantPersonas;
    
    @OneToOne
    private Habitacion habitacion;
    
    @OneToOne
    private Persona huesped;
    
    @OneToOne
    private Persona usuarioAlta;
    
    @Basic
    @Column(name = "estado")
    private boolean estaActiva;
    
    
    
    
    // Constructores
    public Reserva() {
    }

    public Reserva(int id, Calendar checkIn, Calendar checkOut, int cantPersonas, Habitacion habitacion, Persona huesped, Persona usuarioAlta, boolean estaActiva) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.cantPersonas = cantPersonas;
        this.habitacion = habitacion;
        this.huesped = huesped;
        this.usuarioAlta = usuarioAlta;
        this.estaActiva = estaActiva;
    }
    
    
    
    
    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCheckIn(Calendar checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(Calendar checkOut) {
        this.checkOut = checkOut;
    }

    public void setCantPersonas(int cantPersonas) {
        this.cantPersonas = cantPersonas;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public void setHuesped(Persona huesped) {
        this.huesped = huesped;
    }

    public void setUsuarioAlta(Persona usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public void setEstaActiva(boolean estaActiva) {
        this.estaActiva = estaActiva;
    }
    
    
    
    
    // Getters
    public int getId() {
        return id;
    }

    public Calendar getCheckIn() {
        return checkIn;
    }

    public Calendar getCheckOut() {
        return checkOut;
    }

    public int getCantPersonas() {
        return cantPersonas;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public Huesped getHuesped() {
        return (Huesped) huesped;
    }

    public Empleado getUsuarioAlta() {
        return (Empleado) usuarioAlta;
    }

    public boolean isEstaActiva() {
        return estaActiva;
    }
    
    
}
