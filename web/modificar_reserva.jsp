<%-- 
    Document   : modificar_reserva
    Created on : 4 ago. 2021, 17:05:24
    Author     : Gold
--%>

<%@page import="java.util.Calendar"%>
<%@page import="Logica.Reserva"%>
<%@page import="Logica.Huesped"%>
<%@page import="Logica.HuespedControlador"%>
<%@page import="Logica.Habitacion"%>
<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<% 
    if(usuario == null) { 
        response.sendRedirect("login.jsp");
    }
%>

<%@page import="Logica.TipoHabitacion"%>
<%@page import="Logica.HabitacionControlador"%>

<% 
    HabitacionControlador habitacionControlador = new HabitacionControlador();
    HuespedControlador huespedControlador = new HuespedControlador();
    
    String checkInAntesError = (String) sesion.getAttribute("checkInAntesError");
    String habitacionOcupada = (String) sesion.getAttribute("habitacionOcupada");
    String cantidadPersonasError = (String) sesion.getAttribute("cantidadPersonasError");
    
    Reserva reserva = (Reserva) sesion.getAttribute("reservaEspecifica");
%>

<main>
    
    <section>
        
<!--        <div class="advertencia-edicion-reserva">
            <p class="mensaje-error">Debido a que la edición de los campos:<br>Check-In<br>Check-Out<br>Habitación<br><br>Pueden interferir con otras reservas ya realizadas, solo se permite editar:<br><br>Huésped a cargo<br>Cantidad de personas</p>
        </div>-->
        
        
        <div class="container bloque-formulario-celeste animate__animated animate__backInUp">
                        
            <h2 class="titulos">Formulario para editar una reserva hecha</h2>
            
            <div class="formulario">                
                
                <!-- Bloque que advierte sobre los posibles errores que ocurran al intentar hacer una reserva -->
                
                    <% if(checkInAntesError!=null){ %>
                        <label for="">
                            <p class="mensaje-error"><%= checkInAntesError %></p>
                            <% sesion.setAttribute("checkInAntesError", null); %>
                        </label>
                    <% } %>

                    <% if(habitacionOcupada!=null){ %>
                        <label for="">
                            <p class="mensaje-error"><%= habitacionOcupada %></p>
                            <% sesion.setAttribute("habitacionOcupada", null); %>
                        </label>
                    <% } %>

                    <% if(cantidadPersonasError!=null){ %>
                        <label for="">
                            <p class="mensaje-error"><%= cantidadPersonasError %></p>
                            <% sesion.setAttribute("cantidadPersonasError", null); %>
                        </label>
                    <% } %>
                    
                <!-- Bloque que advierte sobre los posibles errores que ocurran al intentar hacer una reserva -->
                
                
                <form action="SvtModificarReserva" method="get">
                    
                    <input name="id" type="hidden" value="<%= reserva.getId() %>">
                
                    <label for="">
                        <p class="indicador">Check-In</p>
                        <!--<p class="indicador">Actual: <%= reserva.getCheckIn().get(Calendar.DAY_OF_MONTH) + 1%>/<%= reserva.getCheckIn().get(Calendar.MONTH)+1 %>/<%= reserva.getCheckIn().get(Calendar.YEAR) %></p>-->
                        <p class="indicador">Actual: <%= reserva.getCheckIn().toInstant().toString().substring(0, 10) %> (Formato Año-mes-día)</p>
                        <input name="checkin" class="campos" type="date">
                    </label>

                    <label for="">
                        <p class="indicador">Check-Out</p>
                        <!--<p class="indicador">Actual: <%= reserva.getCheckOut().get(Calendar.DAY_OF_MONTH) + 1 %>/<%= reserva.getCheckOut().get(Calendar.MONTH)+1 %>/<%= reserva.getCheckOut().get(Calendar.YEAR) %></p>-->
                        <p class="indicador">Actual: <%= reserva.getCheckOut().toInstant().toString().substring(0, 10) %> (Formato Año-mes-día)</p>
                        <input name="checkout" class="campos" type="date">
                    </label>

                    <label for="">
                        <p class="indicador">Habitación</p>
                        <select name="habitacion" id="">

                            <% for(Habitacion habitacion : habitacionControlador.obtenerTodasLasHabitaciones()){ %>

                                <option value="<%= habitacion.getNroHabitacion() %>"> <%=habitacion.getNroHabitacion()%> - <%=habitacion.getTematica().getNombreHabitacion() %> - <%= habitacion.getTematica().getCantidadPersonas() %> persona/s</option>

                            <% } %>

                        </select>
                    </label>

                    <label for="">
                        <p class="indicador">Ingrese el huesped a cargo</p>
                        <select name="huesped" id="">
                            
                            <% 
                                for(Huesped huesped : huespedControlador.obtenerTodosLosHuespedes()) { 
                                    String nombreDni = huesped.getNombre() + " " + huesped.getApellido() + " - " + huesped.getDni();
                            %>      
                                    <option value="<%= huesped.getId() %>"> <%= nombreDni %> </option>
                            <% } %>
                            
                        </select>
                    </label>

                    <label for="">
                        <p class="indicador">Ingrese la cantidad de personas</p>
                        <input name="cantidad-personas" class="campos" type="number" value="<%= reserva.getCantPersonas() %>" placeholder="Cantidad de personas" autocomplete="off">
                    </label>                

                    <div class="boton">
                        <input class="boton-verde" type="submit" value="Reservar habitación">
                    </div>
                            
                </form>
                
            </div>
            
        </div>
        
    </section>
    
</main>


<%@include file = "plantillas/footer.jsp" %>

