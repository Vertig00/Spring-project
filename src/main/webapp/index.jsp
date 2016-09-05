<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
          pageEncoding="ISO-8859-2"
%>
<html>
    <head lang="PL">
        <title>Index</title>
    </head>
    <body>
        <h2>Hello World!</h2>
        <label>cos ciekawego</label>
        <input type="button" value="cos"></input>

                <form action="/MyServlet" method="post">
                  First name: <input type="text" name="param1"><br>
                  <input type="submit" value="Submit">
                </form>

        Aktualny czas: <%=java.util.Calendar.getInstance().getTime()%>
        <br/>
        <!--
        <%
        for (int i=0; i<21; ++i) {
        %>
            Liczba: <%=i%> <br />
        <%
        }
        %>

    </body>
</html>
