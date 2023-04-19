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
        <title>(Admin) Eliminar</title>
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
        <h1 class="d-block p-2 text-bg-warning text-center"> Universidad el
            Bosque</h1>
        <div class="container pt-lg-3">
            <form class="row g-2 pb-lg-3 pt-lg-3" action="http://localhost:8080/SistemaPostulados/ServletAdmin" method="post" id="pr">
                <h2>Eliminacion de postulado</h2>
                <div class="col-6">
                    <label class="form-label">Apellidos</label>
                    <input name="apellidos" type="text" class="form-control"
                        pattern="[a-zA-Z]"
                        title="No se permiten Simbolos ni Numeros" required>
                </div>
                <div class="col-6">
                    <label class="form-label">Fecha de Nacimiento</label>
                    <input type="date" name="fecha" class="form-control"
                        required>
                </div>
                <div class="col">
                    <button type="submit" class="btn btn-danger">Eliminar
                        Postulado</button>
                </div>
            </form>
        </div>
        <div class="position-fixed fixed-bottom fixed-right p-3">
      <a class="btn btn-light" href="index.jsp">Ususario</a>
    </div>
    </body>
</html>