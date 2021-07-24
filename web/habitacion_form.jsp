<%-- 
    Document   : habitacion_form
    Created on : 24 jul. 2021, 11:00:59
    Author     : Gold
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<main>
    <section>
        
        <div class="container bloque-formulario-celeste animate__animated animate__backInUp">
            
            <h2 class="titulos">Registrar nueva habitación</h2>
            
            <div class="formulario">
                
                <label for="">
                    <p class="indicador">Piso donde se encuentra la habitación</p>
                    <input name="piso" class="campos" type="number" placeholder="Ingrese el piso" autocomplete="off">
                </label>
                
                <label for="">
                    <p class="indicador">Costo</p>
                    <input name="precio" class="campos" type="number" placeholder="Ingrese el costo de la habitación" autocomplete="off">
                </label>      
                
                <label for="">
                    <p class="indicador">Seleccione la temática</p>
                    <select name="" id="">
                        <option value="tematica">Single</option>
                        <option value="tematica">Doble</option>
                        <option value="tematica">Triple</option>
                        <option value="tematica">Cuádruple</option>
                    </select>
                </label>      
                
                <div class="boton">
                    <input class="boton-verde" type="submit" value="Registrar nueva habitación">
                </div>
                
            </div>
            
        </div>
        
    </section>
</main>


<%@include file = "plantillas/footer.jsp" %>
