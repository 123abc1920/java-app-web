<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Добавить День Рождения</title>
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
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            padding: 30px;
        }

        h2 {
            color: #333;
            text-align: center;
            margin-bottom: 30px;
        }

        label {
            display: inline-block;
            width: 120px;
            font-weight: bold;
            margin-top: 10px;
        }

        input[type="date"], textarea {
            width: 250px;
            padding: 8px;
            margin-top: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        textarea {
            width: 250px;
            vertical-align: top;
        }

        button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 20px;
            margin-top: 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        button:hover {
            background-color: #218838;
        }

        a {
            display: inline-block;
            text-decoration: none;
            background-color: #6c757d;
            color: white;
            padding: 10px 20px;
            margin-top: 20px;
            margin-left: 10px;
            border-radius: 4px;
        }

        a:hover {
            background-color: #5a6268;
        }

        .buttons {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Добавление дня рождения</h2>

        <form action="add-birthday" method="POST">
            <label>Дата (гггг-мм-дд):</label>
            <input type="date" name="date" required><br/>

            <label>Имя:</label>
            <input type="text" name="name" required><br/>

            <label>Описание:</label>
            <textarea name="description" rows="3"></textarea><br/>

            <div class="buttons">
                <button type="submit">Добавить</button>
                <a href="index.jsp">Отмена</a>
            </div>
        </form>
    </div>
</body>
</html>