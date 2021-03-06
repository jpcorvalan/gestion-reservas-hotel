/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ReservaPersistenciaControlador;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gold
 */
public class ReservaControlador {
    
    ReservaPersistenciaControlador reservaControlador = new ReservaPersistenciaControlador();
    HabitacionControlador habitacionControlador = new HabitacionControlador();
    HuespedControlador huespedControlador = new HuespedControlador();
    EmpleadoControlador empleadoControlador = new EmpleadoControlador();
    
    public void agregarReserva(Calendar checkIn, Calendar checkOut, int idHabitacion, int idHuesped, int cantPersonas, int idEmpleadoAlta){
        Reserva nuevaReserva = new Reserva();
        
        nuevaReserva.setCheckIn(checkIn);
        nuevaReserva.setCheckOut(checkOut);
        nuevaReserva.setHabitacion(habitacionControlador.obtenerNumeroHabitacion(idHabitacion));
        nuevaReserva.setHuesped(huespedControlador.obtenerHuespedPorId(idHuesped));
        nuevaReserva.setCantPersonas(cantPersonas);
        nuevaReserva.setUsuarioAlta(empleadoControlador.obtenerEmpleadoPorId(idEmpleadoAlta));
        nuevaReserva.setEstaActiva(true);
        
        reservaControlador.agregarReserva(nuevaReserva);
    }
    
    public void actualizarReserva(int id, Calendar checkIn, Calendar checkOut, int idHabitacion, int idHuesped, int cantPersonas, int idEmpleadoAlta){
        Reserva nuevaReserva = new Reserva();
        
        nuevaReserva.setId(id);
        nuevaReserva.setCheckIn(checkIn);
        nuevaReserva.setCheckOut(checkOut);
        nuevaReserva.setHabitacion(habitacionControlador.obtenerNumeroHabitacion(idHabitacion));
        nuevaReserva.setHuesped(huespedControlador.obtenerHuespedPorId(idHuesped));
        nuevaReserva.setCantPersonas(cantPersonas);
        nuevaReserva.setUsuarioAlta(empleadoControlador.obtenerEmpleadoPorId(idEmpleadoAlta));
        nuevaReserva.setEstaActiva(true);
        
        reservaControlador.actualizarReserva(nuevaReserva);
    }
    
    public List<Reserva> obtenerTodasLasReservas(){
        return reservaControlador.obtenerTodasLasReservas();
    }
    
    public Reserva obtenerReservaPorId(int id){
        return reservaControlador.obtenerReservaPorId(id);
    }
    
    public List<Reserva> obtenerReservasDeHuespedEspecifico(int idHuesped){
        return reservaControlador.obtenerReservasDeHuespedEspecifico(idHuesped);
    }
    
    public void eliminarReserva(int idReserva){
        reservaControlador.eliminarReserva(idReserva);
    }
    
    public List<Reserva> obtenerReservasDeEmpleado(int idEmpleado){
        return reservaControlador.obtenerReservaDeEmpleado(idEmpleado);
    }
    
    
}
