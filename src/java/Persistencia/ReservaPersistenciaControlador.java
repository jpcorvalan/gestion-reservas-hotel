/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Reserva;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gold
 */
public class ReservaPersistenciaControlador {
    
    ReservaJpaController reservaJpa = new ReservaJpaController();
    
    public void agregarReserva(Reserva reserva){
        reservaJpa.create(reserva);
    }
    
    public void actualizarReserva(Reserva reserva){
        try {
            reservaJpa.edit(reserva);
        } catch (Exception ex) {
            Logger.getLogger(ReservaPersistenciaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public List<Reserva> obtenerTodasLasReservas(){
        return reservaJpa.findReservaEntities();
    }
    
    public Reserva obtenerReservaPorId(int id){
        return reservaJpa.findReserva(id);
    }
    
    public List<Reserva> obtenerReservasDeHuespedEspecifico(int idHuesped){
        return reservaJpa.findReservaByIdHuesped(idHuesped);
    }
    
}
