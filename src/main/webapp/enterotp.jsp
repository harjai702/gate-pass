<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <title>Gate Paas</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            $('#form1').submit(function(e){
                var frm=$('#form1');
                var a=document.getElementById("otp1").value;
                var b=document.getElementById("r1").value;
                e.preventDefault();
                $.ajax({
                    contentTypedefault: 'application/x-www-form-urlencoded; charset=UTF-8',
                    type: frm.attr('method'),
                    url: frm.attr('action'),
                    dataType: 'text',
                    data: {aa:a,bb:b},
                    success : function(response){
                        var w=response;
                        if(w==="true"){
                            $('#form2').submit();
                        }
                        else{
                            $('#wrong').show();
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
<form:form action="verifyotp" method="post" id="form1">
    Enter Otp<input id="otp1" type="text" name="otp1">
    <div class="alert alert-danger" id="wrong" style="font-size: 18px;display: none;" >
        <strong>Wrong OTP!</strong> Please enter the correct otp!
    </div>
    <input id="r1" type="text" name="r1" style="display: none;" value=${r1}>
    <input type="submit" value="submit">
</form:form>
<form:form action="newpass" method="post" id="form2">
    <input type="text" value=${mail} name="username" style="display: none;" id="username">
</form:form>
</body></html>