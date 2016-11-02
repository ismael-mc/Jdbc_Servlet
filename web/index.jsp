<%-- 
    Document   : index
    Created on : 31-oct-2016, 16:45:42
    Author     : Ismael
--%>
<%@page import="databases.Sql_sentences"%>
<%Sql_sentences sql = new Sql_sentences();; %>
<%ResultSet resultsql = null;%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 align="center">WELCOME TO THE CLASS</h1>
        <section align="center">
            <form action="http://localhost:8080/Jdbc_Servlet/Student_Servlet" method="post">
                <select name="codeSelect">
                    <option value="0">Select a Student</option>
                    <% resultsql = sql.StudentList();
                    while (resultsql.next()) {%>
                    <option  value="<%=resultsql.getInt("codi")%>"><%=resultsql.getString("nom")%></option>
                    <%}%>
                </select>
                <input type="submit" value=send>
            </form>
        </section>
    </body>
</html>
