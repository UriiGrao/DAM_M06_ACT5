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
        <style type="text/css">
            body {
                text-align: center;
            }
        </style>
    </head>
    <body>
        <h1>Incidencias y Empleados</h1>
        <form action="incidenciasEJB.html" method="POST">
            <input type="submit" name="enviar" value="Ir" />
        </form>
        <h1>Historiales</h1>
        <form action="historialesEJB.html" method="POST">
            <input type="submit" name="enviar" value="Ir" />
        </form>
    </body>
</html>
