<%-- 
    Document   : index
    Created on : 17 jul. 2021, 07:57:38
    Author     : Gold
--%>


<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<main>
    
    <section>
        
        <div class="container pagina-inicio">
            
            <h3 class="titulo-bienvenida">¡Hola!<br><br>Bienvenido a la aplicación de administración de reservas del hotel.<br>Por favor, seleccione la acción a realizar:</h3>
            
            <div class="links-ingreso">
                <a class="boton-celeste" href="login.jsp">Ingresar</a>
                <!--<a class="boton-celeste" href="registro.jsp">Registrarse</a>-->
                <form action="SvtCargoEmp" method="POST" class="formulario-link">
                    <input type="submit" class="boton-celeste" value="Registrarse">
                </form>
                <!--<a class="boton-celeste" href="panel_control.jsp">Panel de control</a>-->
                
            </div>            
            
        </div>
        
    </section>
    
</main>


<%@include file = "plantillas/footer.jsp" %>
