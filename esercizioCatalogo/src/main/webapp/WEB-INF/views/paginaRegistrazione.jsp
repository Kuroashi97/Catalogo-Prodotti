<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registrazione</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Registrazione</h1>
        <form action="/registra" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <input type="submit" value="Registrati">
        </form>
        <p class="messaggio">${messaggio}</p>
        <a href="/login" class="button">Login</a>
    </div>
</body>
</html>