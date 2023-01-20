<!Doctype html>
<html>
<head>
 	<!-- Required meta tags -->
   	<meta charset="utf-8">
   	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Nuevo Departamento</title>
	<link rel="stylesheet" href="./estilos.css">
 	<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">  
	

</head>
<body>

	<div class="container-fluid p-0">

		<jsp:include page="header.jsp"/>

		<main class="d-flex flex-column justify-content-center align-items-center">
		
			<div><h1>Nuevo Departamento</h1></div>
			
			<div class="h-75 w-100 d-flex justify-content-center align-items-center">
				<div class="w-75 h-75 d-flex flex-column justify-content-center border border-secondary rounded-3">
					
					<form class="d-flex flex-column justify-content-center align-items-center" action="<%=request.getContextPath()%>/CreateDepartamentoController" method="post">
					
						<div class="d-flex justify-content-between align-items-center w-75 mb-3">
							<label for="id" class="col-form-label">ID:</label>
							<input type="number" name="id" class="form-control-plaintext border border-secondary rounded-3 w-75" id="id" required>
	  					</div>
	  					
	  					<div class="d-flex justify-content-between align-items-center w-75 mb-3">
						    <label for="nombre" class="col-form-label">NOMBRE:</label>
						    <input type="text" name="nombre" class="form-control-plaintext border border-secondary rounded-3 w-75" id="nombre" required>
	  					</div>
	  					
	  					<div class="d-flex justify-content-between align-items-center w-75 mb-3">
						    <label for="presupuesto" class="col-form-label">PRESUPUESTO:</label>
						    <input type="number" name="presupuesto" class="form-control-plaintext border border-secondary rounded-3 w-75" id="presupuesto" required>
	  					</div>
					 
					 	<button type="submit" class="btn btn-dark w-25">CREAR</button>
				

					</form>
				</div>
			</div>
			
		</main>
		
		<jsp:include page="footer.jsp"/>
		
	</div>
	<script>
		let dropdownDpto = document.querySelector("#dropdownDpto");
		let dropdownEmp = document.querySelector("#dropdownEmp");
		dropdownDpto.style.display = "none";
		dropdownEmp.style.display = "none";
	</script>
						
</body>
</html>