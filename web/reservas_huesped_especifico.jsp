<%-- 
    Document   : reservas_huesped_especifico
    Created on : 3 ago. 2021, 14:04:00
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
            
    List<Reserva> reservasHuesped = (List<Reserva>) sesion.getAttribute("listaReservasDeHuesped");

%>


<main>
    
    <section>
        
    <%  if(reservasHuesped != null){           %>
    <%      if(!reservasHuesped.isEmpty()){    %>
        
                <div class="container bloque-formulario-celeste">

                    <h2 class="titulos">Reservas de un día específico</h2>

                    <div class="formulario">

                    <%  if(sesion.getAttribute("fechaVaciaError") != null){ %>

                            <label for="">
                                <p class="mensaje-error"><%= mensajeErrorFechaVacia %></p>
                                <% sesion.setAttribute("fechaVaciaError", null); %>
                            </label>

                        <%  } %>

                        <form action="SvtHuesped" method="get">

                            <input name="id" type="hidden" value="<%= reservasHuesped.get(0).getHuesped().getId() %>">

                            <label for="">
                                <p class="indicador">Ingrese una fecha inicio</p>
                                <input name="fecha-inicio" type="date" class="campos">
                            </label>

                            <label for="">
                                <p class="indicador">Ingrese una fecha limite</p>
                                <input name="fecha-limite" type="date" class="campos">
                            </label>

                            <div class="boton">
                                <input type="submit" class="boton-verde" value="Buscar reservas">
                            </div>

                        </form>

                    </div>

                </div>
        
        
                <h2 class="titulos">Todas las reservas de <%= reservasHuesped.get(0).getHuesped().getNombre() + " " + reservasHuesped.get(0).getHuesped().getApellido() %></h2>
    
                <div class="grid-3-columnas">
                    <p class="grid-indicador-1024">Id reserva</p>
                    <p class="grid-indicador-1024">Check-In</p>
                    <p class="grid-indicador-1024">Check-Out</p>
                    <p class="grid-indicador-1024">Habitación</p>
                    <p class="grid-indicador-1024">Personas</p>
                    <p class="grid-indicador-1024"> </p>
                    <p class="grid-indicador-1024"> </p>
                </div>
    
    <%      } else {                            %>
                <div class="no-reservas-aviso">
                    <h2 class="titulos animate__animated animate__fadeIn">No se hayaron reservas</h2>
                    <a href="ver_todos_huespedes.jsp" class="boton-celeste">Volver a los huéspedes</a>
                </div>
    <%      }                                   %>           
                
    <%      for(Reserva res : reservasHuesped){ %>
    
                <div class="grid-3-columnas">
                    
                    <div>
                        <p class="grid-indicador">Id reserva</p>
                        <p class="grid-dato"><%= res.getId() %></p>
                    </div>
                    
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
                        <p class="grid-indicador">Personas</p>
                        <p class="grid-dato"><%= res.getCantPersonas() %></p>
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
                            
                </div>
                            
    <%      }    %>                        
    <%  }        %>                        
        
    </section>
    
</main>


<%@include file="plantillas/footer.jsp" %>
