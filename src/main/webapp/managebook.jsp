<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>BookManagement</title>
    <link rel="stylesheet" href="assets/manage.css">
     <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
</head>
<body>

    <div id="main">
        <div class="container">
        	<c:if test = "${sessionScope.acc!= null }">
        		<a href = "log-out">Logout</a>
        	</c:if>
        	<c:if test = "${sessionScope.acc== null }">
        		<a>Login</a>
        	</c:if>
        	
            <div class="name"><h2>BookManagement</h2></div>
            <form action="created-book" class="inforNV" method ="post">
                <h3>Details Information</h3>
                <div class="inforNV-1-2">
                 <span>Quantity </span><input type="text" name = "quantity" value = "" placeholder="Quantity">
                    <span>Description</span><input type="text" name = "description" value = "" placeholder="Description">
                    
                   
                </div>
                <div class="inforNV-2-2 ">
                <span>BookName </span><input type="text" name = "bookName" value = "" placeholder="Name" >
                    <span>Author </span><input type="text" name = "author" value = "" placeholder="Author"> 
                    <span>Price</span><input type="text" name = "price" value = "" placeholder="Price">
                   
                   
                </div>
                 <div class="add-btn">
        			<button>Add NewBook</button>
   				 </div>
            </form>
            <h3 class = "text">Genaral Information</h3>
       	
       		<table class = "table table-Light">
		<thead>
			<tr>
				<th scope ="col">ID</th>
				<th scope ="col">Name</th>
				<th scope ="col">Author</th>
				<th scope ="col">Price</th>
				<th scope ="col">Quantity</th>
				<th scope ="col">Description</th>
				<th scope ="col">Update</th>
				<th scope ="col">Delete</th>
			</tr>
		</thead>
		<c:forEach items ="${listBooks}" var = "book" >
			<tbody>
				<tr>
					<td><c:out value="${book.id}"></c:out></td>
					<td ><c:out value = "${book.bookName}"></c:out></td>
					<td><c:out value="${book.author}"></c:out></td>
					<td><c:out value="${book.quantity}"></c:out></td>
					<td><c:out value = "${book.price}"></c:out></td>
					<td><c:out value = "${book.description}"></c:out></td>
					<td> <a href ="update-book?idBook=<c:out value = "${book.id}"></c:out>"><button  class="update-btn">Update</button> </a></td>
					<td><a href = "delete-book?idBook=<c:out value = "${book.id}"></c:out>"> <button class="remove-btn">Delete</button></a></td>
				</tr>			
		</tbody>
		</c:forEach>
		
	</table>
        </div>
    </div>
  
</body>
</html>