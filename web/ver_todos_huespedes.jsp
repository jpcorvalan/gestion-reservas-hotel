<%-- 
    Document   : ver_todos_huespedes
    Created on : 29 jul. 2021, 14:10:05
    Author     : Gold
--%>

<%@page import="java.time.Instant"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="Logica.Huesped"%>
<%@page import="java.util.List"%>
<%@page import="Logica.HuespedControlador"%>
<%@include file = "plantillas/head.jsp" %>
<%@include file = "plantillas/navbar.jsp" %>

<% 
    if(usuario == null) { 
        response.sendRedirect("login.jsp");
    }
    
    HuespedControlador huespedControlador = new HuespedControlador();
    List<Huesped> listaHuespedes = huespedControlador.obtenerTodosLosHuespedes();
    Calendar fechaHoy = new GregorianCalendar();
%>

<main>
    
    <section class="animate__animated">
        
        <h2 class="titulos">Todos los hu?spedes</h2>
        
        <div class="grid-3-columnas">
            <p class="grid-indicador-1024">Nombre</p>
            <p class="grid-indicador-1024">Apellido</p>            
            <p class="grid-indicador-1024">DNI</p>
            <p class="grid-indicador-1024">Direcci?n</p>
            <p class="grid-indicador-1024">Edad</p>
            <p class="grid-indicador-1024">Profesion</p>       
            <p class="grid-indicador-1024"> </p>
            <p class="grid-indicador-1024"> </p>
            <p class="grid-indicador-1024"> </p>
        </div>    
        
        
        <% for(Huesped huesped : listaHuespedes){ %>
        
            <div class="grid-3-columnas">
            
                <div>
                    <p class="grid-indicador">Nombre</p>
                    <p class="grid-dato"><%= huesped.getNombre() %></p>
                </div>

                <div>
                    <p class="grid-indicador">Apellido</p>
                    <p class="grid-dato"><%= huesped.getApellido() %></p>
                </div>


                <div>
                    <p class="grid-indicador">DNI</p>
                    <p class="grid-dato"><%= huesped.getDni() %></p>
                </div>

                <div>
                    <p class="grid-indicador">Direcci?n</p>
                    <p class="grid-dato"><%= huesped.getDireccion() %></p>
                </div>


                <div>
                    <p class="grid-indicador">Edad</p>
                    <p class="grid-dato"><%= fechaHoy.get(Calendar.YEAR) - huesped.getFechaNacimiento().get(Calendar.YEAR) %></p>
                </div>

                  
                <div>
                    <p class="grid-indicador">Profesi?n</p>
                    <p class="grid-dato"><%= huesped.getProfesion()%></p>
                </div>


                <form action="SvtModificarHuespedEspecifico" method="post">
                    <div class="grid-boton-modificar">
                        <input name="id" type="hidden" value="<%= huesped.getId() %>">
                        <button type="submit" class="modificar">Editar</button>
                    </div>
                </form>                   

                
                <form action="SvtReservasHuespedEspecifico" method="post">
                    <div class="grid-boton-modificar">
                        <input name="id" type="hidden" value="<%= huesped.getId() %>">
                        <button type="submit" class="detalles">Reservas</button>
                    </div>
                </form>
                
                <form action="SvtEliminarHuesped" method="post">
                    <div class="grid-boton-modificar">
                        <input name="id" type="hidden" value="<%= huesped.getId() %>">
                        <button onclick="return confirmDeleteHuesped()" type="submit" class="eliminar">Eliminar</button>
                    </div>
                </form>
            
            </div>
        
        <% } %>
        
    </section>
    
</main>

<%@include file = "plantillas/footer.jsp" %>