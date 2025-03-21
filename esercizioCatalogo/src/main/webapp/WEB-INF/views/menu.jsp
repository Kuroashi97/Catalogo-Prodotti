<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="menu">
    <!-- Link per la ricerca prodotti (accessibile a tutti gli utenti loggati) -->
    <a href="/ricercaProdotti" class="button">Ricerca Prodotti</a>

    <!-- Link per creare un prodotto (accessibile solo agli utenti con ruolo "administrator") -->
    <c:if test="${utente.ruolo.nome == 'administrator'}">
        <a href="/creaProdotto" class="button">Crea Prodotto</a>
    </c:if>

    <!-- Link per il logout (accessibile a tutti gli utenti loggati) -->
    <a href="/logout" class="button">Logout</a>
</div>