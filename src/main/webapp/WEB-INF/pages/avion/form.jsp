<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Crear Avión</h1>
    </jsp:attribute>
	<jsp:body>
		<form:form id="registerForm" modelAttribute="avion" method="post"
			action="register">
			<table class="tableEdit">
				<tr>
					<td><form:label path="modelo">Modelo</form:label></td>
					<td><form:input path="modelo" maxlength="4" /></td>
				</tr>
				<tr>
					<td><form:label path="capacidad">Capacidad *</form:label></td>
					<td><form:input path="capacidad" maxlength="3"
							required="required" /></td>
				</tr>
				<tr>
					<td><form:label path="fabricante">Fabricante</form:label></td>
					<td><form:input path="fabricante" maxlength="45" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input class="button" type="submit" value="Crear" /></td>
				</tr>
			</table>
		</form:form>
		<a href="list">Listar aviones</a>
    </jsp:body>
</t:genericpage>