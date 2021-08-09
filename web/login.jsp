<%-- 
    Document   : login
    Created on : 22 jul. 2021, 10:27:36
    Author     : Gold
--%>


<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<%     
    String loginError = (String) sesion.getAttribute("loginError");
%>

<main>
    
    <section class="pagina-login">
        
        <div class="container bloque-formulario-morado animate__animated animate__fadeInUp">
            
            <h2 class="titulos">Ingresar</h2>
            
            <div class="formulario">
                
                    <% if(loginError != null) { %>
                        <label for="">
                            <p class="mensaje-error"><%= loginError %></p>
                            <% sesion.setAttribute("loginError", null); %>
                        </label>
                    <% } %>
                
                <form method="post" action="SvtLoginEmpleado">
                    
                    <label for="">
                        <p class="indicador">Ingrese su usuario</p>
                        <input name="usuario" class="campos" type="text" placeholder="Ingrese su usuario" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese su contraseña</p>
                        <input name="password" class="campos" type="password" placeholder="Ingrese una contraseña" autocomplete="off">
                    </label>
                    
                    <div class="boton">
                        <input class="boton-verde" type="submit" value="Ingresar">
                    </div>                    
                    
                </form>
                
            </div>
            
            
        </div>
        
    </section>
    
</main>

<%@include file = "plantillas/footer.jsp" %>
