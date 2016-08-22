<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Crear Reserva</h1>
    </jsp:attribute>
	<jsp:body>
		<form:form id="registerForm" modelAttribute="pasajeroPorVuelo" method="post"
			action="register">
			<table class="tableEdit">
				<tr>
					<td><form:label path="pasajero">Pasajero *</form:label></td>
					<td><form:select path="pasajero.id"  required="required">
							<form:option value=""> --SELECT--</form:option>
							<form:options itemLabel="nombre" itemValue="id"
								items="${pasajerosList}"></form:options>
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="vuelo">Vuelo *</form:label></td>
					<td><form:select path="vuelo.id"  required="required">
							<form:option value=""> --SELECT--</form:option>
							<form:options itemLabel="nombreAMostrar" itemValue="id"
								items="${vuelosList}"></form:options>
						</form:select></td>
				</tr>
				<tr>
					<td></td>
					<td><input class="button" type="submit" value="Crear" /></td>
				</tr>
			</table>
		</form:form>
		<a href="list">Listar reservas</a>
    </jsp:body>
</t:genericpage>