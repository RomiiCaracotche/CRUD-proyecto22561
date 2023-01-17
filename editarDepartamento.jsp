<%@page import="ar.com.codoacodo.domain.Departamento"%>
<%
	Departamento d = (Departamento)request.getAttribute("departamento"); // levanto el departamento que viene del controller
%>

<!Doctype html>
<html>
		<head>
		 <!-- Required meta tags -->
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Editar Departamento</title>
		 <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">  
	</head>
	<body>
	   <div class="container bg-light">
	   		<jsp:include page="header.jsp"/>
	   </div>
		
			<h1>Editar Departamento</h1>
			
			<form action="<%=request.getContextPath()%>/UpdateDepartamentoController" method="POST">
					<input type="hidden" name="id" value="<%=d.getId()%>">

					<label for="nombre">Nombre</label>
					<input type="text" name="nombre" id="nombre" value="<%=d.getNombre()%>" required>

					<label for="presupuesto">Presupuesto</label>
					<input type="number" name="presupuesto" id="presupuesto" value="<%=d.getPresupuesto()%>" required>
					<button type="submit">Editar</button>

			</form>
				
	</body>
</html>