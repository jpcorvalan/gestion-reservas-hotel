<%-- 
    Document   : ganancias_mensuales
    Created on : 8 ago. 2021, 22:28:48
    Author     : Gold
--%>

<%@page import="Logica.ManejadorDeFechas"%>
<%@page import="Logica.Reserva"%>
<%@page import="java.util.List"%>
<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<% 
    if(usuario == null) { 
        response.sendRedirect("login.jsp");
    }
    
    String mensajeErrorFechaVacia = (String) sesion.getAttribute("fechaVaciaError");
    List<List<Reserva>> reservas = (List<List<Reserva>>) sesion.getAttribute("reservasDelMes");
%>

<main>
        
    <section>
        
        <div class="container bloque-formulario-morado">
            
            <h2 class="titulos">Ganancias del mes especificado</h2>
            
            <div class="formulario">
                
            <%  if(sesion.getAttribute("fechaVaciaError") != null){ %>
            
                    <label for="">
                        <p class="mensaje-error"><%= mensajeErrorFechaVacia %></p>
                        <% sesion.setAttribute("fechaVaciaError", null); %>
                    </label>

                <%  } %>
                
                <form action="SvtGanancias" method="get">
                    
                    <p class="indicador text-center">Ingrese el mes del año del cual desea hacer la búsqueda, seleccionar el día es indiferente</p>
                    
                    <label for="">
                        <p class="indicador">Ingrese mes y año</p>
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
        int dias=0;
        ManejadorDeFechas manejador = new ManejadorDeFechas();
            
        for(List<Reserva> listaSuperior : reservas){                        
            for(Reserva res : listaSuperior){
                total = total + (res.getHabitacion().getPrecio());
            }
        }
%>        
        <div class="container no-reservas-aviso bloque-formulario-morado">
            <h2 class="titulos">Total de días: <%= reservas.size() %><br><br>Ganancias del mes: $<%= total %></h2>
        </div>
<%  }else{                                   %>
        <div class="container no-reservas-aviso bloque-formulario-morado">
            <h2 class="titulos">No existen reservas en el mes especificado.</h2>
        </div>
<%  }   %>
                
                

        
    </section>
    
</main>


<%@include file = "plantillas/footer.jsp" %>

