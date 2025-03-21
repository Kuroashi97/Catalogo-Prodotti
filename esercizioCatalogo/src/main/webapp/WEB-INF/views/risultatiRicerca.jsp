<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Risultati Ricerca</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Risultati Ricerca</h1>
        <table>
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Prezzo</th>
                    <c:if test="${utente.ruolo.nome == 'admin'}">
                        <th>Azioni</th>
                    </c:if>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="prodotto" items="${prodotti}">
                    <tr>
                        <td>${prodotto.nome}</td>
                        <td>${prodotto.prezzo}</td>
                        <c:if test="${utente.ruolo.nome == 'admin'}">
                            <td>
                                <a href="/modificaProdotto/${prodotto.id}" class="button button-modifica">Modifica</a>
                                <a href="/cancellaProdotto/${prodotto.id}" class="button button-cancella">Cancella</a>
                            </td>
                        </c:if>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/ricercaProdotti" class="button">Nuova Ricerca</a>
        <a href="/homeInterna" class="button">Torna Indietro</a>
    </div>
</body>
</html>