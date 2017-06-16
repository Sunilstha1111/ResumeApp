<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<b>Education</b>
   <p></p>
   <form action="eduServlet" method = "post">
       Degree: <input type = "text" name = "degree"></input><br/>
       University: <input type = "text" name = "university"></input><br/>
       Graduation Date: <input type = "text" name = "gradD"></input><br/>
      <input type = "hidden" name = "userID" value="${userID}"></input><br/>
       
   <p></p>
     <b>Do you want to enter more educational achievement? You can enter at max 10.</b>
     <p></p>
       <fieldset id = "group1">
       <input type = "radio" name = "group1" value ="Yes" checked> Yes <br/>
       <input type = "radio" name = "group1" value ="No"> No <br/>
              <input type = "hidden" name ="path" value ="edu"> No <br/>
      </fieldset>
       <input type = "Submit">
       </form>
</body>
</html>