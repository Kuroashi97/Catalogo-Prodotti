<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ricerca Prodotti</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Ricerca Prodotti</h1>
        <form action="/ricercaProdotti" method="post">
            <input type="text" name="nome" placeholder="Nome prodotto">
            <input type="number" name="prezzo" placeholder="Prezzo massimo" step="0.01">
            <input type="submit" value="Cerca">
        </form>
        <a href="/homeInterna" class="button">Torna Indietro</a>
    </div>
</body>
</html>


