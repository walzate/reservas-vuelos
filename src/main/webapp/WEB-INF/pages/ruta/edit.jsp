<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Modificar Ruta</h1>
    </jsp:attribute>
	<jsp:body>
		<form:form id="registerForm" modelAttribute="ruta" method="post"
			action="update">
			<table class="tableEdit">
				<tr>
					<td><form:label path="id">Id</form:label></td>
					<td><form:input path="id" value="${rutaObject.id}"
							readonly="true" /></td>
				</tr>
				<tr>
					<td><form:label path="aeropuertoOrigen">Aeropuerto Origen *</form:label></td>
					<td><form:input path="aeropuertoOrigen"
							value="${rutaObject.aeropuertoOrigen}" maxlength="45"
							required="required" /></td>
				</tr>
				<tr>
					<td><form:label path="aeropuertoDestino">Aeropuerto Destino *</form:label></td>
					<td><form:input path="aeropuertoDestino"
							value="${rutaObject.aeropuertoDestino}" maxlength="45"
							required="required" /></td>
				</tr>
				<tr>
					<td><form:label path="duracion">Duración (HH:mm:ss) *</form:label></td>
					<td><form:input path="duracion" value="${rutaObject.duracion}"
							maxlength="8" required="required" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input class="button" type="submit" value="Modificar" />
					</td>
				</tr>
			</table>
		</form:form>
    </jsp:body>
</t:genericpage>
