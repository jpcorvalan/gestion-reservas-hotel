<%-- 
    Document   : ver_todos_huespedes
    Created on : 29 jul. 2021, 14:10:05
    Author     : Gold
--%>

<%@page import="java.time.Instant"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="Logica.Huesped"%>
<%@page import="java.util.List"%>
<%@page import="Logica.HuespedControlador"%>
<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<% 
    if(usuario == null) { 
        response.sendRedirect("login.jsp");
    }
    
    HuespedControlador huespedControlador = new HuespedControlador();
    List<Huesped> listaHuespedes = huespedControlador.obtenerTodosLosHuespedes();
    Calendar fechaHoy = new GregorianCalendar();
%>

<main>
    
    <section class="animate__animated">
        
        <h2 class="titulos">Todos los huéspedes</h2>
        
        <div class="grid-3-columnas">
            <p class="grid-indicador-1024">Nombre</p>
            <p class="grid-indicador-1024">Apellido</p>
            <p class="grid-indicador-1024">DNI</p>
            <p class="grid-indicador-1024">Dirección</p>
            <p class="grid-indicador-1024">Edad</p>
            <p class="grid-indicador-1024">Profesion</p>        
        </div>    
        
        
        <% for(Huesped huesped : listaHuespedes){ %>
        
            <div class="grid-3-columnas">
            
                <div>
                    <p class="grid-indicador">Nombre</p>
                    <p class="grid-dato"><%= huesped.getNombre() %></p>
                </div>

                <div>
                    <p class="grid-indicador">Apellido</p>
                    <p class="grid-dato"><%= huesped.getApellido() %></p>
                </div>

                <div>
                    <p class="grid-indicador">DNI</p>
                    <p class="grid-dato"><%= huesped.getDni() %></p>
                </div>

                <div>
                    <p class="grid-indicador">Dirección</p>
                    <p class="grid-dato"><%= huesped.getDireccion() %></p>
                </div>

                <div>
                    <p class="grid-indicador">Edad</p>
                    <p class="grid-dato"><%= fechaHoy.get(Calendar.YEAR) - huesped.getFechaNacimiento().get(Calendar.YEAR) %></p>
                </div>

                <div>
                    <p class="grid-indicador">Profesión</p>
                    <p class="grid-dato"><%= huesped.getProfesion()%></p>
                </div>

                <div class="grid-boton-modificar">
                    <a class="" href="#">Modificar</a>
                </div>
            
            </div>
                
                <p class="text-danger"><%= huesped.getFechaNacimiento() %></p>
                <% Instant aInstant= huesped.getFechaNacimiento().toInstant(); %>
                <p class="text-warning"><%=aInstant %></p>
        
        <% } %>
        
    </section>
    
</main>

<%@include file = "plantillas/footer.jsp" %>