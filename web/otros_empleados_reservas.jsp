<%-- 
    Document   : otros_empleados_reservas
    Created on : 2 ago. 2021, 21:21:44
    Author     : Gold
--%>

<%@page import="Logica.Empleado"%>
<%@page import="java.util.List"%>
<%@page import="Logica.EmpleadoControlador"%>
<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<% 
    if(usuario == null) { 
        response.sendRedirect("login.jsp");
    }
    
    EmpleadoControlador empleadoControlador = new EmpleadoControlador();
    
    List<Empleado> listaEmpleados = empleadoControlador.obtenerTodosLosEmpleados();
%>

<main>
    
    <section>
        
        <h2 class="titulos">Reservas de otros empleados</h2>
        
        <div class="grid-3-columnas">
            <p class="grid-indicador-1024">Nombre</p>
            <p class="grid-indicador-1024">Apellido</p>
            <p class="grid-indicador-1024">Cargo</p>
            <p class="grid-indicador-1024">Reservas hechas</p>
            <p class="grid-indicador-1024"> </p>
        </div>
        
        <% for(Empleado emp : listaEmpleados){ %>
        
            <div class="grid-3-columnas">
            
                <div>
                    <p class="grid-indicador">Nombre</p>
                    <p class="grid-dato"><%= emp.getNombre() %></p>
                </div>
            
                <div>
                    <p class="grid-indicador">Apellido</p>
                    <p class="grid-dato"><%= emp.getApellido() %></p>
                </div>
            
                <div>
                    <p class="grid-indicador">Cargo</p>
                    <p class="grid-dato"><%= emp.getCargo().getNombreCargo() %></p>
                </div>
            
                <div>
                    <p class="grid-indicador">Reservas</p>
                    <p class="grid-dato"><%= emp.getCantidadReservas() %></p>
                </div>
                
                <form action="SvtEmpleado" method="post">
                    <div class="grid-boton-modificar">
                        <input name="id" type="hidden" value="<%= emp.getId() %>">
                        <button class="detalles">Reservas</button>
                    </div>
                </form>
                
            </div>
                
        <% } %>
        
    </section>
    
</main>