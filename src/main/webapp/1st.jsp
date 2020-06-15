<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <title>Gate Paas</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script type="text/javascript">
        $(document).ready(function(){
            $('#form1').submit(function(e){
                $('#cont1').fadeOut();
                $('#cont2').fadeIn();
                var frm=$('#form1');
                e.preventDefault();
                var data={}
                var Form=this;
                $.each(this,function(i,v){
                    var input=$(v);
                    data[input.attr("name")]=input.val();
                    delete data["undefned"];
                });
                $.ajax({
                    contentType:'application/json;charset=utf-8',
                    type: frm.attr('method'),
                    url: frm.attr('action'),
                    dataType: 'json',
                    data: JSON.stringify(data),
                    success : function(callback){
                        $('#cont2').fadeOut();
                        $('#cont1').fadeIn();
                        $("#sccss").fadeIn();
                        setTimeout(function() { $("#sccss").fadeOut(); }, 4000);
                        document.getElementById("form1").reset();
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
<div class="container-fliud"  id="cont1" style="background-image:url('https://user-images.githubusercontent.com/42409905/81806109-a1e47580-9539-11ea-857f-fd92c7dfc30b.jpg');background-repeat:no-repeat;background-size:cover;height:950px;">
    <br>
    <br>
        <div style="background-color: white; height: 850px; width: 600px; margin-left: auto; margin-right: auto; opacity:0.9;">
            <div style="text-align: center;">
                <div class="alert alert-success" id="sccss" style="font-size: 18px;display: none;" >
                    <strong>Success!</strong> Gate Paas Registered Successfully.
                </div><br>
                <div style="margin-left:420px;font-size: 14px;"><b>Username:</b><a href="login"><b><i>${uss}</i></b></a></div>
                <img src="https://user-images.githubusercontent.com/42409905/81913484-a9fded00-95ed-11ea-8483-0b4acb0e1742.png"  style="margin-top: 30px;height: 100px;width: 100px;"><br>
                <h1>Chitkara University</h1> <h4>(Punjab)</h4></div>
            <div style="margin-left: 450px;"><a href="login" class="btn btn-success" style="font-size: 14px;">Login</a>
            <a href="logout" class="btn btn-danger" style="font-size: 14px;">Logout</a></div>
            <h5 style="margin-left: 20px;margin-right:20px;color:#adad85;font-size: 13px;">
                <b><i>Fill the details below to apply Gate Paas.
                    We will get back soon to you for the status.</i></b>
            </h5>
            <center><h5 style="color:#adad85;"><span><b>Please note:</b></span> Fields marked with <b><span style="color:red;">*</span></b> are compulsary to fill.</h5></center><br>
            <form:form action="log" method="post" id="form1">
    <table style="margin-left: 40px; width: 80%;font-size: 16px;">
        <tr>
            <td>Username:<b><span style="color:red;">*</span></b></td>
            <td><span><b>${uss}</b></span><input type="text" name="nme" style="display:none;" value=${uss}></td>
        </tr>
        <tr>
            <td><br>Leaving Date and Time<b><span style="color:red;">*</span></b></td>
            <td><br><input type="date" style="width: 80%;" name="date"
                           placeholder="DD:MM:YYYY"><br>
            <br><input type="time" style="width: 80%;" name="time"
                           placeholder="HH:MM--24-hour" ></td>
        </tr>
        <tr>
            <td><br>Coming Date and Time:<b><span style="color:red;">*</span></b></td>
            <td><br><input type="date" style="width: 80%;" name="date2"
                           placeholder="DD:MM:YYYY" ><br>
                <br><input type="time" style="width: 80%;" name="time2"
                            placeholder="HH:MM--24-hour" ></td>
        </tr>
        <input type="text" style="display:none;" value="Pending.." name="status">
    </table><br>
   <div style="text-align: center;"> <input id="submitbtn" type="submit" class="btn btn-info" value="Submit Form" style="font-size:15px;"></div>
</form:form>
<!-- <form action="gendata" method="post">
<input type="submit" value="Accept/Reject">
</form> --><br>
            <div style="margin-left: 450px">
<a href="gendata" class="btn btn-primary" style="font-size: 14px;">Accept/Reject</a><h4><b>(For Admin Only)</b></h4>
            </div>
                <br>

</div>
</div>
<div class="container" id="cont2" style="display: none;">
    <center><h1 style="font-size: 40px">Please Wait.....</h1>
    <p style="font-size:24px;">We are applying your Gate Paas Request!</p>

    <div class="spinner-border" style="height:90px;width:90px;"></div></center>
</div>
</body>
</html>