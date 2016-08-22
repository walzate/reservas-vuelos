<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Crear Ruta</h1>
    </jsp:attribute>
	<jsp:body>
		<form:form id="registerForm" modelAttribute="ruta" method="post"
			action="register">
			<table class="tableEdit">
				<tr>
					<td><form:label path="aeropuertoOrigen">Aeropuerto Origen *</form:label></td>
					<td><form:input path="aeropuertoOrigen" maxlength="45"  required="required"/></td>
				</tr>
				<tr>
					<td><form:label path="aeropuertoDestino">Aeropuerto Destino *</form:label></td>
					<td><form:input path="aeropuertoDestino" maxlength="45"  required="required"/></td>
				</tr>
				<tr>
					<td><form:label path="duracion">Duración (HH:mm:ss) *</form:label></td>
					<td><form:input path="duracion" maxlength="8"  required="required"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input class="button" type="submit" value="Crear" /></td>
				</tr>
			</table>
		</form:form>
		<a href="list">Listar rutas</a>
    </jsp:body>
</t:genericpage>