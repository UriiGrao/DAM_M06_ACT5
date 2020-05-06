<%-- 
    Document   : index
    Created on : 04-may-2020, 17:28:05
    Author     : uriishii
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Empleados</h1>
        <form action="EmpleadoS" method="POST">Presiona el botón para obtener todos los empleados.
            <input type="submit" name="enviar" value="Ir" />
        </form>
        <form action="insertarEmpleado.html" method="POST">Insertar un empleado nuevo en la B.D..
            <input type="submit" name="enviar" value="Ir" />
        </form>
        <form action="modificarEmpleado.html" method="POST">Modificar el perfil de un empleado existente.
            <input type="submit" name="enviar" value="Ir" />
        </form>
        
        <h3>Validar la entrada de un empleado (suministrando usuario y contraseña)</h3>
    </body>
</html>
