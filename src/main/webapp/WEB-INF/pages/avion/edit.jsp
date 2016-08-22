<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Modificar Avión</h1>
    </jsp:attribute>
	<jsp:body>
		<form:form id="registerForm" modelAttribute="avion" method="post"
			action="update">
			<table class="tableEdit">
				<tr>
					<td><form:label path="id">Id</form:label></td>
					<td><form:input path="id" value="${avionObject.id}"
							readonly="true" /></td>
				</tr>
				<tr>
					<td><form:label path="modelo">Modelo</form:label></td>
					<td><form:input path="modelo" value="${avionObject.modelo}"
							maxlength="4" /></td>
				</tr>
				<tr>
					<td><form:label path="capacidad">Capacidad *</form:label></td>
					<td><form:input path="capacidad"
							value="${avionObject.capacidad}" maxlength="3"
							required="required" /></td>
				</tr>
				<tr>
					<td><form:label path="fabricante">Fabricante</form:label></td>
					<td><form:input path="fabricante"
							value="${avionObject.fabricante}" maxlength="45" /></td>
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
