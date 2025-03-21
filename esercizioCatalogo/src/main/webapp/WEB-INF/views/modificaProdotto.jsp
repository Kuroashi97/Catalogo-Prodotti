<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Modifica Prodotto</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Modifica Prodotto</h1>
        <form action="/modificaProdotto/${prodotto.id}" method="post">
            Nome: <input type="text" name="nome" value="${prodotto.nome}" required><br>
            Prezzo: <input type="number" name="prezzo" value="${prodotto.prezzo}" step="0.01" required><br>
            <input type="submit" value="Modifica">
        </form>
        <a href="/ricercaProdotti" class="button">Torna alla Ricerca</a>
    </div>
</body>
</html>