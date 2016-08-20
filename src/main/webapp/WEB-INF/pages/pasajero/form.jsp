<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Crear Pasajeros</h1>
    </jsp:attribute>
	<jsp:body>
		<form:form id="registerForm" modelAttribute="pasajero" method="post"
			action="register">
			<table class="tableEdit">
				<tr>
					<td><form:label path="nombre">Nombre</form:label></td>
					<td><form:input path="nombre" /></td>
				</tr>
				<tr>
					<td><form:label path="direccion">Dirección</form:label></td>
					<td><form:input path="direccion" /></td>
				</tr>
				<tr>
					<td><form:label path="telefono">Teléfono</form:label></td>
					<td><form:input path="telefono" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input class="button" type="submit" value="Crear" /></td>
				</tr>
			</table>
		</form:form>
		<a href="list">Listar pasajeros</a>
    </jsp:body>
</t:genericpage>