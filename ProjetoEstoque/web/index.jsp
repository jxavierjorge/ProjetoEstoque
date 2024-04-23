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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    </head>
    <body>
        <h1>Formulário Login</h1>
        <form method="post" action="AutenticaFuncionario">
            <div class="mb-3">
                <label class="form-label">Usuário: </label>
                <input name="username" class="form-control" type="text"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Senha:</label>
                <input name="senha" class="form-control" type="password"/>
            </div>
            <input value="Logar" class="btn btn-primary" type="submit"/>
        </form>
        <a href="./cadastro.html">Não possuo cadastro</a>    </body>
</html>
