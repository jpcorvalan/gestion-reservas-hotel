<%-- 
    Document   : panel_control
    Created on : 24 jul. 2021, 07:27:17
    Author     : Gold
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<main>
    
    <section>
        
        <div class="container panel-control">
            
            <p class="titulos">Panel de control</p>
            
            <a href="huesped_form.jsp" class="boton-rojo">Registrar huésped</a>
            <a href="reservar_habitacion_form.jsp" class="boton-rojo">Reservar habitación</a>
            <a href="tipo_habitacion_form.jsp" class="boton-rojo">Agregar temática de habitación nueva</a>
            
            <form action="SvtPrecargaTipoHabitaciones" method="POST" class="formulario-link">
                <input type="submit" class="boton-rojo" value="Agregar habitación nueva">
            </form>
            
        </div>
        
    </section>
    
</main>


<%@include file = "plantillas/footer.jsp" %>
