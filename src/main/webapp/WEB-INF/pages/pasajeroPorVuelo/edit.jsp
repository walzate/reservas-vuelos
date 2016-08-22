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
					<td><form:label path="pasajero">Pasajero *</form:label></td>
					<td><form:select path="pasajero.id" required="required">
							<c:forEach items="${pasajerosList}" var="pasajero">
						        <c:choose>
						            <c:when test="${pasajero.id eq pasajeroPorVueloObject.pasajero.id}">
						                <option value="${pasajero.id}" selected>${pasajero.nombre}</option>
						            </c:when>
						            <c:otherwise>
						                <option value="${pasajero.id}">${pasajero.nombre}</option>
						            </c:otherwise>
						        </c:choose> 
						    </c:forEach>
						</form:select>
					</td>
				</tr>
				<tr>
					<td><form:label path="vuelo">Vuelo *</form:label></td>
					<td><form:select path="vuelo.id" required="required">
							<c:forEach items="${vuelosList}" var="vuelo">
						        <c:choose>
						            <c:when test="${vuelo.id eq pasajeroPorVueloObject.vuelo.id}">
						                <option value="${vuelo.id}" selected>${vuelo.nombreAMostrar}</option>
						            </c:when>
						            <c:otherwise>
						                <option value="${vuelo.id}">${vuelo.nombreAMostrar}</option>
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
