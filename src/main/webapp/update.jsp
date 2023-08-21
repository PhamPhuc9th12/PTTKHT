
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
   <link rel="stylesheet" href="assets/manage.css">
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
</head>
<body>
<div id="main2">
        <h3>Update Information Employer</h3>
    <form action="update-book" method ="post">
    	<input class = "add-field"type="text" name ="bID" value = "${idBook}" >
        <input class = "add-field"type="text" name ="bName"  placeholder="Name">
        <input class = "add-field"type="text" name ="bAuthor"  placeholder="Author">
        <input class = "add-field"type="text" name ="bQuantity" placeholder="Quantity">
        <input class = "add-field"type="text" name ="bPrice"  placeholder="Price">
        <input class = "add-field"type="text" name ="bDescription"  placeholder="Description">
    <div class="button-register">
        <button>Update</button>
    </div>
    </form>
    </div>
</body>
</html>