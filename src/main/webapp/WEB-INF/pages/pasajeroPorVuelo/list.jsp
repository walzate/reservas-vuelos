<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Listar Reservas</h1>
    </jsp:attribute>
	<jsp:body>
        <c:if test="${!empty pasajeroPorVueloList}">
			<table>
				<tr height="40px">

					<th>Pasajero</th>
					<th>Vuelo</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
				<c:forEach items="${pasajeroPorVueloList}" var="pasajeroPorVuelo">
					<tr height="30px">

						<td><c:out value="${pasajeroPorVuelo.pasajero.nombre}" /></td>
						<td><c:out value="${pasajeroPorVuelo.vuelo.nombreAMostrar}" /></td>
						<td><a href="edit?id=${pasajeroPorVuelo.id}">Editar</a></td>
						<td><a href="delete?id=${pasajeroPorVuelo.id}">Eliminar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<a href="form">Crear Reserva</a>
    </jsp:body>
</t:genericpage>