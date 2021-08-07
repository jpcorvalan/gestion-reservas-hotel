<%-- 
    Document   : reservas_de_empleado
    Created on : 7 ago. 2021, 17:29:21
    Author     : Gold
--%>

<%@page import="java.util.Calendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="Logica.Reserva"%>
<%@page import="java.util.List"%>
<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<% 
    if(usuario == null) { 
        response.sendRedirect("login.jsp");
    }
    
    List<Reserva> reservas = (List<Reserva>) sesion.getAttribute("reservasDeEmpleado");
%>

<main>
    <section>
        
<%  if(!reservas.isEmpty()){     %>    
        
        <h2 class="titulos">Todas las reservas</h2>
        <p class="indicador text-center">Las fechas tienen un formato de Año-Mes-Día</p>
        
        <div class="grid-3-columnas">
            <p class="grid-indicador-1024">Check-In</p>
            <p class="grid-indicador-1024">Check-Out</p>
            <p class="grid-indicador-1024">Habitación</p>
            <p class="grid-indicador-1024">Huesped</p>
            <p class="grid-indicador-1024">Personas</p>
            <p class="grid-indicador-1024">Profesion</p>      
            <p class="grid-indicador-1024"> </p>
            <p class="grid-indicador-1024"> </p>
            <p class="grid-indicador-1024"> </p>
        </div>    
        
        
        <% for(Reserva res : reservas){ %>
        
            <div class="grid-3-columnas">
            
                <div>
                    <p class="grid-indicador">Check-In</p>
                    <!--<p class="grid-dato"><%= (res.getCheckIn().get(Calendar.DAY_OF_MONTH) + 1) + "/" + (res.getCheckIn().get(Calendar.MONTH) + 1) + "/" + res.getCheckIn().get(Calendar.YEAR) %></p>-->
                    <p class="grid-dato"><%= res.getCheckIn().toInstant().toString().substring(0, 10) %></p>
                </div>

                <div>
                    <p class="grid-indicador">Check-Out</p>
                    <!--<p class="grid-dato"><%= (res.getCheckOut().get(Calendar.DAY_OF_MONTH) + 1) + "/" + (res.getCheckOut().get(Calendar.MONTH) + 1) + "/" + res.getCheckOut().get(Calendar.YEAR) %></p>-->
                    <p class="grid-dato"><%= res.getCheckOut().toInstant().toString().substring(0, 10) %></p>
                </div>

                <div>
                    <p class="grid-indicador">Habitación</p>
                    <p class="grid-dato"><%= res.getHabitacion().getNroHabitacion() %></p>
                </div>

                <div>
                    <p class="grid-indicador">Huesped</p>
                    <p class="grid-dato"><%= res.getHuesped().getNombre() + " " + res.getHuesped().getApellido() %></p>
                </div>

                <div>
                    <p class="grid-indicador">Personas</p>
                    <p class="grid-dato"><%= res.getCantPersonas() %></p>
                </div>

                <div>
                    <p class="grid-indicador">Profesión</p>
                    <p class="grid-dato"><%= res.getHuesped().getProfesion() %></p>
                </div>

                <form method="post" action="SvtModificarReserva">
                    <div class="grid-boton-modificar">
                        <input type="hidden" name="id" value="<%= res.getId() %>">
                        <button type="submit" class="modificar">Editar</button>
                    </div>
                </form>

                <form method="post" action="SvtDetallesReserva">
                    <div class="grid-boton-modificar">
                        <input type="hidden" name="id" value="<%= res.getId() %>">
                        <button type="submit" class="detalles">Detalles</button>
                    </div>
                </form>
                        
                <form action="SvtEliminarReserva" method="post">
                    <div class="grid-boton-modificar">
                        <input type="hidden" name="id" value="<%= res.getId() %>">
                        <button onclick="return confirmDeleteReserva()" type="submit" class="eliminar">Eliminar</button>
                    </div>
                </form>
        
            </div>
        
<%      } %>

<%  }else{    %>
        <h2 class="titulos">No se hayaron reservas</h2>
<%  }         %>
        
    </section>
</main>


<%@include file = "plantillas/footer.jsp" %>

