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
            
    List<Reserva> reservasHuesped = (List<Reserva>) sesion.getAttribute("listaReservasDeHuesped");

%>


<main>
    
    <section>
        
        
        
    <%  if(reservasHuesped != null){           %>
    <%      if(!reservasHuesped.isEmpty()){    %>
        
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
                <h2 class="titulos animate__animated animate__fadeIn">No se hayaron reservas</h2>
    <%      }                                   %>           
                
    <%      for(Reserva res : reservasHuesped){ %>
    
                <div class="grid-3-columnas">
                    
                    <div>
                        <p class="grid-indicador">Id reserva</p>
                        <p class="grid-dato"><%= res.getId() %></p>
                    </div>
                    
                    <div>
                        <p class="grid-indicador">Check-In</p>
                        <p class="grid-dato"><%= (res.getCheckIn().get(Calendar.DAY_OF_MONTH) + 1) + "/" + (res.getCheckIn().get(Calendar.MONTH) + 1) + "/" + res.getCheckIn().get(Calendar.YEAR) %></p>
                    </div>

                    <div>
                        <p class="grid-indicador">Check-Out</p>
                        <p class="grid-dato"><%= (res.getCheckOut().get(Calendar.DAY_OF_MONTH) + 1) + "/" + (res.getCheckOut().get(Calendar.MONTH) + 1) + "/" + res.getCheckOut().get(Calendar.YEAR) %></p>
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
