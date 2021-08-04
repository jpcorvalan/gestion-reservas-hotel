<%-- 
    Document   : edicion_exitosa
    Created on : 4 ago. 2021, 16:52:45
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
    <section>
        
        <div class="container carga-exitosa ">
            
            <h2 class="titulos animate__animated animate__zoomIn">La edición de los datos fue exitosa.</h2>
            
            <a href="panel_control.jsp" class="boton-celeste">Volver al panel de control</a>
            
        </div>
        
    </section>
</main>


<%@include file = "plantillas/footer.jsp" %>
