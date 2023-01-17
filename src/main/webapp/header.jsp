<nav class="navbar navbar-expand-lg bg-light">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Navbar</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">

	        <li class="nav-item">
	          <a class="nav-link" href="<%=request.getContextPath()%>/index.jsp">Inicio</a>
	        </li>
	        
	        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Departamento
		          </a>
		          <ul class="dropdown-menu">
		            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/nuevoDepartamento.jsp">Nuevo</a></li>
		            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/FindAllDepartamentoController">Listar</a></li>
		          </ul>
	       	</li>
	       	
	       	<li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Empleado
		          </a>
		          <ul class="dropdown-menu">
<%-- 		            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/nuevoEmpleado.jsp">Nuevo</a></li> --%>
		            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/CreateEmpleadoController">Nuevo</a></li>
		            <li><a class="dropdown-item" href="<%=request.getContextPath()%>/FindAllEmpleadoController">Listar</a></li>
		          </ul>
	       	</li>
	       	
	      </ul>

    </div>
  </div>
</nav>