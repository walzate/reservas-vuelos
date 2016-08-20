<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Listar Pasajeros</h1>
    </jsp:attribute>
	<jsp:body>
        <c:if test="${!empty pasajerosList}">
			<table>
				<tr height="40px">

					<th>Nombre</th>
					<th>Dirección</th>
					<th>Teléfono</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
				<c:forEach items="${pasajerosList}" var="pasajero">
					<tr height="30px">

						<td><c:out value="${pasajero.nombre}" /></td>
						<td><c:out value="${pasajero.direccion}" /></td>
						<td><c:out value="${pasajero.telefono}" /></td>
						<td><a href="edit?id=${pasajero.id}">Editar</a></td>
						<td><a href="delete?id=${pasajero.id}">Eliminar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<a href="form">Crear Pasajero</a>
    </jsp:body>
</t:genericpage>