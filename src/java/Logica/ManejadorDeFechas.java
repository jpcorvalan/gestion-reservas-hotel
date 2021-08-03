/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        
        // Declaramos la variable donde se va a guardar la cantidad de días
        int dias=0;
        
        
        // Iteramos hasta que el CheckIn sobrepase la fecha del CheckOut
        while(pCheckIn.compareTo(pCheckOut) <= 0){
            
            // Mientras siga iterando, la variable aumentará su valor en 1.
            dias+=1;
            
            // Agregamos 1 día más a la fecha del CheckIn, condición que terminará el bucle en su momento.
            pCheckIn.add(Calendar.DAY_OF_MONTH, 1);
        }
        
        
        // La función "add" funciona como un "set", es decir que su valor cambiará globalmente dentro del bucle, por esa razón
        // volvemos a restarle los días que se sumaron en la fecha.
        pCheckIn.add(Calendar.DAY_OF_MONTH, - dias);
        
        
        // Retornamos los días, procedentes del cálculo.
        return dias;
    }
    
    
    
    public List<Reserva> reservasEnDiaEspecifico(Calendar fechaPedida){
        
        // Obtenemos una lista con todas las reservas que se hicieron hasta el momento
        List<Reserva> todasLasReservas = reservaControlador.obtenerTodasLasReservas();
        
        
        // Creamos un HashMap para mantener los intervalos de las reservas, con sus respectivas reservas
        HashMap<Reserva, Interval> reservaConIntervalo = new HashMap<>();
        
        
        // Creamos un ArrayList vacío que luego contendrá las reservas que coinciden con la fecha llegada por parámetro
        List<Reserva> reservasCoincidentes = new ArrayList<>();
        
        
        // Si existen reservas, entonces...
        if(todasLasReservas != null){
            
            
            // Iteramos sobre todas las reservas
            for(Reserva res : todasLasReservas){                
                
                // Creamos intervalos con las fechas de CheckIn/Out de todas las reservas
                Instant checkIn = res.getCheckIn().toInstant();
                Instant checkOut = res.getCheckOut().toInstant();

                Interval intervalo = Interval.of(checkIn, checkOut);

                
                // Agregamos la reserva (clave) con su respectivo intervalo de tiempo (valor) al HashMap.
                reservaConIntervalo.put(res, intervalo);
            }

            
            // Procedemos a "recorrer" el HashMap
            for(Map.Entry<Reserva, Interval> campo : reservaConIntervalo.entrySet()){                
                
                // Si en los Intervalos (valor), se encuentra la fecha pedida por parámetro.
                if(campo.getValue().contains(fechaPedida.toInstant())){                    
                    
                    // Agregamos la reserva (clave) al arreglo de reservas coincidentes.
                    reservasCoincidentes.add(campo.getKey());
                }
            }                    
            
            // Retornamos el ArrayList al que acabamos de agregarle datos.
            return reservasCoincidentes;
        }
        
        
        // Devolverá null si existe ninguna reserva hecha hasta el momento.
        return null;
        
    }
    
}
