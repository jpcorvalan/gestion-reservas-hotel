/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.ReservaPersistenciaControlador;
import java.util.List;

/**
 *
 * @author Gold
 */
public class ReservaControlador {
    
    ReservaPersistenciaControlador reservaControlador = new ReservaPersistenciaControlador();
    
    public List<Reserva> obtenerTodasLasReservas(){
        return reservaControlador.obtenerTodasLasReservas();
    }
    
}
