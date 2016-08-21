<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Modificar Reserva</h1>
    </jsp:attribute>
	<jsp:body>
		<form:form id="registerForm" modelAttribute="pasajeroPorVuelo" method="post"
			action="update">
			<table class="tableEdit">
				<tr>
					<td><form:label path="id">Id</form:label></td>
					<td><form:input path="id" value="${pasajeroPorVueloObject.id}" readonly="true"/></td>
				</tr>
				<tr>
					<td><form:label path="pasajero">Pasajero</form:label></td>
					<td><form:select path="pasajero.id" itemLabel="nombre"
							itemValue="id" items="${pasajerosList}">
						</form:select>
				</tr>
				<tr>
					<td><form:label path="vuelo">Vuelo</form:label></td>
					<td><form:select path="vuelo.id" itemLabel="nombreAMostrar"
							itemValue="id" items="${vuelosList}">
						</form:select>
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
