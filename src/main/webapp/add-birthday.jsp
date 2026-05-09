<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Добавить День Рождения</title></head>
<body>
    <h2>=== Добавление дня рождения ===</h2>
    <form action="add-birthday" method="POST">
        Дата (dd.MM.yyyy): <input type="text" name="date" placeholder="01.01.2000"><br><br>
        Имя: <input type="text" name="name"><br><br>
        Описание: <textarea name="description"></textarea><br><br>
        <button type="submit">Добавить</button>
    </form>
    <a href="index.jsp">Отмена</a>
</body>
</html>
