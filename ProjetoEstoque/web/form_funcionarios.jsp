<%-- 
    Document   : form_funcionarios
    Created on : 20/04/2024, 14:33:26
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
        
        <%
        
            String username = (String) session.getAttribute("u");
            if(username==null){
                response.sendRedirect("./index.jsp");
            }
        
        %>
        
        <h1>Adicionar/Atualizar Funcionário</h1>
        <form method="post" action="GerenciarFuncionario">
            <input name="id" type="hidden" value="${usuario.id}"/>
            <div class="mb-3">
                <label class="form-label">Nome:</label>
                <input class="form-control " name="username" type="text" value="${usuario.username}"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Senha:</label>
                <input class="form-control" name="senha" type="password" value="${usuario.senha}"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Cargo:</label>
                <select class="form-select" name="cargos">
                    <option value="0">Inativo</option>
                    <option value="1">Administrador</option>
                    <option selected value="2">Básico</option>
                </select>
            </div>
            <input class="btn btn-primary" type="submit" value="Adicionar"/>

        </form>
    </body>
</html>
