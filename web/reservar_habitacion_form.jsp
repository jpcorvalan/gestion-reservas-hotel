<%-- 
    Document   : habitacion_form
    Created on : 24 jul. 2021, 09:59:30
    Author     : Gold
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>


<main>
    
    <section>
        
        <div class="container bloque-formulario-celeste animate__animated animate__backInUp">
            
            <h2 class="titulos">Formulario para reservar habitacion</h2>
            
            <div class="formulario">
                
                <label for="">
                    <p class="indicador">Ingrese fecha de Check-In</p>
                    <input name="checkin" class="campos" type="date" placeholder="" autocomplete="off">
                </label>
                
                <label for="">
                    <p class="indicador">Ingrese fecha de Check-Out</p>
                    <input name="checkout" class="campos" type="date" placeholder="" autocomplete="off">
                </label>
                
                <label for="">
                    <p class="indicador">Ingrese la habitación</p>
                    <select name="tipo-habitacion" id="">
                        <% for(int i=0; i<4; i++){ %>
                            <option value="tipo-habitacion">Single</option>
                        <% } %>
                    </select>
                </label>
                
                <label for="">
                    <p class="indicador">Ingrese el huesped a cargo</p>
                    <input name="huesped" class="campos" type="text" placeholder="" autocomplete="off">
                </label>
                
                <label for="">
                    <p class="indicador">Ingrese la cantidad de personas</p>
                    <input name="checkout" class="campos" type="number" placeholder="Cantidad de personas" autocomplete="off">
                </label>                
                
                <div class="boton">
                    <input class="boton-verde" type="submit" value="Reservar habitación">
                </div>
                
            </div>
            
        </div>
        
    </section>
    
</main>


<%@include file = "plantillas/footer.jsp" %>
