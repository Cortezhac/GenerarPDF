<%@page import="java.util.List"%>
<%@page import="DAO.DAOPersona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Persona"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : index
    Created on : 20-jun-2020, 23:32:00
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Registros</h1>
        <a href="ListarPDF">Generar PDF</a>
        <table border="1px">
            <thead>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
            </thead>
            <tbody>
            <% 
                DAOPersona utilidades = new DAOPersona();
                List<Persona> persona = utilidades.listar();
                for(int i = 0; i < persona.size(); i++){
                    Persona tabla = (Persona) persona.get(i);
                
            %>
                <tr>
                    <td><%= tabla.getDui_persona() %></td>
                    <td><%= tabla.getNombre_persona()%></td>
                    <td><%= tabla.getApellidos_persona()%></td>
                </tr>
                <% 
                }
                %>
            </tbody>
        </table>
    </body>
</html>
