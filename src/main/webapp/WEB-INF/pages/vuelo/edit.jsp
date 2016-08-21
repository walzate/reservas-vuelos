<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Modificar Vuelo</h1>
    </jsp:attribute>
	<jsp:body>
		<form:form id="registerForm" modelAttribute="vuelo" method="post"
			action="update">
			<table class="tableEdit">
				<tr>
					<td><form:label path="id">Id</form:label></td>
					<td><form:input path="id" value="${vueloObject.id}" readonly="true"/></td>
				</tr>
				<tr>
					<td><form:label path="fecha">Fecha</form:label></td>
					<td><form:input path="fecha" value="${vueloObject.fecha}" /></td>
				</tr>
				<tr>
					<td><form:label path="horaInicio">Hora de inicio</form:label></td>
					<td><form:input path="horaInicio" value="${vueloObject.horaInicio}"/></td>
				</tr>
				<tr>
					<td><form:label path="avion">Avión</form:label></td>
					<td><form:select path="avion.id" itemLabel="nombreAMostrar"
							itemValue="id" items="${avionesList}">
						</form:select>
				</tr>
				<tr>
					<td><form:label path="ruta">Ruta</form:label></td>
					<td><form:select path="ruta.id" itemLabel="nombreAMostrar"
							itemValue="id" items="${rutasList}">
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
