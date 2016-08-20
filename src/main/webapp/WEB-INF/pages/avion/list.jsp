<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Listar Aviones</h1>
    </jsp:attribute>
	<jsp:body>
        <c:if test="${!empty avionesList}">
			<table>
				<tr height="40px">

					<th>Modelo</th>
					<th>Capacidad</th>
					<th>Fabricante</th>
					<th>Editar</th>
					<th>Eliminar</th>
				</tr>
				<c:forEach items="${avionesList}" var="avion">
					<tr height="30px">

						<td><c:out value="${avion.modelo}" /></td>
						<td><c:out value="${avion.capacidad}" /></td>
						<td><c:out value="${avion.fabricante}" /></td>
						<td><a href="edit?id=${avion.id}">Editar</a></td>
						<td><a href="delete?id=${avion.id}">Eliminar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		<a href="form">Crear Avión</a>
    </jsp:body>
</t:genericpage>