/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Persistencia.EmpleadoPersistenciaControlador;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Gold
 */
public class EmpleadoControlador {
    
    EmpleadoPersistenciaControlador empleadoControlador = new EmpleadoPersistenciaControlador();
    CargoEmpleadoControlador cargoControlador = new CargoEmpleadoControlador();
    
    public void registrarUsuarioEmpleado(String usuario, String password, String nombre, String apellido, String dni, Calendar fechaNacimiento, String direccion, int idCargo){
        Empleado emp = new Empleado();
        
        emp.setUsuario(usuario);
        emp.setPassword(password);
        emp.setNombre(nombre);
        emp.setApellido(apellido);
        emp.setDni(dni);
        emp.setFechaNacimiento(fechaNacimiento);
        emp.setDireccion(direccion);
        emp.setCargo(cargoControlador.obtenerCargoPorId(idCargo));
        
        empleadoControlador.agregarUsuarioEmpleado(emp);
        
    }
    
    
    public Empleado verificarUsuarioEmpleado(String usuario, String password){
        List<Empleado> listaUsuarios = empleadoControlador.obtenerTodosLosEmpleados();
        
        if(!listaUsuarios.isEmpty()){            
            for(Empleado emp : listaUsuarios){
                
                if(emp.getUsuario().equals(usuario) && emp.getPassword().equals(password)){
                    return emp;
                }
                
            }            
        }
        
        return null;
    }
    
    
    public Empleado obtenerEmpleadoPorId(int idEmpleado){
        return empleadoControlador.obtenerEmpleadoPorId(idEmpleado);
    }
    
}
