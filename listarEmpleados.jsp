<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="ar.com.codoacodo.domain.Empleado" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
	<div class="container bg-light">
	   	<jsp:include page="header.jsp"/>
	</div>
	
	<div class="container">
	
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">DNI</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Apellido</th>
		      <th scope="col">Departamento</th>
		    </tr>
		  </thead>
		  <% List<Empleado> listadoEmpleados = (List<Empleado>)request.getAttribute("listadoEmpleados"); %>
		  <tbody>
		  	<% for(Empleado e : listadoEmpleados) { %>
		    <tr>
		      <th scope="row"><%= e.getDni() %></th>
		      <td><%= e.getNombre() %></td>
		      <td><%= e.getApellido() %></td>
		      <td><%= e.getDepartamento() %></td>
		      <td>
		      
		      	<a class="" role="button" href="<%=request.getContextPath()%>/UpdateEmpleadoController?id=<%=e.getDni()%>">modificar</a>	 
				<!-- Button trigger modal -->
									<button type="button" class="btn btn-danger" 
										data-bs-toggle="modal" 
										data-bs-target="#exampleModal" 
										onclick="setEmpleadoDni(<%=e.getDni()%>)">
									  Eliminar
									</button>
		      </td>
		    </tr>
		    <% } %>
		  </tbody>
		</table>
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		    	<form action="<%=request.getContextPath()%>/DeleteEmpleadoController">
		    	  <input type="hidden" name="dni" id="dni">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Eliminar Departamento</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        ¿Confirma que desea eliminar? 
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
			        <button type="submit" class="btn btn-danger">Eliminar</button>
			      </div>
		    	</form>
		    </div>
		  </div>
		</div>
	</body>	

	  <script>
			function setEmpleadoDni(dni) {
				document.getElementById('dni').value=dni;
			}
	  </script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>