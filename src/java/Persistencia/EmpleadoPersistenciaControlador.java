/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Empleado;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gold
 */
public class EmpleadoPersistenciaControlador {
    
    EmpleadoJpaController empleadoJpa = new EmpleadoJpaController();
    
    public void agregarUsuarioEmpleado(Empleado emp){
        empleadoJpa.create(emp);
    }
    
    
    public List<Empleado> obtenerTodosLosEmpleados(){
        return empleadoJpa.findEmpleadoEntities();
    }
    
    
    public Empleado obtenerEmpleadoPorId(int idEmpleado){
        return empleadoJpa.findEmpleado(idEmpleado);
    }
    
    
    public void incrementarReservasHechas(Empleado empleado){
        try {
            empleadoJpa.edit(empleado);
        } catch (Exception ex) {
            Logger.getLogger(EmpleadoPersistenciaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
