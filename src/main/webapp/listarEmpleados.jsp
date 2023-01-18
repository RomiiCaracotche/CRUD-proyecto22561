<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="ar.com.codoacodo.domain.Empleado" %>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="./estilos.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>

	<div class="container-fluid p-0">

	   		<jsp:include page="header.jsp"/>

			<main class="d-flex flex-column justify-content-center align-items-center w-100">
		
		
				<div class="d-flex justify-content-center mb-4 w-75"> 
				    <form class="d-flex" action="<%=request.getContextPath()%>/SearchEmpleadoController">
					    <input  name="claveBusqueda"  class="form-control me-2" type="search" placeholder="Buscar apellido" aria-label="Search">
					    <button class="btn btn-secondary" type="submit">Buscar</button>
				    </form> 
				    <form class="d-flex ms-2" action="<%=request.getContextPath()%>/FindAllEmpleadoController">
				    	<button type="submit" class="btn btn-info" onclick=>Limpiar</button>
		   			</form> 
		   		</div>
			
				<div class="h-75 d-flex justify-content-center w-75">
					<table class="table table-info table-bordered w-auto text-center m-auto">
					  <thead>
					    <tr>
					      <th scope="col" class="px-4">DNI</th>
					      <th scope="col" class="px-4">Nombre</th>
					      <th scope="col" class="px-4">Apellido</th>
					      <th scope="col" class="px-4">Departamento</th>
					      <th scope="col" class="px-4">Acciones</th>
					    </tr>
					  </thead>
					  <% List<Empleado> listaEmpleados = (List<Empleado>)request.getAttribute("listaEmpleados"); %>
					  <tbody>
					  	<% for(Empleado e : listaEmpleados) { %>
					    <tr>
					      <th scope="row"><%= e.getDni() %></th>
					      <td><%= e.getNombre() %></td>
					      <td><%= e.getApellido() %></td>
					      <td><%= e.getDepartamento() %></td>
					      <td>
					      
					      	<a class="btn btn-warning" role="button" href="<%=request.getContextPath()%>/UpdateEmpleadoController?dni=<%=e.getDni()%>">modificar</a>	 
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
				</div>
			</main>
		
			<jsp:include page="footer.jsp"/>
		
		</div>
			
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

	  <script>
			function setEmpleadoDni(dni) {
				document.getElementById('dni').value=dni;
			}
	  </script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>