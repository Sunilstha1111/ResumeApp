<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>Skills</b>
     <p></p>
     <form action="SkilServlet" method = "post"> 
         Skill:<input type = "text" name = "skill"></input><br/>
         Rating(Familiar/Intermediate/Professional/Expert):<input type = "text" name = "skill"></input><br/>
                <input type = "hidden" name = "userID" value="${userID}"></input><br/>
         
      <p></p>
      <b>Do you want to enter more skills? You can enter at max 20.</b>
      <p></p>
      <fieldset id = "group3">
        <input type = "radio" name = "group3" value ="Yeah">Yes<br/>
        <input type = "radio" name = "group3" value ="Nah"> No<br/>
        </fieldset>
<input type = "Submit">
</form>
</body>
</html>