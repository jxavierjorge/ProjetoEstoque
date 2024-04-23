<%-- 
    Document   : index.jsp
    Created on : 20/04/2024, 11:11:03
    Author     : jxavi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Formulário Cadastro</h1>
        <form method="POST" action="processaLogin">
            <div class="mb-3">
                <label class="form-label">Usuário: </label>
                <input class="form-control" type="text"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Senha:</label>
                <input class="form-control" type="password"/>
            </div>
            <input class="btn btn-primary" type="submit"/>
        </form>
</html>
