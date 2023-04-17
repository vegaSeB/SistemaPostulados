<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
	crossorigin="anonymous"></script>
<style type="text/css">
@import url('https://fonts.googleapis.com/css?family=Raleway');

@import url(https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css);

body::before {
	content: '';
	background-color: rgba(0, 128, 0, 0.5);
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
<title>Sistema Postulados</title>


</head>
<body class="ini">
	<h1 class="d-block p-2 text-bg-success text-center">Universidad el
		Bosque</h1>
	<div class="container pt-lg-3">
		<form class="row g-3 pb-lg-3 pt-lg-3" action="/ServletUser" method="get" id="pr" >
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
					type="date" name="fecha" class="form-control" required>
			</div>
			<div class="col-12">
				<label class="form-label">Colegio en el que se graduo</label> <input
					type="text" name="colegio" class="form-control" pattern="[A-Za-z ]+" title="No se permiten Simbolos ni Numeros"  required>
			</div>
			<div class="col-md-6">
				<label class="form-label">Carrera deseada</label> <select
					name="carrera" class="form-select">
					<option value selected=“AdministracióndeEmpresas”>Administración
						de Empresas</option>
					<option value=“Antropología”>Antropología</option>
					<option value=“Arquitectura”>Arquitectura</option>
					<option value=“ArtesEscénicas”>Artes Escénicas</option>
					<option value=“Biología”>Biología</option>
					<option value=“CienciaPolítica”>Ciencia Política</option>
					<option value=“ComunicaciónSocialyPeriodismo”>Comunicación
						Social y Periodismo</option>
					<option value=“ContaduríaPública”>Contaduría Pública</option>
					<option value=“Derecho”>Derecho</option>
					<option value=“DiseñoGráfico”>Diseño Gráfico</option>
					<option value=“Economía”>Economía</option>
					<option value=“Enfermería”>Enfermería</option>
					<option value=“Filosofía”>Filosofía</option>
					<option value=“Fisioterapia”>Fisioterapia</option>
					<option value=“Fonoaudiología”>Fonoaudiología</option>
					<option value=“IngenieríaAmbiental”>Ingeniería Ambiental</option>
					<option value=“IngenieríaBiomédica”>Ingeniería Biomédica</option>
					<option value=“IngenieríaCivil”>Ingeniería Civil</option>
					<option value=“IngenieríadeSistemas”>Ingeniería de
						Sistemas</option>
					<option value=“IngenieríaIndustrial”>Ingeniería Industrial</option>
					<option value=“LicenciaturaenEducaciónInfantil”>Licenciatura
						en Educación Infantil</option>
					<option value=“LicenciaturaenLenguaInglesa”>Licenciatura
						en Lengua Inglesa</option>
					<option value=“Matemáticas”>Matemáticas</option>
					<option value=“Medicina”>Medicina</option>
					<option value=“Música”>Música</option>
					<option value=“NutriciónyDietética”>Nutrición y Dietética</option>
					<option value=“Odontología”>Odontología</option>
					<option value=“Psicología”>Psicología</option>
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
					title="Suba una imagen en .jpeg o .png" required>
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">Ingresar
					interesado</button>
			</div>
		</form>
		<div class="position-fixed fixed-bottom fixed-right p-3">
			<a class="btn btn-warning" href="adm.jsp">Administrar</a>
		</div>
	</div>
</body>
</html>