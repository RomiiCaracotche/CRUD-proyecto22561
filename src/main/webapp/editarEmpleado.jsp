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
		<link rel="stylesheet" href="./estilos.css">
		 <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">  
	</head>
	<body>
	   <div class="container-fluid p-0">

		<jsp:include page="header.jsp"/>

		<main class="d-flex flex-column justify-content-center align-items-center">
		
			<div><h1>Editar Empleado</h1></div>
			
			<div class="h-75 w-100 d-flex justify-content-center align-items-center">
				<div class="w-75 h-75 d-flex flex-column justify-content-center border border-secondary rounded-3">
					
					<form class="d-flex flex-column justify-content-center align-items-center" action="<%=request.getContextPath()%>/UpdateEmpleadoController" method="post">
							<input type="hidden" name="dni" value="<%=emp.getDni()%>">
							<div class="d-flex justify-content-between align-items-center w-75 mb-3">
							    <label for="nombre" class="col-form-label">nombre:</label>
							    <input type="text" name="nombre" class="form-control-plaintext border border-secondary rounded-3 w-75" id="nombre" value="<%=emp.getNombre()%>" required>
		  					</div>
		  					
		  					<div class="d-flex justify-content-between align-items-center w-75 mb-3">
							    <label for="apellido" class="col-form-label">apellido:</label>
							    <input type="text" name="apellido" class="form-control-plaintext border border-secondary rounded-3 w-75" id="apellido" value="<%=emp.getApellido()%>" required>
		  					</div>
		  					
		  					<div class="d-flex justify-content-between align-items-center w-75 mb-3">
							    <label for="departamento" class="col-form-label">departamento:</label>
							    <select class="form-control-plaintext border border-secondary rounded-3 w-75" name="departamento" id="departamento" type="number">
									<option value="<%=emp.getDepartamento()%>"><%=emp.getDepartamento()%></option>
							
					  				<% for(Departamento d : listaDepartamentos) { %>
					  					<% if(d.getId() != emp.getDepartamento()) { %>
					  						<option value="<%=d.getId()%>"><%=d.getId()%></option>
					  					<% } %>
					  				<% } %>
								</select>
		  					</div>
						 
						 	<button type="submit" class="btn btn-dark w-25">EDITAR</button>

					</form>
				</div>
			</div>
		</main>
		
		<jsp:include page="footer.jsp"/>
		
	</div>
	<script>
		let dropdownDpto = document.querySelector("#dropdownDpto");
		console.log(dropdownDpto)
		let dropdownEmp = document.querySelector("#dropdownEmp");
		dropdownDpto.style.display = "none";
		dropdownEmp.style.display = "none";
	</script>	
	</body>
</html>