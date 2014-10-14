<%-- 
    Document   : consultaPrimoCircular
    Created on : 14/10/2014, 15:59:11
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="src.PrimoCircular" %>

<!DOCTYPE html>
<html>
    <body>
        <h1>Consultar numero</h1>
        <form id="formulario" method="POST" action="/Primos/consultaPrimoCircular.jsp">
        <table style="height: 50%; alignment-baseline: central">
            <tr>
                <td>
                    <input name="numero" id="id_numero" type="number" 
                           value="<%=request.getParameter("numero")!=null?request.getParameter("numero"):""%>">
                    <input id="botonVerificar" type="submit" value="Consultar">
                </td>
            </tr>
            <% if(request.getParameter("numero")!=null){ %>
                <tr>
                    <td colspan="2">
                        <label><%
                        PrimoCircular buscador=new PrimoCircular();
                        if(buscador.esPrimoCircular(Integer.parseInt(request.getParameter("numero")))){%>
                            SI
                        <%}else{%>
                            NO
                        <%}%></label>
                    </td>    
                </tr>
            <%}%>
        </table>
        </form>
    </body>
</html>
