/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Habitacion;
import Logica.HabitacionControlador;
import Logica.ManejadorDeFechas;
import Logica.Reserva;
import Logica.ReservaControlador;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gold
 */
@WebServlet(name = "SvtModificarReserva", urlPatterns = {"/SvtModificarReserva"})
public class SvtModificarReserva extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvtModificarReserva</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvtModificarReserva at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            // Obtenemos los datos de la sesión para poder agregar los avisos en caso de errores en el formulario
            HttpSession sesion = request.getSession();

            try{
                
                // Obtenemos los datos del formulario y lo guardamos en variables
                int idReserva = Integer.parseInt(request.getParameter("id"));
                String checkInString = request.getParameter("checkin");
                String checkOutString = request.getParameter("checkout");
                int idHabitacion = Integer.parseInt(request.getParameter("habitacion"));
                int idHuesped = Integer.parseInt(request.getParameter("huesped"));
                int cantPersonas = Integer.parseInt(request.getParameter("cantidad-personas"));
                
                
                // Convertimos ambas fechas de String a Calendar
                Calendar checkIn = ManejadorDeFechas.conversorACalendar(checkInString);
                Calendar checkOut = ManejadorDeFechas.conversorACalendar(checkOutString);
                
                
                // Instanciamos el controlador de las habitaciones para buscar la habitación seleccionada por el usuario.
                HabitacionControlador habitacionControlador = new HabitacionControlador();
                Habitacion habitacion = habitacionControlador.obtenerNumeroHabitacion(idHabitacion);
                
                
                // Si la cantidad de personas de la habitación concuerda con la cantidad de personas de la reserva
                if(habitacion.getTematica().getCantidadPersonas() >= cantPersonas){
                    
                    // Si la fecha de CheckIn está antes de la fecha del CheckOut                    
                    if(checkIn.compareTo(checkOut) <= 0){
                        
                        // Instanciamos el manejador de fechas
                        ManejadorDeFechas manejador = new ManejadorDeFechas();
                        
                        // Utilizamos el método sobrecargado conflictoConFechasReservadas, que recibe también el id de la reserva.
                        // Si el método devuelve FALSE, entonces no hay conflicto de fechas y puede editarse la reserva.
                        if(!manejador.conflictoConFechasReservadas(checkIn, checkOut, idHabitacion, idReserva)){
                            
                            // Instanciamos el controlador de las reservas para obtener el id del empleado que realizó la reserva previamente, que no será modificado.                            
                            ReservaControlador reservaControlador = new ReservaControlador();
                            int idEmpleado = reservaControlador.obtenerReservaPorId(idReserva).getUsuarioAlta().getId();
                            
                            // Y también para hacer válida finalmente la edición de la reserva.
                            reservaControlador.actualizarReserva(idReserva, checkIn, checkOut, idHabitacion, idHuesped, cantPersonas, idEmpleado);
                            
                            // Redireccionamos a la pantalla de éxito.
                            response.sendRedirect("edicion_exitosa.jsp");
                            
                        }else{
                            sesion.setAttribute("habitacionOcupada", "La habitación solicitada se encuentra reservada en ese intervalo de días. Seleccione otra habitación, o cambie las fechas.");

                            response.sendRedirect("modificar_reserva.jsp");   
                        }                            
                        
                    }else{
                        sesion.setAttribute("checkInAntesError", "La fecha de Check-In es antes que la del Check-Out, revise las fechas e intente de nuevo.");

                        response.sendRedirect("modificar_reserva.jsp");
                    }
                    
                }else{
                    sesion.setAttribute("cantidadPersonasError", "La cantidad de personas sobrepasa el límite permitido para la habitación. Escoga otra habitación o reduzca el número de personas.");
                
                    response.sendRedirect("modificar_reserva.jsp");
                }
                
                
            }catch (ParseException | NumberFormatException ex) {
                
                System.out.println("Parse Exception?");
                // En caso de haber un error con la conversión de las fechas o de los Strings a Int, la página se recarga.
//                response.sendRedirect("modificar_reserva.jsp");
            }
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idReserva = Integer.parseInt(request.getParameter("id"));
        ReservaControlador reservaControlador = new ReservaControlador();
        Reserva reservaEspecifica = reservaControlador.obtenerReservaPorId(idReserva);
        
        HttpSession sesion = request.getSession();
        sesion.setAttribute("reservaEspecifica", reservaEspecifica);
        response.sendRedirect("modificar_reserva.jsp");
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
