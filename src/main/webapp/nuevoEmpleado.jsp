<%@page import="ar.com.codoacodo.domain.Departamento"%>
<%@page import="java.util.List" %>
<%
	List<Departamento> listaDepartamentos = (List<Departamento>)request.getAttribute("listaDepartamentos");
%>

<!Doctype html>
<html>
<head>
 	<!-- Required meta tags -->
   	<meta charset="utf-8">
   	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Nuevo Empleado</title>
 	<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">  
</head>
<body>

	<div class="container bg-light">
	  	<jsp:include page="header.jsp"/>
	</div>
		
	<h1>Nuevo Empleado</h1>
			
			
	<form action="<%=request.getContextPath()%>/CreateEmpleadoController" method="post">
		  <label for="dni">Dni</label>
		  <input type="text" name="dni" id="dni" required>
		  
		  <label for="nombre">Nombre</label>
		  <input type="text" name="nombre" id="nombre" required>
		  
		  <label for="presupuesto">apellido</label>
		  <input type="text" name="apellido" id="apellido" required>
		  
<!-- 		  <label for="departamento">Departamento</label> -->
<!-- 		  <input type="text" name="departamento" id="departamento" required> -->
		  
		  <label for="departamento">Departamento</label>
			<select name="departamento" id="departamento" type="number">
				<option value="0"></option>
				
	 				<% for(Departamento d : listaDepartamentos) { %>
	 					<option value="<%=d.getId()%>"><%=d.getId()%></option>
	 					<%System.out.println(d.getId()); %>
	 				<% } %>
			</select>
	
		  <button type="submit">Crear</button>

	</form>
				
</body>
</html>