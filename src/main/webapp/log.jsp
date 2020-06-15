<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script
            src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
    <title>Accept/Reject</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script>
        $(document).ready(function(){
            $("#myTable").on('click','.appro1',function(){
                var currentRow=$(this).closest("tr");
                var col1=currentRow.find("td:eq(0)").text();
                var r = confirm("Confirm to Approve");
                if(r==true){
                    $('#aa').val(col1);
                    $('#bb').val("Approved");
                    document.forms[0].submit();
                    //window.location.href = "datacheck.jsp";
                }
                else{

                }
            });
            $("#myTable").on('click','.appro2',function(){
                var currentRow=$(this).closest("tr");
                var col1=currentRow.find("td:eq(0)").text();
                var r = confirm("Confirm to Reject");
                if(r==true){
                    $('#aa').val(col1);
                    $('#bb').val("Rejected");
                    document.forms[0].submit();
                    //window.location.href = "datacheck.jsp";
                }
                else{

                }
            });
        });
    </script>
</head>
<body><br>
<center><b><h1>Chitkara University</h1><h4>(Punjab)</h4></b></center>
<center><h2 style="margin-left: 20px;margin-right:20px;color:#adad85;">
    <b><i>Gate Paas Portal</i></b>
</h2></center>
<div style="margin-left: 1300px">
    <a href="logout" class="btn btn-danger">Logout</a></div><br>
<form action="acpt" method="post">
    <c:if test="${not empty lists}">
        <table class="table table-striped table-hover" id="myTable">
            <tr><td><b>Id</b></td><td><b>Name</b></td><td><b>Leaving Date and Time</b></td><td><b>Coming Date and time</b></td><td><b>Status</b></td><td><b>Accept/Reject</b></td></tr>
            <c:forEach var="lsst" items="${lists}">
            <tr>
                <td>${lsst.idd}</td>
                <td>${lsst.nme}</td>
                <td>${lsst.date} ${lsst.time} </td>
                <td> ${lsst.date2} ${lsst.time2}</td>
                <td>${lsst.status}</td>
                <td><input type="radio" class="appro1" name="1">Accept<br><input type="radio" class="appro2" name="1">Reject</td>
            <tr>
                </c:forEach>
        </table>
    </c:if>
    <input type="text" id="aa" name="idd" style="display:none;">
    <input type="text" id="bb" name="status" style="display:none;">
</form>
</div>
</body>
</html>
