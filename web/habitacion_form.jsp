<%-- 
    Document   : habitacion_form
    Created on : 24 jul. 2021, 11:00:59
    Author     : Gold
--%>

<%@page import="Logica.HabitacionControlador"%>
<%@page import="Logica.TipoHabitacion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<% HabitacionControlador control = new HabitacionControlador(); %>

<main>
    <section>
        
        <div class="container bloque-formulario-celeste animate__animated animate__backInUp">
            
            <h2 class="titulos">Registrar nueva habitación</h2>
            
            <div class="formulario">
                
                <form action="SvtNuevaHabitacion" method="POST">

                    <label for="">
                        <p class="indicador">Piso donde se encuentra la habitación</p>
                        <input name="piso" class="campos" type="number" placeholder="Ingrese el piso" autocomplete="off">
                    </label>

                    <label for="">
                        <p class="indicador">Número de la habitación</p>
                        <input name="nro-habitacion" class="campos" type="number" placeholder="Ingrese el número de la habitación" autocomplete="off">
                    </label>

                    <label for="">
                        <p class="indicador">Costo</p>
                        <input name="costo" class="campos" type="number" placeholder="Ingrese el costo de la habitación" autocomplete="off">
                    </label>      

                    <label for="">
                        <p class="indicador">Seleccione la temática</p>
                        <select name="tematica" id="">
                            <% for(TipoHabitacion tematica : control.tematicas()){ %>

                                <option value="<%= tematica.getId() %>"><%= tematica.getNombreHabitacion() %></option>

                            <% } %>
                        </select>
                    </label>      

                    <div class="boton">
                        <input class="boton-verde" type="submit" value="Registrar nueva habitación">
                    </div>
                    
                </form>
                
            </div>
            
        </div>
        
    </section>
</main>


<%@include file = "plantillas/footer.jsp" %>
