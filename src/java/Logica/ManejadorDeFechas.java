/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
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
    
    
    
    public boolean conflictoConFechasReservadas(Calendar checkIn, Calendar checkOut){
        
        List<Reserva> reservas = reservaControlador.obtenerTodasLasReservas();
        
        Instant nuevaReservaFechaDesde = checkIn.toInstant();
        Instant nuevaReservaFechaHasta = checkOut.toInstant();
        
        Interval intervaloNuevaReserva = Interval.of(nuevaReservaFechaDesde, nuevaReservaFechaHasta);
        
        if(!reservas.isEmpty()){
            for(Reserva res : reservas){
                Instant reservaGuardadaFechaDesde = res.getCheckIn().toInstant();
                Instant reservaGuardadaFechaHasta = res.getCheckOut().toInstant();

                Interval intervaloReservaGuardada = Interval.of(nuevaReservaFechaDesde, nuevaReservaFechaHasta);

                // Overlaps da TRUE si las fechas se solapan, FALSE caso contrario, es decir, si da FALSE, SE PUEDE RESERVAR
                return intervaloNuevaReserva.overlaps(intervaloReservaGuardada);
            }
        }
        
        return false;
    }
    
}
