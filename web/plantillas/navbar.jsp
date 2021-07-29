<%-- 
    Document   : navbar
    Created on : 18 jul. 2021, 11:12:45
    Author     : Gold
--%>


<% 
    HttpSession sesion = request.getSession();
    
    String usuario = (String) sesion.getAttribute("usuario");
    String nombre = (String) sesion.getAttribute("nombre");
%>


<div class="barra-de-navegacion">
    
    <nav class="navbar navbar-expand-lg navbar-light bg-light navigation-bar">
        
        <% if(usuario == null) { %>
            <a class="navbar-brand" href="index.jsp">Inicio</a>
        <% } %>
        
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          
            <span class="navbar-toggler-icon"></span>
            
        </button>
        

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            
            <ul class="navbar-nav mr-auto">

                <% if(usuario != null) { %>
                  <li class="nav-item active">
                        <a class="nav-link boton-navbar" href="panel_control.jsp">Panel de control <span class="sr-only">(current)</span></a>
                  </li>
                <% } %>

            </ul>
            
        <% if(usuario != null) { %>
        
          <form class="form-inline my-2 my-lg-0 nav-item" action="SvtCerrarSesion" method="POST">
              <!--<a class="nav-link boton-navbar" href="" type="submit">Cerrar sesión</a>-->
              <input type="submit" class="nav-link boton-navbar" value="Cerrar sesión">
          </form>
          
        <% } %>
        </div>
    </nav>
    
</div>
