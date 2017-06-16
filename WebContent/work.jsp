<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<b> Work Experience</b>
    <p></p>
    <form action="workServlet" method = "post">
        Company:<input type = "text" name = "company"></input><br/>
        Role:<input type = "text" name = "role"></input><br/>
        Tenure:<input type = "text" name = "tenure"></input><br/>
           &emsp;
           Duty-1:<input type = "text" name = "duty1"></input><br/>
           &emsp;
           Duty-1:<input type = "text" name = "duty2"></input><br/>
      <input type = "hidden" name = "userID" value="${userID}"></input><br/>
           
      <p></p> 
         <b>Do you want to enter more work experience? You can enter at max 10.</b>
      <p></p>
        <fieldset id = "group2">
        <input type = "radio" name = "group2" value ="yes"> Yes <br/>
        <input type = "radio" name = "group2" value ="no"> No <br/>
       </fieldset>
       <input type = "Submit">
       </form>
</body>
</html>