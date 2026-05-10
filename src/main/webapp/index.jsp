<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Календарь событий</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            margin: 0;
            padding: 0;
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .menu-container {
            background: white;
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 20px 40px rgba(0,0,0,0.2);
            width: 350px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 30px;
            font-size: 28px;
        }

        ul {
            list-style: none;
            padding: 0;
            margin: 0;
        }

        li {
            margin: 15px 0;
        }

        a {
            display: block;
            padding: 12px 20px;
            background: #f5f5f5;
            color: #333;
            text-decoration: none;
            border-radius: 8px;
            transition: all 0.3s ease;
            text-align: center;
            font-size: 16px;
        }

        a:hover {
            background: #667eea;
            color: white;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(102,126,234,0.4);
        }
    </style>
</head>
<body>
    <div class="menu-container">
        <h2>Календарь событий</h2>
        <ul>
            <li><a href="show-events">Показать все события</a></li>
            <li><a href="add-appointment">Добавить встречу</a></li>
            <li><a href="add-birthday">Добавить день рождения</a></li>
        </ul>
    </div>
</body>
</html>