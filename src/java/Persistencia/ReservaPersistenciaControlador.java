/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Reserva;
import java.util.List;

/**
 *
 * @author Gold
 */
public class ReservaPersistenciaControlador {
    
    ReservaJpaController reservaJpa = new ReservaJpaController();
     
    public List<Reserva> obtenerTodasLasReservas(){
        return reservaJpa.findReservaEntities();
    }
    
}
