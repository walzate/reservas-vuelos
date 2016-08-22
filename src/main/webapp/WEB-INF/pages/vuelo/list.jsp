<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Listar Vuelos</h1>
    </jsp:attribute>
	<jsp:body>
        <c:if test="${!empty vuelosList}">
			<table>
				<tr height="40px">

					<th>Fecha</th>
					<th>Hora de inicio</th>
					<th>Hora estimada de finalización</th>
					<th>Avión</th>
					<th>Ruta</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
				<c:forEach items="${vuelosList}" var="vuelo">
					<tr height="30px">

						<td><c:out value="${vuelo.fecha}" /></td>
						<td><c:out value="${vuelo.horaInicio}" /></td>
						<td><fmt:formatDate pattern="HH:mm:ss" value="${vuelo.horaEstimadaFinalizacion}" /></td>
						<td><c:out value="${vuelo.avion.nombreAMostrar}" /></td>
						<td><c:out value="${vuelo.ruta.nombreAMostrar}" /></td>
						<td><a href="edit?id=${vuelo.id}">Editar</a></td>
						<td><a href="delete?id=${vuelo.id}">Eliminar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<a href="form">Crear Vuelo</a>
    </jsp:body>
</t:genericpage>