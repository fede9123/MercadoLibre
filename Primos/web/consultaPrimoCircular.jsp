<%-- 
    Document   : consultaPrimoCircular
    Created on : 14/10/2014, 15:59:11
    Author     : Usuario
--%>

<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="src.PrimoCircular" %>
<%@page  import="src.BuscarPrimosCirculares" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Primos circulares</title>
    </head>
    <%
        String mensaje = new String();
        if (request.getParameter("consultar") != null
                && request.getParameter("numero") != null) {
            try {
                if (Integer.valueOf(request.getParameter("numero")) >= 1
                     &&   Integer.valueOf(request.getParameter("numero")) <= 1000000) {

                    PrimoCircular primoCircular = new PrimoCircular();
                    if (primoCircular.esPrimoCircular(Integer.parseInt(request.getParameter("numero")))) {
                        mensaje = "SI es primo circular.";
                    } else {
                        mensaje = "NO es primo circular.";
                    }

                } else {
                    mensaje = "Ingrese un valor entre 1 y 1000000.";
                }
            } catch (Exception e) {
                if (e instanceof NumberFormatException) {
                    mensaje = "Ingrese un valor entre 1 y 1000000.";
                } else {
                    mensaje = e.getMessage();
                }
            }
        }

        int limite = 100000000;
        TreeSet lista = new TreeSet();
        String lista_string = new String();

        if (request.getParameter("listar") != null) {
            BuscarPrimosCirculares buscador = new BuscarPrimosCirculares();
            lista = buscador.listarPrimosCirculares(limite);
            Iterator setIterator = lista.iterator();
            while(setIterator.hasNext()){
               lista_string += setIterator.next() + "<br>";
//               setIterator.remove(); //removes current element
            }
        }
    %>
    <body>
        <form id="formulario" method="POST" action="./consultaPrimoCircular.jsp">
            <table>
                <tr>
                    <td style="width: 50%; vertical-align: top">
                        <h1>Consultar número</h1>
                        <table style="height: 50%; alignment-baseline: central">
                            <tr>
                                <td>
                                    <input name="numero" id="id_numero" type="number" size="9" 
                                           value="<%= (request.getParameter("consultar") != null && request.getParameter("numero") != null) ? request.getParameter("numero") : ""%>">
                                    <input name="consultar" id="id_consultar" type="submit" value="Consultar">
                                    <input name="listar" id="id_listar" type="submit" value="Listar">
                                </td>
                            </tr>
                            <tr><td>
                                    <%=mensaje%>
                            </td></tr>    
                        </table>
                    </td>
                    <%if (request.getParameter("listar") != null) {%>
                    <td style="width: 50%; vertical-align: top">
                        <h2>Cantidad de número primos circulares menores a <%=limite%> encontrados: <%=lista.size()%></h2>
                        <h2>Lista</h2>
                        <label id="listado"><%=lista_string%></label>
                    </td>
                    <%}%>
                </tr>
            </table>
        </form>
    </body>
</html>
