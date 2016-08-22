<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Filtrar reporte</h1>
    </jsp:attribute>
	<jsp:body>
		<form:form id="registerForm" modelAttribute="filtro" method="post"
			action="filter">
			<table>
				<tr>
					<td><form:label path="avion">Avion</form:label></td>
					<td><form:select path="avion.id">
							<form:option value="NONE"> --SELECT--</form:option>
							<form:options itemLabel="nombreAMostrar" itemValue="id" items="${avionesList}"></form:options>
						</form:select></td>
				</tr>
				<tr>
					<td><form:label path="fechaInicial">Fecha (yyyy-MM-dd)</form:label></td>
					<td><form:input path="fechaInicial" maxlength="10"/></td>
				</tr>
				<tr>
					<td><form:label path="fechaFinal">Fecha (yyyy-MM-dd)</form:label></td>
					<td><form:input path="fechaFinal" maxlength="10"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input class="button" type="submit" value="Filtrar" /></td>
				</tr>
			</table>
		</form:form>
    </jsp:body>
</t:genericpage>