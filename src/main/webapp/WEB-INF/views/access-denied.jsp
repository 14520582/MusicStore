<html>
    <head>
        <title>test</title>
    </head>
    <body>
      <h3>You are not authorized to access user profile.</h3>
      <form action="<%=request.getContextPath()%>/logout" method="POST">
        <input type="submit" value="Logout"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>		
      </form> 
    </body>
</html> 