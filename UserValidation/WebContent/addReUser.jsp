<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
<form action="reform" method="post">
<p>Add Restricted User</p>

<label>${requestScope.message}</label> <br>

  User Name:
  <br>
  <input type="text" id ="fname" name="firstname" value="" required="required" min="6" >
  <br>
  <br>
  <input type="submit" value="Submit"> 
  <br>
  
<table id="messages" border="1">
            <tr>
                <th>restricted User</th>
                
            </tr>

            <c:forEach var="msg" items="${applicationScope.restricted}">
            <%-- <c:forEach var="msg" items="${sessionScope.restricted}"> --%>
                <tr>
                    <td>${msg}</td>
                  
                </tr>
            </c:forEach>    
        </table>     


 
 </form>

</body>
</html>
