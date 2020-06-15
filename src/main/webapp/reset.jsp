<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Reset Password</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('#formm').submit(function(e){
                var frm=$('#formm');
                var a=document.getElementById("usern").value;
                $('#username').val(a);
                e.preventDefault();
                $.ajax({
                    contentTypedefault: 'application/x-www-form-urlencoded; charset=UTF-8',
                    type: frm.attr('method'),
                    url: frm.attr('action'),
                    dataType: 'text',
                    data: {aa:a},
                    success : function(response){
                        var w=response;
                        if(w==="true"){
                            $('#form2').submit();
                        }
                        else{
                            $('#msg').show();
                        }
                        $(this).html("Success!");
                    },
                    error: function(){
                        $(this).html("Error!");
                    }
                });
            });
        });
    </script>
</head>

<body>
<form:form action="enterotp1" method="post" id="formm">
    Enter Username:<input id="usern" type="text" required>
    <p id="msg" style="display: none;">This username doesn't exists</p>
    <input type="submit" value="submit">
</form:form>
<form:form action="entrotp" method="post" id="form2">
    <input id="username" type="text" style="display: none;" name="username">
</form:form>
</body></html>