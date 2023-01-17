<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="ar.com.codoacodo.domain.Departamento" %>
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
		      <th scope="col">ID</th>
		      <th scope="col">Nombre</th>
		      <th scope="col">Presupuesto</th>
		      <th scope="col">Acciones</th>
		    </tr>
		  </thead>
		  <% List<Departamento> listadoDepartamentos = (List<Departamento>)request.getAttribute("listadoDepartamentos"); %>
		  <tbody>
		  	<% for(Departamento d : listadoDepartamentos) { %>
		    <tr>
		      <th scope="row"><%= d.getId() %></th>
		      <td><%= d.getNombre() %></td>
		      <td><%= d.getPresupuesto() %></td>
		      <td>
		      
		      	<a class="" role="button" href="<%=request.getContextPath()%>/UpdateDepartamentoController?id=<%=d.getId()%>">modificar</a>	 
				<!--<button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="miModal" onclick="sendId(<%=d.getId()%>)">Eliminar</button> -->
				<!-- Button trigger modal -->
									<button type="button" class="btn btn-danger" 
										data-bs-toggle="modal" 
										data-bs-target="#exampleModal" 
										onclick="setDepartamentoId(<%=d.getId()%>)">
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
		    	<form action="<%=request.getContextPath()%>/DeleteDepartamentoController">
		    	  <input type="hidden" name="idDepto" id="idDepto">
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
			function setDepartamentoId(id) {
				document.getElementById('idDepto').value=id;
			}
	  </script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
</body>
</html>