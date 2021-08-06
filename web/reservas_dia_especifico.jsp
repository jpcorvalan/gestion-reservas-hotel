<%-- 
    Document   : reservas_dia_especifico
    Created on : 2 ago. 2021, 22:23:40
    Author     : Gold
--%>

<%@page import="java.util.Calendar"%>
<%@page import="Logica.Reserva"%>
<%@page import="java.util.List"%>
<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<% 
    if(usuario == null) { 
        response.sendRedirect("login.jsp");
    }
    
    
    String mensajeErrorFechaVacia = (String) sesion.getAttribute("fechaVaciaError");
    
%>

<main>
    
    <section>
        
        <div class="container bloque-formulario-celeste">
            
            <h2 class="titulos">Reservas de un día específico</h2>
            
            <div class="formulario">
                
            <%  if(sesion.getAttribute("fechaVaciaError") != null){ %>
            
                    <label for="">
                        <p class="mensaje-error"><%= mensajeErrorFechaVacia %></p>
                        <% sesion.setAttribute("fechaVaciaError", null); %>
                    </label>

                <%  } %>
                
                <form action="SvtReserva" method="get">
                    
                    <label for="">
                        <p class="indicador">Ingrese la fecha</p>
                        <input name="fecha-pedida" type="date" class="campos">
                    </label>

                    <div class="boton">
                        <input type="submit" class="boton-verde" value="Buscar reservas">
                    </div>
                    
                </form>
                
            </div>
            
        </div>
        
    
        
    <!--            A continuación se mostrarán las reservas si es que se encontró que coincidencias con la búsqueda                -->
    

    <% List<Reserva> reservas = (List<Reserva>) sesion.getAttribute("reservasDiaEspecifico"); %>
    
    <% if(reservas != null){  %>
            
    <%      if(!reservas.isEmpty()){    %>
            <h2 class="titulos">Todas las reservas</h2>

            <div class="grid-3-columnas">
                <p class="grid-indicador-1024">Check-In</p>
                <p class="grid-indicador-1024">Check-Out</p>
                <p class="grid-indicador-1024">Habitación</p>
                <p class="grid-indicador-1024">Huesped a cargo</p>
                <p class="grid-indicador-1024">Personas</p>
                <p class="grid-indicador-1024">Profesion</p>        
                <p class="grid-indicador-1024">Editar</p>        
                <p class="grid-indicador-1024">Detalles</p>        
            </div>    
            
            <% }else{ %>
                <h2 class="titulos animate__animated animate__fadeIn">No se hayaron reservas en la fecha especificada</h2>
            <% } %>


            <% for(Reserva res : reservas){ %>

                <div class="grid-3-columnas">

                    <div>
                        <p class="grid-indicador">Check-In</p>
                        <p class="grid-dato"><%= res.getCheckIn().toInstant().toString().substring(0, 10) %></p>
                    </div>

                    <div>
                        <p class="grid-indicador">Check-Out</p>
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

                    <form method="post" action="SvtModificar">
                        <div class="grid-boton-modificar">
                            <input type="hidden" name="id" value="<%= res.getId() %>">
                            <button type="submit" class="modificar">Editar</button>
                        </div>
                    </form>


                    <form method="post" action="SvtDetalles">
                        <div class="grid-boton-modificar">
                            <input type="hidden" name="id" value="<%= res.getId() %>">
                            <button type="submit" class="detalles">Detalles</button>
                        </div>
                    </form>                           

                </div>

            <% } %>
            
        <% } %>
    </section>
    
</main>

<%@include file = "plantillas/footer.jsp" %>
