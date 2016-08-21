<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script>
  $( function() {
    $( "#fecha" ).datepicker();
  } );
</script>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Crear Vuelo</h1>
    </jsp:attribute>
	<jsp:body>
		<form:form id="registerForm" modelAttribute="vuelo" method="post"
			action="register">
			<table class="tableEdit">
				<tr>
					<td><form:label path="fecha" id="fecha">Fecha (yyyy-MM-dd)</form:label></td>
					<td><form:input path="fecha" /></td>
				</tr>
				<tr>
					<td><form:label path="horaInicio">Hora de inicio (HH:mm:ss)</form:label></td>
					<td><form:input path="horaInicio" /></td>
				</tr>
				<tr>
					<td><form:label path="avion">Avión</form:label></td>
					<td><form:select path="avion.id">
							<form:option value="NONE"> --SELECT--</form:option>
							<form:options itemLabel="nombreAMostrar" itemValue="id"
								items="${avionesList}"></form:options>
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="ruta">Ruta</form:label></td>
					<td><form:select path="ruta.id">
							<form:option value="NONE"> --SELECT--</form:option>
							<form:options itemLabel="nombreAMostrar" itemValue="id"
								items="${rutasList}"></form:options>
						</form:select></td>
				</tr>
				<tr>
					<td></td>
					<td><input class="button" type="submit" value="Crear" /></td>
				</tr>
			</table>
		</form:form>
		<a href="list">Listar vuelos</a>
    </jsp:body>
</t:genericpage>