<%@tag description="Overall Page template" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true"%>
<%@attribute name="footer" fragment="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title>Reservas de Vuelos</title>
<link href="<c:url value="/resources/css/main.css" />" rel="stylesheet">
</head>
<body>
	<div id="pageheader">
		<jsp:invoke fragment="header" />
	</div>
	<ul>
		<li><a title="Crear Pasajeros" href="/reservas-vuelos/pasajero/form">Crear
				Pasajeros</a></li>
		<li><a title="Crear Rutas" href="/reservas-vuelos/ruta/form">Crear Rutas</a></li>
		<li><a title="Crear Aviones" href="/reservas-vuelos/avion/form">Crear Aviones</a></li>
		<li><a title="Crear Vuelo" href="/reservas-vuelos/vuelo/form">Crear Vuelo</a></li>
		<li><a title="Reservas de Vuelos" href="/reservas-vuelos/pasajeroPorVuelo/form">Reservas de Vuelos</a></li>
		<li><a title="Reporte" href="/reservas-vuelos/reporte/form">Reporte</a></li>
	</ul>
	<div id="body">
		<jsp:doBody />
	</div>
	<div id="pagefooter">
		<p id="copyright">Copyright 2016, Wilson Alzate Calderón</p>
	</div>
</body>
</html>