<%-- 
    Document   : detalle_reserva.jsp
    Created on : 2 ago. 2021, 17:32:12
    Author     : Gold
--%>

<%@page import="Logica.ManejadorDeFechas"%>
<%@page import="Logica.Reserva"%>
<%@page import="Logica.Huesped"%>
<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<% 
    if(usuario == null) { 
        response.sendRedirect("login.jsp");
    }    
            
%>


<main>
    
    <section class="animate__animated">
        
        <h2 class="titulos">Detalle de la reserva</h2>
        
        <%
            Reserva reserva = (Reserva) sesion.getAttribute("reservaConId");
            ManejadorDeFechas manejador = new ManejadorDeFechas();
            int diasReserva = manejador.diasReservados(reserva.getCheckIn(), reserva.getCheckOut());
        %>
        
        <div class="grid-3-columnas">
            <p class="grid-indicador-1024">Id de reserva</p>
            <p class="grid-indicador-1024">Reserva por</p>
            <p class="grid-indicador-1024">Costo de estadía</p>
            <p class="grid-indicador-1024">Precio por día</p>
            <p class="grid-indicador-1024">Tipo de habitación</p>
        </div>
        
        <div class="grid-3-columnas">            
            
            <div>
                <p class="grid-indicador">Id de reserva</p>
                <p class="grid-dato"><%= reserva.getId() %></p>
            </div>
            
            <div>
                <p class="grid-indicador">Reserva por</p>
                <p class="grid-dato"><%= diasReserva %> días</p>
            </div>
            
            <div>
                <p class="grid-indicador">Costo de la estadía</p>
                <p class="grid-dato">$<%= diasReserva*reserva.getHabitacion().getPrecio() %></p>
            </div>
            
            <div>
                <p class="grid-indicador">Precio por día</p>
                <p class="grid-dato">$<%= reserva.getHabitacion().getPrecio() %></p>
            </div>
            
            <div>
                <p class="grid-indicador">Tipo de habitación</p>
                <p class="grid-dato"><%= reserva.getHabitacion().getTematica().getNombreHabitacion() %></p>
            </div>
            
        </div>
        
    </section>
    
</main>


<%@include file = "plantillas/footer.jsp" %>