<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Crea Prodotto</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Crea Prodotto</h1>
        <form action="/creaProdotto" method="post">
            <input type="text" name="nome" placeholder="Nome prodotto" required>
            <input type="number" name="prezzo" placeholder="Prezzo" step="0.01" required>
            <input type="submit" value="Crea">
        </form>
    </div>
</body>
</html>