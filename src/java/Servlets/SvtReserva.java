/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.ManejadorDeFechas;
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
@WebServlet(name = "SvtReserva", urlPatterns = {"/SvtReserva"})
public class SvtReserva extends HttpServlet {

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
            out.println("<title>Servlet SvtReserva</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvtReserva at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        
        try {          
            
            // Obtenemos la sesión para verificar qué Empleado realizó la reserva
            HttpSession sesion = request.getSession(true);
            
            
            // Se guardan los datos del formulario en variables
            String checkInString = request.getParameter("checkin");
            String checkOutString = request.getParameter("checkout");
            int idHabitacion = Integer.parseInt(request.getParameter("habitacion"));
            int idHuesped = Integer.parseInt(request.getParameter("huesped"));
            int cantPersonas = Integer.parseInt(request.getParameter("cantidad-personas"));
            int idEmpleadoAlta = (int) sesion.getAttribute("id");
            
            
            // Se convierten las fechas a Calendar
            Calendar checkIn = ManejadorDeFechas.conversorACalendar(checkInString);
            Calendar checkOut = ManejadorDeFechas.conversorACalendar(checkOutString);
            
            
            // Instanciamos nuestra clase ManejadorDeFechas para utilizar el método "conflictoConFechasReservadas"
            ManejadorDeFechas comprobador = new ManejadorDeFechas();
            
            
            // Si la comprobación da FALSE, significa que no hay conflicto entre fechas y puede realizarse la reserva
            if(!comprobador.conflictoConFechasReservadas(checkIn, checkOut, idHabitacion)){                
                ReservaControlador reservaControlador = new ReservaControlador();
                
                reservaControlador.agregarReserva(checkIn, checkOut, idHabitacion, idHuesped, cantPersonas, idEmpleadoAlta);
                
                response.sendRedirect("carga_exitosa_view.jsp");
            }else{
                response.sendRedirect("panel_control.jsp");
            }
            
            
        } catch (ParseException ex) {
            Logger.getLogger(SvtReserva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
