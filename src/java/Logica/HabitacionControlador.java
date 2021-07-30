/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.HabitacionPersistenciaControlador;
import java.util.List;

/**
 *
 * @author Gold
 */
public class HabitacionControlador {
    
    HabitacionPersistenciaControlador control = new HabitacionPersistenciaControlador();    
    
    public void crearTematicaHabitacion(String tematica, int cantPersonas, String descripcion){
        TipoHabitacion tipoHabitacion = new TipoHabitacion();
        
        tipoHabitacion.setNombreHabitacion(tematica);
        tipoHabitacion.setCantidadPersonas(cantPersonas);
        tipoHabitacion.setDescripcion(descripcion);
        
        control.agregarTematicaHabitacion(tipoHabitacion);        
    }
    
    public List<TipoHabitacion> tematicas(){
        return control.obtenerTematicas();
    }
    
    public TipoHabitacion obtenerTematicaHabitacionPorId(int id){
        return control.obtenerTematicaHabitacionPorId(id);
    }
    
    
    
    
    
    
    public void crearNuevaHabitacion(int numHab, int piso, double costo, int tematica){
        Habitacion habitacion = new Habitacion();
        
        habitacion.setNroHabitacion(numHab);
        habitacion.setPiso(piso);
        habitacion.setPrecio(costo);
        habitacion.setTematica(this.obtenerTematicaHabitacionPorId(tematica));
        
        control.agregarNuevaHabitacion(habitacion);
    }
    
    public List<Habitacion> obtenerTodasLasHabitaciones(){
        return control.obtenerTodasLasHabitaciones();
    }
    
    public Habitacion obtenerNumeroHabitacion(int nroHabitacion){
        return control.obtenerNumeroHabitacion(nroHabitacion);
    }
    
    
    
}
