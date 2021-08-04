/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Huesped;
import Logica.HuespedControlador;
import Logica.ManejadorDeFechas;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Calendar;
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
@WebServlet(name = "SvtModificarHuespedEspecifico", urlPatterns = {"/SvtModificarHuespedEspecifico"})
public class SvtModificarHuespedEspecifico extends HttpServlet {

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
            out.println("<title>Servlet SvtModificarHuespedEspecifico</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvtModificarHuespedEspecifico at " + request.getContextPath() + "</h1>");
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
        
        try{
            
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String dni = request.getParameter("dni");
            String fechaNacString = request.getParameter("nacimiento");
            String direccion = request.getParameter("direccion");
            String profesion = request.getParameter("profesion");
            
            Calendar fechaNac = ManejadorDeFechas.conversorACalendar(fechaNacString);
            
            HuespedControlador huespedControlador = new HuespedControlador();
            
            huespedControlador.actualizarHuesped(id, dni, nombre, apellido, fechaNac, direccion, profesion);
            
            response.sendRedirect("edicion_exitosa.jsp");
            
        }catch(ParseException ex){
            HttpSession sesion = request.getSession();
            sesion.setAttribute("fechaInvalida", "Por favor ingrese una fecha válida");
            
            response.sendRedirect("modificar_huesped.jsp");
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
        
        int idHuesped = Integer.parseInt(request.getParameter("id"));
        HuespedControlador huespedControlador = new HuespedControlador();
        Huesped huespedAModificar = huespedControlador.obtenerHuespedPorId(idHuesped);
        
        HttpSession sesion = request.getSession(true);
        sesion.setAttribute("huespedAModificar", huespedAModificar);
        response.sendRedirect("modificar_huesped.jsp");        
        
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
