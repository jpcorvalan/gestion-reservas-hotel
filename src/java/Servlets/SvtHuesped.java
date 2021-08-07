/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.HuespedControlador;
import Logica.ManejadorDeFechas;
import Logica.Reserva;
import Logica.ReservaControlador;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "SvtHuesped", urlPatterns = {"/SvtHuesped"})
public class SvtHuesped extends HttpServlet {

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
            out.println("<title>Servlet SvtHuesped</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvtHuesped at " + request.getContextPath() + "</h1>");
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
        
        try {
            int idHuesped = Integer.parseInt(request.getParameter("id"));
            String fechaInicioString = request.getParameter("fecha-inicio");
            String fechaLimiteString = request.getParameter("fecha-limite");
            
            Calendar fechaInicio = ManejadorDeFechas.conversorACalendar(fechaInicioString);
            Calendar fechaLimite = ManejadorDeFechas.conversorACalendar(fechaLimiteString);
            
            ReservaControlador reservaControlador = new ReservaControlador();
            List<Reserva> reservasHuesped = reservaControlador.obtenerReservasDeHuespedEspecifico(idHuesped);
            
            ManejadorDeFechas manejador = new ManejadorDeFechas();
            
            List<Reserva> reservasEnIntervaloDeFechas = manejador.obtenerReservasPorIntervaloDeFechas(fechaInicio, fechaLimite, reservasHuesped);
            
            sesion.setAttribute("listaReservasDeHuesped", reservasEnIntervaloDeFechas);
            
            response.sendRedirect("reservas_huesped_especifico.jsp");
            
            
        } catch (ParseException ex) {                        
            sesion.setAttribute("fechaVaciaError", "Introduzca una fecha válida para la búsqueda");
            response.sendRedirect("reservas_huesped_especifico.jsp");
            Logger.getLogger(SvtHuesped.class.getName()).log(Level.SEVERE, null, ex);
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
        
        try {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String dni = request.getParameter("dni");
            String fechaNacString = request.getParameter("nacimiento");
            String direccion = request.getParameter("direccion");
            String profesion = request.getParameter("profesion");
            
            Calendar fechaNacimiento = ManejadorDeFechas.conversorACalendar(fechaNacString);
            
            HuespedControlador control = new HuespedControlador();
            
            control.crearHuesped(dni, nombre, apellido, fechaNacimiento, direccion, profesion);
            
            response.sendRedirect("carga_exitosa_view.jsp");
            
            
        } catch (ParseException ex) {
            Logger.getLogger(SvtHuesped.class.getName()).log(Level.SEVERE, null, ex);
            response.sendRedirect("huesped_form.jsp");
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
