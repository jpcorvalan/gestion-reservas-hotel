/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.CargoEmpleadoPersistenciaControlador;
import java.util.List;

/**
 *
 * @author Gold
 */
public class CargoEmpleadoControlador {
    
    CargoEmpleadoPersistenciaControlador control = new CargoEmpleadoPersistenciaControlador();
    
    public void crearNuevoCargoDeEmpleado(String nombre){
        CargoEmpleado cargo = new CargoEmpleado();
        
        cargo.setNombreCargo(nombre);
        
        control.agregarNuevoCargoEmpleado(cargo);
    }
    
    public List<CargoEmpleado> obtenerTodosLosCargos(){
        return control.obtenerTodosLosCargos();
    }
    
}
