/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.threeten.extra.Interval;

/**
 *
 * @author Gold
 */
public class ManejadorDeFechas {
    
    ReservaControlador reservaControlador = new ReservaControlador();
    
    public static Calendar conversorACalendar(String fecha) throws ParseException{
        
        /*----- Obtención y conversión de la fecha, de String a Date, y de Date a Calendar -----*/
            
            // Se crea el formato de la fecha. En la base de datos se guardan las fechas con formato yyyy-MM-dd
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");            

            // Se toma el String obtenido del formulario con la fecha y se lo convierte a Date
            Date dateFormateado = sdf.parse(fecha);

            // Se crea una variable de tipo Calendar con fecha actual para ser modificado luego
            Calendar fechaNacimiento = Calendar.getInstance();

            // Se modifica la variable Calendar, agregándole la fecha del Date al mismo
            fechaNacimiento.setTime(dateFormateado);
                
        /*----- Obtención y conversión de la fecha, de String a Date, y de Date a Calendar - FIN -----*/
        
        return fechaNacimiento;
    }
    
    
    
    public boolean conflictoConFechasReservadas(Calendar checkIn, Calendar checkOut, int nroHabitacion){
        
        // Obtenemos todas las reservas que se hayan hecho hasta el momento
        List<Reserva> reservas = reservaControlador.obtenerTodasLasReservas();
        
        
        // Convertimos las fechas de la nueva reserva a Instant para poder crear nuestro Intervalo de tiempo con Interval 
        // (los intervalos con esta clase solo pueden armarse con 2 objetos de tipo Instant)
        Instant nuevaReservaFechaDesde = checkIn.toInstant();
        Instant nuevaReservaFechaHasta = checkOut.toInstant();
        
        
        // Creamos nuestro Interval con las 2 fechas ya convertidas a Instant
        Interval intervaloNuevaReserva = Interval.of(nuevaReservaFechaDesde, nuevaReservaFechaHasta);
        
        
        // Comprobamos primero que nuestro arreglo de reservas no esté vacío, caso contrario, la nueva reserva se realiza automáticamente.
        if(!reservas.isEmpty()){
            
            // Si existen reservas, recorremos el arreglo
            for(Reserva res : reservas){
                
                // Se hace la comparación de fechas solo si la habitación requerida ya está ocupada en alguna otra reserva.
                if(res.getHabitacion().getNroHabitacion() == nroHabitacion){
                    
                    // Caso de que la habitación pedida ya esté reservada, se comprueba si las fechas de Check-In/Out de ambas no interseccionan.
                    Instant reservaGuardadaFechaDesde = res.getCheckIn().toInstant();
                    Instant reservaGuardadaFechaHasta = res.getCheckOut().toInstant();

                    Interval intervaloReservaGuardada = Interval.of(reservaGuardadaFechaDesde, reservaGuardadaFechaHasta);
                    

                    // Overlaps da TRUE si las fechas se solapan, FALSE caso contrario, es decir, si da FALSE, SE PUEDE RESERVAR
                    return intervaloNuevaReserva.overlaps(intervaloReservaGuardada);
                }
                
            }
            
        }
        
        return false;
    }
    
    
    
    public int diasReservados(Calendar pCheckIn, Calendar pCheckOut){
        int dias=0;
        Calendar checkInNuevo = pCheckIn;
        
        while(checkInNuevo.compareTo(pCheckOut) <= 0){
            dias+=1;
            
            checkInNuevo.add(Calendar.DAY_OF_MONTH, 1);
        }
        
        return dias;
    }
    
}
