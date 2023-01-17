<%@page import="ar.com.codoacodo.domain.Empleado"%>
<%
	Empleado emp = (Empleado)request.getAttribute("empleado"); // levanto el departamento que viene del controller
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
					<input type="number" name="departamento" id="departamento" value="<%=emp.getDepartamento()%>" required>
					<button type="submit">Editar</button>

			</form>
				
	</body>
</html>