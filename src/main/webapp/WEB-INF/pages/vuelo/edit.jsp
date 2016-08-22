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
					<td><form:label path="fecha">Fecha (yyyy-MM-dd) *</form:label></td>
					<td><form:input path="fecha" value="${vueloObject.fecha}" maxlength="10"  required="required"/></td>
				</tr>
				<tr>
					<td><form:label path="horaInicio">Hora de inicio (HH:mm:ss) *</form:label></td>
					<td><form:input path="horaInicio" value="${vueloObject.horaInicio}" maxlength="8"  required="required"/></td>
				</tr>
				<tr>
					<td><form:label path="avion">Avión *</form:label></td>
					<td><form:select path="avion.id"  required="required">
							<c:forEach items="${avionesList}" var="avion">
						        <c:choose>
						            <c:when test="${avion.id eq vueloObject.avion.id}">
						                <option value="${avion.id}" selected>${avion.nombreAMostrar}</option>
						            </c:when>
						            <c:otherwise>
						                <option value="${avion.id}">${avion.nombreAMostrar}</option>
						            </c:otherwise>
						        </c:choose> 
						    </c:forEach>
						</form:select>
				</tr>
				<tr>
					<td><form:label path="ruta">Ruta *</form:label></td>
					<td><form:select path="ruta.id"  required="required">
							<c:forEach items="${rutasList}" var="ruta">
						        <c:choose>
						            <c:when test="${ruta.id eq vueloObject.ruta.id}">
						                <option value="${ruta.id}" selected>${ruta.nombreAMostrar}</option>
						            </c:when>
						            <c:otherwise>
						                <option value="${ruta.id}">${ruta.nombreAMostrar}</option>
						            </c:otherwise>
						        </c:choose> 
						    </c:forEach>
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
