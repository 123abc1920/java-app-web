<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Все события</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            padding: 20px;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 20px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        th {
            background-color: #667eea;
            color: white;
            padding: 12px;
            text-align: left;
        }

        td {
            padding: 10px;
            border-bottom: 1px solid #ddd;
        }

        tr:hover {
            background-color: #f9f9f9;
        }

        .actions a {
            text-decoration: none;
            padding: 5px 10px;
            border-radius: 4px;
            margin: 0 2px;
        }

        .actions a:first-child {
            background-color: #007bff;
            color: white;
        }

        .actions a:first-child:hover {
            background-color: #0056b3;
        }

        .actions a:last-child {
            background-color: #dc3545;
            color: white;
        }

        .actions a:last-child:hover {
            background-color: #c82333;
        }

        .back-link {
            display: inline-block;
            text-decoration: none;
            background-color: #6c757d;
            color: white;
            padding: 10px 20px;
            border-radius: 4px;
        }

        .back-link:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Список событий</h2>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Имя</th>
                    <th>Описание</th>
                    <th>Дата</th>
                    <th>Повтор</th>
                    <th>Действия</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="event" items="${events}">
                    <tr>
                        <td>${event.id}</td>
                        <td>${event.name}</td>
                        <td>${event.description}</td>
                        <td><fmt:formatDate value="${event.date}" pattern="dd.MM.yyyy"/></td>
                        <td>${event.repeatable ? 'Да' : 'Нет'}</td>
                        <td class="actions">
                            <a href="update-event?name=${event.name}">Редактировать</a>
                            <a href="delete-event?name=${event.name}" onclick="return confirm('Удалить?')">Удалить</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <a href="index.jsp" class="back-link">Назад в меню</a>
    </div>
</body>
</html>