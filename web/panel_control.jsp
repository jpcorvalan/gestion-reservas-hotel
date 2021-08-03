<%-- 
    Document   : panel_control
    Created on : 24 jul. 2021, 07:27:17
    Author     : Gold
--%>

<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<% 
    if(usuario == null) { 
        response.sendRedirect("login.jsp");
    }
%>

<main>
    
    <h2 class="titulos">Bienvenido <%= nombre%>, ¿qué desea hacer?</h2>
    
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
            
            <a href="ver_todos_huespedes.jsp" class="boton-verdev2">Ver todos los huéspedes</a>
            <a href="ver_todas_reservas.jsp" class="boton-verdev2">Verificar todas las reservas</a>
            <a href="tipo_habitacion_form.jsp" class="boton-verdev2">Ver ganancias diarias</a>
            <a href="tipo_habitacion_form.jsp" class="boton-verdev2">Ver ganancias mensuales</a>
            <a href="otros_empleados_reservas.jsp" class="boton-verdev2">Ver reservas de otros empleados</a>
            
        </div>
        
    </section>
    
</main>


<%@include file = "plantillas/footer.jsp" %>
