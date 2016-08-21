<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<t:genericpage>
	<jsp:attribute name="header">
      <h1>Filtrar reporte</h1>
    </jsp:attribute>
	<jsp:body>
		<c:choose>
		    <c:when test="${!empty reporteDTOList}">
		        <table>
					<tr height="40px">
	
						<th>Ruta</th>
						<th>Total Vuelos</th>
						<th>Total Pasajeros</th>					
					</tr>
					<c:forEach items="${reporteDTOList}" var="reporte">
						<tr height="30px">
	
							<td><c:out value="${reporte.ruta.nombreAMostrar}" /></td>
							<td><c:out value="${reporte.numeroVuelosRealizados}" /></td>
							<td><c:out value="${reporte.numeroPasajerosTransportados}" /></td>												
						</tr>
					</c:forEach>
				</table>
		    </c:when>    
		    <c:otherwise>
		       <p>No se han encontrado registros para los filtros suministrados.</p>
		    </c:otherwise>
		</c:choose>
    </jsp:body>
</t:genericpage>
