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
		<link rel="stylesheet" href="./estilos.css">
		 <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">  
	</head>
	<body>
	   <div class="container-fluid p-0">

		<jsp:include page="header.jsp"/>

		<main class="d-flex flex-column justify-content-center align-items-center">
		
			<div><h1>Editar Departamento</h1></div>
			
			<div class="h-75 w-100 d-flex justify-content-center align-items-center">
				<div class="w-75 h-75 d-flex flex-column justify-content-center border border-secondary rounded-3">
					<form class="d-flex flex-column justify-content-center align-items-center" action="<%=request.getContextPath()%>/UpdateDepartamentoController" method="post">
						<input type="hidden" name="id" value="<%=d.getId()%>">
	
						<div class="d-flex justify-content-between align-items-center w-75 mb-3">
						    <label for="nombre" class="col-form-label">nombre:</label>
							<input type="text" name="nombre" class="form-control-plaintext border border-secondary rounded-3 w-75" id="nombre" value="<%=d.getNombre()%>" required>
			  			</div>
			  			
			  			<div class="d-flex justify-content-between align-items-center w-75 mb-3">
						    <label for="presupuesto" class="col-form-label">presupuesto:</label>
							<input type="number" name="presupuesto" class="form-control-plaintext border border-secondary rounded-3 w-75" id="presupuesto" value="<%=d.getPresupuesto()%>" required>
			  			</div>
			  					
						<button type="submit" class="btn btn-dark w-25">Editar</button>

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