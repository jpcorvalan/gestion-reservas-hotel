<%-- 
    Document   : ganancias_diarias
    Created on : 8 ago. 2021, 03:05:12
    Author     : Gold
--%>

<%@page import="Logica.Reserva"%>
<%@page import="java.util.List"%>
<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<% 
    if(usuario == null) { 
        response.sendRedirect("login.jsp");
    }
    
    String mensajeErrorFechaVacia = (String) sesion.getAttribute("fechaVaciaError");
    List<Reserva> reservas = (List<Reserva>) sesion.getAttribute("reservasDiaEspecificoGanancias");
%>

<main>
        
    <section>
        
        <div class="container bloque-formulario-celeste">
            
            <h2 class="titulos">Ganancias de un día específico</h2>
            
            <div class="formulario">
                
            <%  if(sesion.getAttribute("fechaVaciaError") != null){ %>
            
                    <label for="">
                        <p class="mensaje-error"><%= mensajeErrorFechaVacia %></p>
                        <% sesion.setAttribute("fechaVaciaError", null); %>
                    </label>

                <%  } %>
                
                <form action="SvtGanancias" method="post">
                    
                    <label for="">
                        <p class="indicador">Ingrese la fecha</p>
                        <input name="fecha-pedida" type="date" class="campos">
                    </label>

                    <div class="boton">
                        <input type="submit" class="boton-verde" value="Buscar reservas">
                    </div>
                    
                </form>
                
            </div>
            
        </div>
                
        
<%      
    if(reservas!=null && !reservas.isEmpty()){
        double total=0;
            
        for(Reserva res : reservas){                        
            total = total + res.getHabitacion().getPrecio();
        }
%>        
        <div class="container no-reservas-aviso bloque-formulario-celeste">
            <h2 class="titulos">Total de reservas: <%= reservas.size() %><br><br>Ganancias del día: $<%= total %></h2>
        </div>
<%  }else{                                   %>
        <div class="container no-reservas-aviso bloque-formulario-celeste">
            <h2 class="titulos">No existen reservas en el día especificado.</h2>
        </div>
<%  }   %>
                
                

        
    </section>
    
</main>


<%@include file = "plantillas/footer.jsp" %>

