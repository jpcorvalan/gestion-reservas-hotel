<%-- 
    Document   : panel_control
    Created on : 24 jul. 2021, 07:27:17
    Author     : Gold
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<main>
    
    <h2 class="titulos">Panel de control</h2>
    
    <section class="panel-general">
        
        <div class="panel-control fondo-negro">
            
            <h2 class="titulos">Registrar datos</h2>
            
            <a href="huesped_form.jsp" class="boton-rojo">Registrar huésped</a>
            <a href="reservar_habitacion_form.jsp" class="boton-rojo">Reservar habitación</a>
            <a href="tipo_habitacion_form.jsp" class="boton-rojo">Agregar temática de habitación nueva</a>
            
            <form action="SvtPrecargaTipoHabitaciones" method="POST" class="formulario-link">
                <input type="submit" class="boton-rojo" value="Agregar habitación nueva">
            </form>
            
        </div>
        
        <div class="panel-control fondo-negro">
            
            <h2 class="titulos">Consultar datos existentes</h2>
            
            <a href="huesped_form.jsp" class="boton-verdev2">Ver todos los huéspedes</a>
            <a href="reservar_habitacion_form.jsp" class="boton-verdev2">Verificar todas las reservas</a>
            <a href="tipo_habitacion_form.jsp" class="boton-verdev2">Ver ganancias diarias</a>
            
            <form action="SvtPrecargaTipoHabitaciones" method="POST" class="formulario-link">
                <input type="submit" class="boton-verdev2" value="Ver ganancias mensuales">                
            </form>
            
        </div>
        
    </section>
    
</main>


<%@include file = "plantillas/footer.jsp" %>
