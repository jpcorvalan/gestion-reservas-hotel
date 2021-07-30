/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Habitacion;
import Logica.TipoHabitacion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gold
 */
public class HabitacionPersistenciaControlador {
    
    TipoHabitacionJpaController tipoHabJpa = new TipoHabitacionJpaController();    
    HabitacionJpaController habitacionJpa = new HabitacionJpaController();
    
    
    //----- Métodos referidos a consultas sobre la tabla TipoHabitacion-----
    public void agregarTematicaHabitacion(TipoHabitacion tipoHabitacion){
        tipoHabJpa.create(tipoHabitacion);
    }
    
    public List<TipoHabitacion> obtenerTematicas(){
        return tipoHabJpa.findTipoHabitacionEntities();
    }    
    
    public TipoHabitacion obtenerHabitacionPorId(int id){
        return tipoHabJpa.findTipoHabitacion(id);
    }
    
    
    
    
    
    
    //----- Métodos referidos a consultas sobre la tabla Habitacion-----
    public void agregarNuevaHabitacion(Habitacion habitacion){
        try {
            habitacionJpa.create(habitacion);
        } catch (Exception ex) {
            Logger.getLogger(HabitacionPersistenciaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public List<Habitacion> obtenerTodasLasHabitaciones(){
        return habitacionJpa.findHabitacionEntities();
    }
    
}
