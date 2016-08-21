<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Listar Rutas</h1>
    </jsp:attribute>
	<jsp:body>
        <c:if test="${!empty rutasList}">
			<table>
				<tr height="40px">

					<th>Aeropuerto Origen</th>
					<th>Aeropuerto Destino</th>
					<th>Duración</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
				<c:forEach items="${rutasList}" var="ruta">
					<tr height="30px">

						<td><c:out value="${ruta.aeropuertoOrigen}" /></td>
						<td><c:out value="${ruta.aeropuertoDestino}" /></td>
						<td><c:out value="${ruta.duracion}" /></td>
						<td><a href="edit?id=${ruta.id}">Editar</a></td>
						<td><a href="delete?id=${ruta.id}">Eliminar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<a href="form">Crear Ruta</a>
    </jsp:body>
</t:genericpage>