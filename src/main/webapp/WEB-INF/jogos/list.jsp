<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <title>jogos</title>
        <link href="/css/bootstrap.min.css" rel="stylesheet" />
    </head>
    <body>
        <div class="container">
            <h1>jogos</h1>
            <a href="/jogos/insert" class="btn btn-primary">Novo Jogo</a>
            <table class="table">
                <tr>
                    <th>id</th>
                    <th>titulo</th>
                    <th>genero</th>
                    <th>autores</th>
                    <th>&nbsp;</th>
                </tr>
                <c:forEach var="l" items="${jogos}">
                    <tr>
                        <td>${l.id}</td>
                        <td>${l.titulo}</td>
                        <td>${l.genero.nome}</td>
                        <td>
                            <c:forEach var="a" items="${l.autores}">
                                ${a.nome}
                            </c:forEach>
                        </td>
                        <td>
                            <a href="/jogos/update/${l.id}" class="btn btn-primary">Editar</a> | 
                            <a href="/jogos/delete/${l.id}" class="btn btn-danger">Remover</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>