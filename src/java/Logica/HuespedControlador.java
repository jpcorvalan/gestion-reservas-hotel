/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.HuespedPersistenciaControlador;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Gold
 */
public class HuespedControlador {
    
    HuespedPersistenciaControlador control = new HuespedPersistenciaControlador();
    
    public void crearHuesped(String dni, String nombre, String apellido, Calendar fechaNacimiento, String direccion, String profesion){
        Huesped huesped = new Huesped();
        
        huesped.setDni(dni);
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        huesped.setFechaNacimiento(fechaNacimiento);
        huesped.setDireccion(direccion);
        huesped.setProfesion(profesion);
        
        control.agregarHuesped(huesped);
    }
    
    public void actualizarHuesped(int id, String dni, String nombre, String apellido, Calendar fechaNacimiento, String direccion, String profesion){
        Huesped huesped = new Huesped();
        
        huesped.setId(id);
        huesped.setDni(dni);
        huesped.setNombre(nombre);
        huesped.setApellido(apellido);
        huesped.setFechaNacimiento(fechaNacimiento);
        huesped.setDireccion(direccion);
        huesped.setProfesion(profesion);
        
        control.actualizarHuesped(huesped);
    }
    
    public List<Huesped> obtenerTodosLosHuespedes(){
        return control.obtenerTodosLosHuespedes();
    }
    
    public Huesped obtenerHuespedPorId(int idHuesped){
        return control.obtenerHuespedPorId(idHuesped);
    }
    
    public void eliminarHuesped(int idHuesped){
        control.eliminarHuesped(idHuesped);
    }
    
}
