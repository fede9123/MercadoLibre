<%-- 
    Document   : consultaPrimoCircular
    Created on : 14/10/2014, 15:59:11
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="src.PrimoCircular" %>
<%@page  import="src.BuscarPrimosCirculares" %>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Primos circulares</title>
    </head>
    <body>
        <form id="formulario" method="POST" action="/Primos/consultaPrimoCircular.jsp">
            <table>
                <tr>
                    <td style="width: 50%; vertical-align: top">
                        <h1>Consultar número</h1>
                        <table style="height: 50%; alignment-baseline: central">
                            <tr>
                                <td>
                                    <input name="numero" id="id_numero" type="number" size="9" 
                                           value="<%=request.getParameter("numero") != null ? request.getParameter("numero") : ""%>">
                                    <input id="botonVerificar" type="submit" value="Consultar">
                                </td>
                            </tr>
                            <%
                                String mensaje = new String();
                                try {
                                    if (request.getParameter("numero") != null
                                            && Integer.valueOf(request.getParameter("numero")) > 1) {

                                        PrimoCircular primoCircular = new PrimoCircular();
                                        if (primoCircular.esPrimoCircular(Integer.parseInt(request.getParameter("numero")))) {
                                            mensaje = "SI es primo circular.";
                                        } else {
                                            mensaje = "NO es primo circular.";
                                        }

                                    } else {
                                        mensaje = "Ingrese un valor entre 1 y 2147483647.";
                                    }
                                } catch (Exception e) {
                                    if (e instanceof NumberFormatException) {
                                        mensaje = "Ingrese un valor entre 1 y 2147483647.";
                                    } else {
                                        mensaje = e.getMessage();
                                    }
                                }%>
                            <label><%=mensaje%></label>   
                        </table>
                    </td>
                    <td style="width: 50%; vertical-align: top">
                        <input name="listar" id="id_listar" type="hidden">
                        <%  int limite = 1000000;
                            ArrayList lista = new ArrayList();
                            String lista_string = new String();
                            if (request.getParameter("listar") == null) {
                                BuscarPrimosCirculares buscador = new BuscarPrimosCirculares();
                                lista = buscador.listarPrimosCirculares(limite);
                                for (int i = 0; i < lista.size(); i++) {
                                    lista_string += lista.get(i) + "\n";
                                }
                        %>
                        <script type="JavaScript">
                            document.getElementById("listado").innerHTML=<%=lista_string%>
                        </script>
                        <%}%>
                        <h2>Cantidad de número primos circulares menores a <%=limite%> encontrados: <%=lista.size()%></h2>
                        <h2>Lista</h2>
                        <label id="listado"><%=lista_string%></label>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
