<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Home Interna</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Benvenuto, ${utente.username}!</h1>
        <p>Sei loggato correttamente.</p>
        <c:if test="${not empty messaggio}">
            <p class="messaggio">${messaggio}</p>
        </c:if>
        <a href="/ricercaProdotti" class="button">Ricerca Prodotti</a>
        <c:if test="${utente.ruolo.nome == 'admin'}">
            <a href="/creaProdotto" class="button">Crea Prodotto</a>
        </c:if>
        <a href="/logout" class="button">Logout</a>
    </div>
</body>
</html>