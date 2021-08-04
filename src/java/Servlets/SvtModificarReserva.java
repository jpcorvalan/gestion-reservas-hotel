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
        
            HttpSession sesion = request.getSession();

            try{
                int idReserva = Integer.parseInt(request.getParameter("id"));
                int idHabitacion = Integer.parseInt(request.getParameter("habitacion"));
                int idHuesped = Integer.parseInt(request.getParameter("huesped"));
                int cantPersonas = Integer.parseInt(request.getParameter("cantidad-personas"));

                ReservaControlador reservaControlador = new ReservaControlador();

                Reserva reservaAEditar = reservaControlador.obtenerReservaPorId(idReserva);

                HabitacionControlador habitacionControlador = new HabitacionControlador();
                Habitacion habitacion = habitacionControlador.obtenerNumeroHabitacion(idHabitacion);            

                if(habitacion.getTematica().getCantidadPersonas() >= cantPersonas){
                    reservaControlador.actualizarReserva(idReserva, reservaAEditar.getCheckIn(), reservaAEditar.getCheckOut(), idHabitacion, idHuesped, cantPersonas, reservaAEditar.getUsuarioAlta().getId());
                    response.sendRedirect("edicion_exitosa.jsp");
                }else{
                    sesion.setAttribute("cantidadPersonasError", "La cantidad de personas sobrepasa el límite permitido para la habitación. Escoga otra habitación o reduzca el número de personas.");
                    response.sendRedirect("modificar_reserva.jsp");
                }                
                
            }catch (NumberFormatException ex) {                
                response.sendRedirect("modificar_reserva.jsp");
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
