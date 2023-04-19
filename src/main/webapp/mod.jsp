<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
	crossorigin="anonymous"></script>
<title>(Admin) Buscar</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Raleway');

@import
	url(https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css)
	;

body::before {
	content: '';
	background-color: rgba(127, 97, 2, 0.5);
	position: absolute;
	top: 0;
	left: 0;
	bottom: 0;
	right: 0;
	z-index: -1;
}

.ini {
	font-family: 'Raleway', serif;
	background-color: rgba(158, 255, 78, 0.5);
	background-image:
		url("https://tecnomarketingnews.com/wp-content/uploads/2016/08/ubosquejpfg.jpg");
	background-repeat: no-repeat;
	background-size: cover;
	background-attachment: fixed;
	overflow: scroll;
	position: relative;
	margin: 0;
	padding: 0;
}

.container {
	height: 100vh;
}

#pr {
	background-color: azure;
	border-radius: 5px;
}

#tit {
	font-size: 20px;
}
</style>

</head>
<body class="ini">
	<h1 class="d-block p-2 text-bg-warning text-center">Universidad el
		Bosque</h1>
	<form class="pb-lg-3 pt-lg-3"
		action="http://localhost:8080/SistemaPostulados/ServletAdmin"
		method="post" enctype="multipart/form-data">
	

			<div class="container pt-lg-3 "id="pr">
				<div class="row g-2 ">
					<h2>Busqueda de postulado</h2>
					<div class="col-6">
						<label class="form-label">Apellidos</label> <input
							name="apellidoAnt" type="text" class="form-control"
							pattern="[A-Za-z ]+" title="No se permiten Simbolos ni Numeros"
							required>
					</div>
					<div class="col-6">
						<label class="form-label">Fecha de Nacimiento</label> <input
							type="date" name="fechaAnt" class="form-control" required>
					</div>
				</div>
			
				<h2>Modificacion de datos</h2>
				<div class="row g-3">
				<div class="col-md-6">
					<label class="form-label">Nombres</label> <input name="nombre"
						type="text" class="form-control" pattern="[A-Za-z ]+"
						title="No se permiten Simbolos ni Numeros" required>
				</div>
				<div class="col-md-6">
					<label class="form-label">Apellidos</label> <input name="apellido"
						type="text" class="form-control" pattern="[A-Za-z ]+"
						title="No se permiten Simbolos ni Numeros" required>
				</div>
				<div class="col-12">
					<label class="form-label">Fecha de Nacimiento</label> <input
						type="date" name="fecha" class="form-control" min="1904-01-01"
						max="2023-04-29" required>
				</div>
				<div class="col-12">
					<label class="form-label">Colegio en el que se graduo</label> <input
						type="text" name="colegio" class="form-control" required>
				</div>
				<div class="col-md-6">
					<label class="form-label">Carrera deseada</label> <select
						name="carrera" class="form-select">
						<option value="Administracion de Empresas" selected>Administración
							de Empresas</option>
						<option value="Antropologia">Antropología</option>
						<option value="Arquitectura">Arquitectura</option>
						<option value="Artes Escenicas">Artes Escénicas</option>
						<option value="Biologia">Biología</option>
						<option value="Ciencia Politica">Ciencia Política</option>
						<option value="Comunicacion Social y Periodismo">Comunicación
							Social y Periodismo</option>
						<option value="Contaduria Publica">Contaduría Pública</option>
						<option value="Derecho">Derecho</option>
						<option value="Diseno Grafico">Diseño Gráfico</option>
						<option value="Economia">Economía</option>
						<option value="Enfermeria">Enfermería</option>
						<option value="Filosofia">Filosofía</option>
						<option value="Fisioterapia">Fisioterapia</option>
						<option value="Fonoaudiologia">Fonoaudiología</option>
						<option value="Ingenieria Ambiental">Ingeniería Ambiental</option>
						<option value="Ingenieria Biomedica">Ingeniería Biomédica</option>
						<option value="Ingenieria Civil">Ingeniería Civil</option>
						<option value="Ingenieria de Sistemas">Ingeniería de
							Sistemas</option>
						<option value="Ingenieria Industrial">Ingeniería
							Industrial</option>
						<option value="Licenciatura en Educacion Infantil">Licenciatura
							en Educación Infantil</option>
						<option value="Licenciatura en Lengua Inglesa">Licenciatura
							en Lengua Inglesa</option>
						<option value="Matematicas">Matemáticas</option>
						<option value="Medicina">Medicina</option>
						<option value="Musica">Música</option>
						<option value="Nutricion y Dietetica">Nutrición y
							Dietética</option>
						<option value="Odontologia">Odontología</option>
						<option value="Psicologia">Psicología</option>
					</select>
				</div>
				<div class="col-md-4">
					<label class="form-label">Estrato</label> <select name="estrato"
						class="form-select">
						<option selected value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
					</select>
				</div>
				<div class="col-md-2">
					<label class="form-label">¿Homologado?</label> <select name="homo"
						class="form-select">
						<option selected value="false">No</option>
						<option value="true">Si</option>
					</select>
				</div>
				<div>
					<label for="formFile" class="form-label">Foto</label> <input
						class="form-control" id="formFile" type="file" name="foto"
						accept="image/jpeg, image/png"
						title="Suba una imagen en .jpeg o
            .png" required>
				</div>
				<div class="col-12 pt-lg-3">
					<button type="submit" class="btn btn-primary">Modificar
						Postulado</button>
				</div>
				</div>
			</div>
			
	</form>
	<div class="position-fixed fixed-bottom fixed-right p-3">
		<a class="btn btn-success" href="adm.jsp">Volver</a>
	</div>
</body>
</html>