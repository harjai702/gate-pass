
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <title>Signup</title>
</head>
<body>
<form method="post" action="signsubmit">
Username:<input type="text" name="username" required><br>
Full Name:<input type="text" name="flname" required><br>
Password:<input type="password" name="password" required><br>
email:<input type="email" name="email" required><br>
Mobile number:<input type="text" name="mber" required><br>
    Authorities: <select name="roles" required>
        <option>ROLE_USER</option>
        <option>ROLE_ADMIN</option>
    </select><br>
<input type="submit" value="submit">
</form>
</body>
</html>
