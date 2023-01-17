<!Doctype html>
<html>
<head>
 	<!-- Required meta tags -->
   	<meta charset="utf-8">
   	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Nuevo Departamento</title>
 	<!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">  
</head>
<body>

	<div class="container bg-light">
	  	<jsp:include page="header.jsp"/>
	</div>
		
	<h1>Nuevo Departamento</h1>
			
			
	<form action="<%=request.getContextPath()%>/CreateDepartamentoController" method="post">
		  <label for="id">Id</label>
		  <input type="text" name="id" id="id" required>
		  
		  <label for="nombre">Nombre</label>
		  <input type="text" name="nombre" id="nombre" required>
		  
		  <label for="presupuesto">presupuesto</label>
		  <input type="text" name="presupuesto" id="presupuesto" required>
	
		  <button type="submit">Crear</button>

	</form>
				
</body>
</html>