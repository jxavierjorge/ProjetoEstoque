<%-- 
    Document   : estoque
    Created on : 01/04/2024, 15:57:16
    Author     : jxavi
--%>

<%@page import="model.ProdutoDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Produto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estoque</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script type="text/javascript">
            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente excluir o perfil ' + nome + ' ?')) {
                    location.href = 'GerenciarProduto?acao=delete&id=' + id;
                }
            }
        </script>
    </head>
    <body>
        <h1>Lista Estoque</h1>
        <a class="btn btn-primary" href="form_produto.jsp">Novo Cadastro</a>
        <table class="table table-success table-striped-columns table-hover">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome_Produto</th>
                    <th>Qtd.</th>
                    <th>Preço Unitário</th>
                    <th colspan="2">Opções</th>
                </tr>
            </thead>
            <%

                ArrayList<Produto> lista = new ArrayList<Produto>();
                try {
                    ProdutoDAO pDAO = new ProdutoDAO();
                    lista = pDAO.getLista();
                } catch (Exception e) {
                    out.print(e);
                }
                for (Produto p : lista) {

            %>
            <tr>
                <td><%= p.getId()%></td>
                <td><%= p.getName()%></td>
                <td><%= p.getQuantity()%></td>
                <td><%= p.getPrice()%></td>
                <td><a href="GerenciarProduto?acao=alterar&id=<%= p.getId()%>"><button class="btn btn-primary">Alterar</button></a></td>
                <td><button class="btn btn-danger" onclick="confirmarExclusao(<%= p.getId()%>, '<%= p.getName()%>')">Excluir</button></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
