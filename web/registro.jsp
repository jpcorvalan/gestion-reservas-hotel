<%-- 
    Document   : registro
    Created on : 22 jul. 2021, 10:27:36
    Author     : Gold
--%>

<%@page import="Logica.CargoEmpleadoControlador"%>
<%@page import="Logica.CargoEmpleado"%>

<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<% CargoEmpleadoControlador control = new CargoEmpleadoControlador(); %>

<main>
    
    <section class="pagina-registro">
        
        <div class="container bloque-formulario-celeste animate__animated animate__fadeInUp">
            
            <h2 class="titulos">Registrarse</h2>
            
            <div class="formulario">
                
                <form method="post" action="SvtRegistroEmpleado">
                    
                    <label for="">
                        <p class="indicador">Ingrese un usuario</p>
                        <input name="usuario" class="campos" type="text" placeholder="Ingrese un usuario" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese una contrase�a</p>
                        <input name="password" class="campos" type="password" placeholder="Ingrese una contrase�a" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese su nombre</p>
                        <input name="nombre" class="campos" type="text" placeholder="Ingrese su nombre" autocomplete="off">
                    </label>                    
                    
                    <label for="">
                        <p class="indicador">Ingrese su apellido</p>
                        <input name="apellido" class="campos" type="text" placeholder="Ingrese su apellido" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese su n�mero de documento</p>
                        <input name="dni" class="campos" type="text" placeholder="Ingrese su DNI" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese su fecha de nacimiento</p>
                        <input name="nacimiento" class="campos" type="date" placeholder="Ingrese su fecha de nacimiento" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese su direcci�n</p>
                        <input name="direccion" class="campos" type="text" placeholder="Ingrese su direcci�n" autocomplete="off">
                    </label>
                    
                    <label for="">
                        <p class="indicador">Ingrese el cargo que ocupa</p>
                        <select name="cargo" id="">
                            
                            <% for(CargoEmpleado cargo : control.obtenerTodosLosCargos()) { %>
                            
                                    <option value="<%= cargo.getId() %>"><%= cargo.getNombreCargo()%> </option>
                                    
                            <% } %>
                            
                        </select>
                    </label>
                    
                    <div class="boton">
                        <input class="boton-verde" type="submit" value="Registrarme">
                    </div>
                    
                    <div class="boton">
                        <p class="indicador text-center">Si ya posee una cuenta, puede <a href="login.jsp">INGRESAR</a></p>
                    </div>
                    
                    
                </form>
                
            </div>
            
            
        </div>
        
    </section>
    
</main>

<%@include file = "plantillas/footer.jsp" %>
