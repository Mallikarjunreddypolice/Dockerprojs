<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<body>
<form action="addform" method="post" onsubmit="return checkValidate()">
<p>Add User</p>
<label>${requestScope.message}</label> <br>
  User Name:
  <br>
  <input type="text" id ="fname" name="firstname" value="" required="required" min="6" >
  <br>
  <br>
  <input type="submit" value="Submit"> 
  <br>
  
  <a href="./homePage.html">please click to login</a>

 </form>



<script language="javascript" type="text/javascript">

function checkValidate(){
	
	var username=document.getElementById("fname").value;
	if(username.length <=6 ){
		alert("please enter username more than 6")
		return false;
	}else{
		return true;
	}
}

</script>

</body>
</html>
