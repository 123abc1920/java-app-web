<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head><title>Обновить событие</title></head>
<body>
    <h2>Обновление события</h2>

    <c:if test="${not empty event}">
        <form method="post" action="update-event">
            <input type="hidden" name="oldName" value="${event.name}"/>

            <label>Новое название:</label>
            <input type="text" name="newName" value="${event.name}"/><br/>

            <label>Описание:</label>
            <textarea name="description">${event.description}</textarea><br/>

            <label>Дата:</label>
            <input type="date" name="date"
                   value="<fmt:formatDate value='${event.date}' pattern='yyyy-MM-dd'/>"/><br/>

            <label>Повторяющееся:</label>
            <input type="checkbox" name="repeatable"
                   <c:if test="${event.repeatable}">checked</c:if>/><br/>

            <input type="submit" value="Обновить"/>
        </form>
    </c:if>

    <p><a href="show-events">Назад к списку</a></p>
</body>
</html>