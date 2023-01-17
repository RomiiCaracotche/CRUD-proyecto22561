<%@page import="ar.com.codoacodo.domain.Empleado"%>
<%@page import="ar.com.codoacodo.domain.Departamento"%>
<%@page import="java.util.List" %>

<%
	Empleado emp = (Empleado)request.getAttribute("empleado"); // levanto el empleado que viene del controller
	List<Departamento> listaDepartamentos = (List<Departamento>)request.getAttribute("listaDepartamentos");
%>

<!Doctype html>
<html>
		<head>
		 <!-- Required meta tags -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Editar Empleado</title>
		 <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">  
	</head>
	<body>
	   <div class="container bg-light">
	   		<jsp:include page="header.jsp"/>
	   </div>
		
			<h1>Editar Empleado</h1>
			
			<form action="<%=request.getContextPath()%>/UpdateEmpleadoController" method="POST">
			
					<input type="hidden" name="dni" value="<%=emp.getDni()%>">

					<label for="nombre">Nombre</label>
					<input type="text" name="nombre" id="nombre" value="<%=emp.getNombre()%>" required>
					
					<label for="nombre">Apellido</label>
					<input type="text" name="apellido" id="apellido" value="<%=emp.getApellido()%>" required>

					<label for="presupuesto">Departamento</label>
					<select name="departamento" id="departamento" type="number">
						<option value="<%=emp.getDepartamento()%>"><%=emp.getDepartamento()%></option>
						
		  				<% for(Departamento d : listaDepartamentos) { %>
		  					<% if(d.getId() != emp.getDepartamento()) { %>
		  						<option value="<%=d.getId()%>"><%=d.getId()%></option>
		  					<% } %>
		  				<% } %>
					</select>
<%-- 					<input type="number" name="departamento" id="departamento" value="<%=emp.getDepartamento()%>" required> --%>
					<button type="submit">Editar</button>

			</form>
				
	</body>
</html>