<%-- 
    Document   : tipo_habitacion_form
    Created on : 24 jul. 2021, 10:45:38
    Author     : Gold
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<main>
    <section>
        
        <div class="container bloque-formulario-celeste animate__animated animate__backInUp">
            
            <h2 class="titulos">Registrar nueva temática de habitación</h2>
            
            <div class="formulario">
                
                <form action="SvtTest" method="POST">
                
                    <label for="">
                        <p class="indicador">Temática de la habitación</p>
                        <input name="tematica" class="campos" type="text" placeholder="Ingrese la temática" autocomplete="off">
                    </label>

                    <label for="">
                        <p class="indicador">Cantidad de personas que pueden hospedarse</p>
                        <input name="cantidad-personas" class="campos" type="number" placeholder="Ingrese la cantidad de personas" autocomplete="off">
                    </label>      

                    <label for="">
                        <p class="indicador">Breve descripción de la habitación</p>
                        <textarea name="descripcion" id="" cols="30" rows="7" placeholder="Describa como es la temática nueva"></textarea>
                    </label>      

                    <div class="boton">
                        <input class="boton-verde" type="submit" value="Registrar nueva temática">
                    </div>
                    
                </form>
                
            </div>
            
        </div>
        
    </section>
</main>


<%@include file = "plantillas/footer.jsp" %>
