<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head><title>Добавить Встречу</title></head>
<body>
    <h2>=== Добавление встречи ===</h2>
    <form action="add-appointment" method="POST">
        Дата (dd-MM-yyyy): <input type="text" name="date"><br><br>
        Название: <input type="text" name="name"><br><br>
        Описание: <textarea name="description"></textarea><br><br>
        Повторяется:
        <select name="isRepeat">
            <option value="true">Да</option>
            <option value="false">Нет</option>
        </select><br><br>
        <button type="submit">Добавить</button>
    </form>
    <a href="index.jsp">Отмена</a>
</body>
</html>
