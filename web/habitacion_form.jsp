<%-- 
    Document   : habitacion_form
    Created on : 24 jul. 2021, 11:00:59
    Author     : Gold
--%>
<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<% 
    if(usuario == null) { 
        response.sendRedirect("login.jsp");
    }
%>

<%@page import="Logica.HabitacionControlador"%>
<%@page import="Logica.TipoHabitacion"%>


<% HabitacionControlador control = new HabitacionControlador(); %>

<main>
    <section>
        
        <div class="container bloque-formulario-celeste animate__animated animate__backInUp">
            
            <h2 class="titulos">Registrar nueva habitaci�n</h2>
            
            <div class="formulario">
                
                <form action="SvtNuevaHabitacion" method="POST">

                    <label for="">
                        <p class="indicador">Piso donde se encuentra la habitaci�n</p>
                        <input name="piso" class="campos" type="number" placeholder="Ingrese el piso" autocomplete="off">
                    </label>

                    <label for="">
                        <p class="indicador">N�mero de la habitaci�n</p>
                        <input name="nro-habitacion" class="campos" type="number" placeholder="Ingrese el n�mero de la habitaci�n" autocomplete="off">
                    </label>

                    <label for="">
                        <p class="indicador">Costo</p>
                        <input name="costo" class="campos" type="number" placeholder="Ingrese el costo de la habitaci�n" autocomplete="off">
                    </label>      

                    <label for="">
                        <p class="indicador">Seleccione la tem�tica</p>
                        <select name="tematica" id="">
                            <% for(TipoHabitacion tematica : control.tematicas()){ %>

                                <option value="<%= tematica.getId() %>"><%= tematica.getNombreHabitacion() %></option>

                            <% } %>
                        </select>
                    </label>      

                    <div class="boton">
                        <input class="boton-verde" type="submit" value="Registrar nueva habitaci�n">
                    </div>
                    
                </form>
                
            </div>
            
        </div>
        
    </section>
</main>


<%@include file = "plantillas/footer.jsp" %>
