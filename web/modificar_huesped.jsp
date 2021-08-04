<%-- 
    Document   : modificar_huesped
    Created on : 4 ago. 2021, 16:40:27
    Author     : Gold
--%>




<%@page import="Logica.Huesped"%>
<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<% 
    if(usuario == null) { 
        response.sendRedirect("login.jsp");
    }
    
    Huesped huesped = (Huesped) sesion.getAttribute("huespedAModificar");
    String fechaInvalida = (String) sesion.getAttribute("fechaInvalida");

%>

<main>
    <section>
        
        <div class="container bloque-formulario-morado animate__animated animate__backInUp">
            
            <h2 class="titulos">Formulario para editar un huésped</h2>
            
            <div class="formulario">
                
                <!-- Bloque que advierte sobre los posibles errores que ocurran al intentar hacer una reserva -->
                
                    <% if(fechaInvalida!=null){ %>
                        <label for="">
                            <p class="mensaje-error"><%= fechaInvalida %></p>
                            <% sesion.setAttribute("fechaInvalida", null); %>
                        </label>
                    <% } %>
                    
                <!-- Bloque que advierte sobre los posibles errores que ocurran al intentar hacer una reserva -->
                
                <form method="get" action="SvtModificarHuespedEspecifico">
                    

                    <input name="id" class="campos" type="hidden" value="<%= huesped.getId() %>">
                    
                    <label for="">
                        <p class="indicador">Ingrese nombre</p>
                        <input name="nombre" class="campos" type="text" placeholder="Ingrese el nombre" value="<%= huesped.getNombre() %>" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese apellido</p>
                        <input name="apellido" class="campos" type="text" placeholder="Ingrese el apellido" value="<%= huesped.getApellido() %>" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese número de documento</p>
                        <input name="dni" class="campos" type="text" placeholder="Ingrese el DNI" value="<%= huesped.getDni() %>" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese fecha de nacimiento</p>
                        <input name="nacimiento" class="campos" type="date" placeholder="Ingrese la fecha de nacimiento" value="<%= huesped.getFechaNacimiento() %>" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese dirección</p>
                        <input name="direccion" class="campos" type="text" placeholder="Ingrese la dirección" value="<%= huesped.getDireccion() %>" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese profesión del huésped</p>
                        <input name="profesion" class="campos" type="text" placeholder="Ingrese la profesion" value="<%= huesped.getProfesion() %>" autocomplete="off">
                    </label>
                    
                    <div class="boton">
                        <input class="boton-verde" type="submit" value="Actualizar huésped">
                    </div>
                    
                    
                </form>
                
            </div>
            
        </div>
        
    </section>
</main>

<%@include file = "plantillas/footer.jsp" %>

