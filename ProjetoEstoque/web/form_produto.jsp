<%-- 
    Document   : form_produto
    Created on : 01/04/2024, 16:27:22
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
        <h1>Adicionar/Atualizar Produto</h1>
        <form method="post" action="GerenciarProduto">
            <input name="id" type="hidden" value="${produto.id}"/>
            <div class="mb-3">
                <label class="form-label">Nome Produto</label>
                <input class="form-control" name="nome_produto" type="text" value="${produto.name}"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Qtd.</label>
                <input class="form-control" name="quantidade" type="number" value="${produto.quantity}"/>
            </div>
            <div class="mb-3">
                <label class="form-label">Preço Unitário</label>
                <input class="form-control" name="preco_unitario" type="number" value="${produto.price}"/>
            </div>
            <input class="btn btn-primary" type="submit" value="Adicionar"/>

        </form>
    </body>
</html>
