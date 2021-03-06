<%-- 
    Document   : habitacion_form
    Created on : 24 jul. 2021, 09:59:30
    Author     : Gold
--%>

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
%>

<main>
    
    <section>
        
        <div class="container bloque-formulario-celeste animate__animated animate__backInUp">
            
            <h2 class="titulos">Formulario para reservar habitacion</h2>
            
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
                
                
                <form action="SvtReserva" method="POST">
                
                    <label for="">
                        <p class="indicador">Ingrese fecha de Check-In</p>
                        <input name="checkin" class="campos" type="date" placeholder="" autocomplete="off">
                    </label>

                    <label for="">
                        <p class="indicador">Ingrese fecha de Check-Out</p>
                        <input name="checkout" class="campos" type="date" placeholder="" autocomplete="off">
                    </label>

                    <label for="">
                        <p class="indicador">Ingrese la habitaci?n</p>
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
                        <input name="cantidad-personas" class="campos" type="number" placeholder="Cantidad de personas" autocomplete="off">
                    </label>                

                    <div class="boton">
                        <input class="boton-verde" type="submit" value="Reservar habitaci?n">
                    </div>
                            
                </form>
                
            </div>
            
        </div>
        
    </section>
    
</main>


<%@include file = "plantillas/footer.jsp" %>
