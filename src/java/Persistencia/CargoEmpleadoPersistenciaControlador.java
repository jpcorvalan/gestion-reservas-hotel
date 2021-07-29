/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.CargoEmpleado;
import java.util.List;

/**
 *
 * @author Gold
 */
public class CargoEmpleadoPersistenciaControlador {
    
    CargoEmpleadoJpaController cargoEmpJpa = new CargoEmpleadoJpaController();
    
    public void agregarNuevoCargoEmpleado(CargoEmpleado cargo){
        cargoEmpJpa.create(cargo);
    }
    
    public List<CargoEmpleado> obtenerTodosLosCargos(){
        return cargoEmpJpa.findCargoEmpleadoEntities();
    }
    
    public CargoEmpleado obtenerCargoPorId(int idCargo){
        return cargoEmpJpa.findCargoEmpleado(idCargo);
    }
    
}
