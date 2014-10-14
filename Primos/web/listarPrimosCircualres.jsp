<%-- 
    Document   : listarPrimosCircualres
    Created on : 14/10/2014, 12:51:34
    Author     : Usuario
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="src.buscarPrimosCirculares" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista</h1>
        <table>
                <%buscarPrimosCirculares buscador=new buscarPrimosCirculares();
        ArrayList lista=buscador.listarPrimosCirculares(10000);
        for(int i=0;i<lista.size();i++){%>
            <tr>
        <td>
          <%=lista.get(i)%>  
         </td> 
</tr>
        <%}
        %>
</table>
    </body>
</html>
