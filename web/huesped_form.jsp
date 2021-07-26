<%-- 
    Document   : huesped_form
    Created on : 24 jul. 2021, 09:15:44
    Author     : Gold
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<main>
    <section>
        
        <div class="container bloque-formulario-morado animate__animated animate__backInUp">
            
            <h2 class="titulos">Formulario para registrar un huésped</h2>
            
            <div class="formulario">
                
                <form method="post" action="SvtHuesped">
                    
                    <label for="">
                        <p class="indicador">Ingrese nombre</p>
                        <input name="nombre" class="campos" type="text" placeholder="Ingrese el nombre" autocomplete="off">
                    </label>                    
                    
                    <label for="">
                        <p class="indicador">Ingrese apellido</p>
                        <input name="apellido" class="campos" type="text" placeholder="Ingrese el apellido" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese número de documento</p>
                        <input name="dni" class="campos" type="text" placeholder="Ingrese el DNI" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese fecha de nacimiento</p>
                        <input name="nacimiento" class="campos" type="date" placeholder="Ingrese la fecha de nacimiento" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese dirección</p>
                        <input name="direccion" class="campos" type="text" placeholder="Ingrese la dirección" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese profesión del huésped</p>
                        <input name="profesion" class="campos" type="text" placeholder="Ingrese la profesion" autocomplete="off">
                    </label>
                    
                    <div class="boton">
                        <input class="boton-verde" type="submit" value="Registrar huésped">
                    </div>
                    
                    
                </form>
                
            </div>
            
        </div>
        
    </section>
</main>

<%@include file = "plantillas/footer.jsp" %>

