/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Logica.Empleado;
import Logica.EmpleadoControlador;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "SvtLoginEmpleado", urlPatterns = {"/SvtLoginEmpleado"})
public class SvtLoginEmpleado extends HttpServlet {

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
            out.println("<title>Servlet SvtLoginEmpleado</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SvtLoginEmpleado at " + request.getContextPath() + "</h1>");
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
        
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        EmpleadoControlador empleadoControlador = new EmpleadoControlador();
        
        // Verifico que el usuario y la clave brindada estén en la base de datos y devuelve un Empleado si existe
        Empleado empleado = empleadoControlador.verificarUsuarioEmpleado(usuario, password);
        
        // Si el usuario y la clave son válidas, se crea la sesión con los datos del Empleado
        if(empleado != null){
            HttpSession sesion = request.getSession(true);
            
            sesion.setAttribute("usuario", usuario);
            sesion.setAttribute("password", password);
            sesion.setAttribute("nombre", empleado.getNombre());
            sesion.setAttribute("loginError", null);
            
            response.sendRedirect("panel_control.jsp");
        }else{
            HttpSession sesion = request.getSession(true);
            
            sesion.setAttribute("loginError", "El usuario o contraseña son inválidos");
            
            response.sendRedirect("login.jsp");
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
