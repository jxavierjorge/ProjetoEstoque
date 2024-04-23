<%-- 
    Document   : funcionarios
    Created on : 20/04/2024, 11:10:27
    Author     : jxavi
--%>

<%@page import="model.UsuarioDAO"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <script type="text/javascript">
            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente excluir o perfil ' + nome + ' ?')) {
                    location.href = 'GerenciarFuncionario?acao=delete&id=' + id;
                }
            }
        </script>
    </head>
    <body>

        <%

            String username = (String) session.getAttribute("u");
            if (username == null) {
                response.sendRedirect("./index.jsp");
            } else {
                out.println("Bem vindo, " + username);
            }

        %>

        <a class="btn btn-link" href="AutenticaFuncionario?acao=logoff">Sair</a>

        <h1>Funcionários</h1>
        <h1>Lista Funcionários</h1>
        <a class="btn btn-primary" href="form_funcionarios.jsp">Novo Cadastro</a>
        <table class="table table-success table-striped-columns table-hover">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Funcionário</th>
                    <th>Cargo</th>
                    <th colspan="2">Opções</th>
                </tr>
            </thead>
            <%  ArrayList<Usuario> lista = new ArrayList<Usuario>();
                String estado = "";

                try {
                    UsuarioDAO pDAO = new UsuarioDAO();
                    lista = pDAO.getLista();
                } catch (Exception e) {
                    out.print(e);
                }
                for (Usuario u : lista) {

                    if (u.getCargo() == 0) {
                        estado = "text-muted";
                    } else {
                        estado = "text-primary";
                    }

            %>
            <tr>
                <td class=<%= estado%>><%= u.getId()%></td>
                <td class=<%= estado%> ><%= u.getUsername()%></td>
                <td class=<%= estado%>>
                    <% switch (u.getCargo()) {
                            case 0:
                                out.println("Inativo");
                                break;
                            case 1:
                                out.println("Administrador");
                                break;
                            case 2:
                                out.println("Básico");
                                break;
                        }%>
                </td>
                <td><a href="GerenciarFuncionario?acao=alterar&id=<%= u.getId()%>"><button class="btn btn-primary">Alterar</button></a></td>
                <td><button class="btn btn-danger" onclick="confirmarExclusao(<%= u.getId()%>, '<%= u.getUsername()%>')">Excluir</button></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>
