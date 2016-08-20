<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Modificar Pasajero</h1>
    </jsp:attribute>
	<jsp:body>
		<form:form id="registerForm" modelAttribute="pasajero" method="post"
			action="update">
			<table class="tableEdit">
				<tr>
					<td><form:label path="id">Id</form:label></td>
					<td><form:input path="id" value="${pasajeroObject.id}" readonly="true"/></td>
				</tr>
				<tr>
					<td><form:label path="nombre">Nombre</form:label></td>
					<td><form:input path="nombre" value="${pasajeroObject.nombre}" /></td>
				</tr>
				<tr>
					<td><form:label path="direccion">Dirección</form:label></td>
					<td><form:input path="direccion" value="${pasajeroObject.direccion}"/></td>
				</tr>
				<tr>
					<td><form:label path="telefono">Teléfono</form:label></td>
					<td><form:input path="telefono" value="${pasajeroObject.telefono}"/></td>
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
