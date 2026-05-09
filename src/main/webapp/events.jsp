<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head><title>Все события</title></head>
<body>
    <h2>Список событий</h2>
    <table border="1">
        <tr>
            <th>ID</th><th>Имя</th><th>Описание</th><th>Дата</th><th>Повтор</th><th>Действия</th>
        </tr>
        <c:forEach var="event" items="${events}">
            <tr>
                <td>${event.id}</td>
                <td>${event.name}</td>
                <td>${event.description}</td>
                <td><fmt:formatDate value="${event.date}" pattern="dd.MM.yyyy"/></td>
                <td>${event.repeatable ? 'Да' : 'Нет'}</td>
                <td>
                    <a href="update-event?name=${event.name}">Редактировать</a> |
                    <a href="delete-event?name=${event.name}" onclick="return confirm('Удалить?')">Удалить</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <p><a href="index.jsp">Назад в меню</a></p>
</body>
</html>
