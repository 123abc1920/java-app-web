<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Обновить событие</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 500px;
            margin: 0 auto;
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        }
        h2 {
            color: #333;
            text-align: center;
        }
        label {
            display: inline-block;
            width: 120px;
            font-weight: bold;
            margin-top: 10px;
        }
        input[type="text"], textarea, input[type="date"] {
            width: 250px;
            padding: 5px;
            margin-top: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        textarea {
            vertical-align: top;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            margin-top: 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .back-link {
            display: inline-block;
            margin-top: 20px;
            text-decoration: none;
            color: #007bff;
        }
        .back-link:hover {
            text-decoration: underline;
        }
        hr {
            margin: 20px 0;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Обновление события</h2>

        <c:if test="${not empty event}">
            <form method="post" action="update-event">
                <input type="hidden" name="oldName" value="${event.name}"/>

                <label>Новое название:</label>
                <input type="text" name="newName" value="${event.name}"/><br/>

                <label>Описание:</label>
                <textarea name="description" rows="3">${event.description}</textarea><br/>

                <label>Дата:</label>
                <input type="date" name="date"
                       value="<fmt:formatDate value='${event.date}' pattern='yyyy-MM-dd'/>"/><br/>

                <label>Повторяющееся:</label>
                <input type="checkbox" name="repeatable"
                       <c:if test="${event.repeatable}">checked</c:if>/>
                <span style="font-size: 14px; color: #666;">(отметьте, если событие повторяется)</span><br/>

                <div style="text-align: center;">
                    <input type="submit" value="Сохранить"/>
                </div>
            </form>
        </c:if>

        <hr/>
        <a href="show-events" class="back-link">← Назад к списку</a>
    </div>
</body>
</html>