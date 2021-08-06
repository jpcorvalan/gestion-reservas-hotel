/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Huesped;
import Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gold
 */
public class HuespedPersistenciaControlador {
    
    HuespedJpaController huespedJpa = new HuespedJpaController();
    
    public void agregarHuesped(Huesped huesped){
        huespedJpa.create(huesped);
    }
    
    public void actualizarHuesped(Huesped huesped){
        try {
            huespedJpa.edit(huesped);
        } catch (Exception ex) {
            Logger.getLogger(HuespedPersistenciaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Huesped> obtenerTodosLosHuespedes(){
        return huespedJpa.findHuespedEntities();
    }
    
    public Huesped obtenerHuespedPorId(int idHuesped){
        return huespedJpa.findHuesped(idHuesped);
    }
    
    public void eliminarHuesped(int idHuesped){
        try {
            huespedJpa.destroy(idHuesped);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(HuespedPersistenciaControlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
