<%-- 
    Document   : ver_todas_reservas
    Created on : 30 jul. 2021, 16:45:48
    Author     : Gold
--%>


<%@page import="java.util.Date"%>
<%@page import="java.time.temporal.ChronoField"%>
<%@page import="java.time.temporal.TemporalField"%>
<%@page import="java.text.DateFormat.Field"%>
<%@page import="Logica.Reserva"%>
<%@page import="Logica.ReservaControlador"%>
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
    
    ReservaControlador reservaControlador = new ReservaControlador();    
    List<Reserva> reservas = reservaControlador.obtenerTodasLasReservas();
%>

<main>
    
    <section class="animate__animated">
        
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
        
        <% } %>
        
    </section>
    
</main>

<%@include file = "plantillas/footer.jsp" %>
