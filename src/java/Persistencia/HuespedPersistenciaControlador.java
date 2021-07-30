/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Huesped;
import java.util.List;

/**
 *
 * @author Gold
 */
public class HuespedPersistenciaControlador {
    
    HuespedJpaController huespedJpa = new HuespedJpaController();
    
    public void agregarHuesped(Huesped huesped){
        huespedJpa.create(huesped);
    }
    
    public List<Huesped> obtenerTodosLosHuespedes(){
        return huespedJpa.findHuespedEntities();
    }
    
    public Huesped obtenerHuespedPorId(int idHuesped){
        return huespedJpa.findHuesped(idHuesped);
    }
    
}
