<%-- 
    Document   : tipo_habitacion_form
    Created on : 24 jul. 2021, 10:45:38
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
        
        <div class="container bloque-formulario-celeste animate__animated animate__backInUp">
            
            <h2 class="titulos">Registrar nueva tem�tica de habitaci�n</h2>
            
            <div class="formulario">
                
                <form action="SvtTipoHabitaciones" method="POST">
                
                    <label for="">
                        <p class="indicador">Tem�tica de la habitaci�n</p>
                        <input name="tematica" class="campos" type="text" placeholder="Ingrese la tem�tica" autocomplete="off">
                    </label>

                    <label for="">
                        <p class="indicador">Cantidad de personas que pueden hospedarse</p>
                        <input name="cantidad-personas" class="campos" type="number" placeholder="Ingrese la cantidad de personas" autocomplete="off">
                    </label>      

                    <label for="">
                        <p class="indicador">Breve descripci�n de la habitaci�n</p>
                        <textarea name="descripcion" id="" cols="30" rows="7" placeholder="Describa como es la tem�tica nueva"></textarea>
                    </label>      

                    <div class="boton">
                        <input class="boton-verde" type="submit" value="Registrar nueva tem�tica">
                    </div>
                    
                </form>
                
            </div>
            
        </div>
        
    </section>
</main>


<%@include file = "plantillas/footer.jsp" %>
