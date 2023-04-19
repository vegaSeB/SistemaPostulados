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
<title>(Admin) Sistema Postulados</title>
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
	background-color: rgba(127, 97, 2, 0.5);
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
.btn-block {
  width: 100%;
}

</style>

</head>
<body class="ini">
    <h1 class="d-block p-2 text-bg-warning text-center"> Universidad el Bosque</h1>
    <div class="container pt-lg-3">
        <div class="container min-vh-100 py-5">
          <div class="alert alert-info" role="alert">
            Operaciones de Adminitracion
          </div>
          <div class="row flex-column d-flex align-items-center justify-content-center">
            <div class="col-12 col-md-6 mb-3">
              <a class="btn btn-primary btn-lg btn-block" href="mod.jsp">Modificar Postulado</a>
            </div>
            <div class="col-12 col-md-6 mb-3">
              <a class="btn btn-danger btn-lg btn-block" href="eli.jsp">Eliminar Postulado</a>
            </div>
            <div class="col-12 col-md-6 mb-3">
              <a class="btn btn-success btn-lg btn-block" href="bus.jsp">Buscar Postulado</a>
            </div>
            <div class="col-12 col-md-6 mb-3">
            <form action="http://localhost:8080/SistemaPostulados/ServletAdmin"
			method="get">
              <button class="btn btn-secondary btn-lg btn-block" type="submit">Lista de todos los postulados</button>
              </form>
            </div>
          </div>
        </div>
      </div>
    <div class="position-fixed fixed-bottom fixed-right p-3">
      <a class="btn btn-light" href="index.jsp">Ususario</a>
    </div>
  </body>
</html>