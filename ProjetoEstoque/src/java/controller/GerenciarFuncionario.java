/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Usuario;
import model.UsuarioDAO;

/**
 *
 * @author jxavi
 */
public class GerenciarFuncionario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String mensagem = "";

        String acao = request.getParameter("acao");
        String id = request.getParameter("id");

        Usuario u = new Usuario();

        try {
            UsuarioDAO uDAO = new UsuarioDAO();
            if (acao.equals("alterar")) {
                u = uDAO.getCarregaPorID(Long.parseLong(id));
                if (u.getId() > 0) {
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_funcionarios.jsp");
                    request.setAttribute("usuario", u);
                    disp.forward(request, response);
                } else {
                    mensagem = "Produto não encontrado";
                }
            }
            if (acao.equals("delete")) {
                u.setId(Long.parseLong(id));
                if (uDAO.deletar(u)) {
                    mensagem = "Deletado com sucesso";
                } else {
                    mensagem = "Erro ao excluir produto";
                }
            }
        } catch (Exception e) {
            out.print(e);
            mensagem = e.toString();
        }

        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "');");
        out.println("location.href='funcionarios.jsp';");
        out.println("</script>");

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String senha = request.getParameter("senha");
        String cargo = request.getParameter("cargos");

        String mensagem = "";

        Usuario u = new Usuario();
        try {
            UsuarioDAO uDAO = new UsuarioDAO();
            u.setId(0L);

            if (!id.isEmpty()) {
                u.setId(Long.parseLong(id));
            } else {
            }

            if (username.equals("") || username.isEmpty()) {
                mensagem = "Campos obrigatorios deverão ser preenchidos";
            } else {
                u.setUsername(username);
                u.setSenha(senha);
                u.setCargo(Byte.parseByte(cargo));
                if (uDAO.gravar(u)) {
                    mensagem = "Gravado com sucesso";
                } else {
                    mensagem = "Erro ao gravar no banco de dados";

                }
            }

        } catch (Exception e) {
            System.out.println(e);
            //out.print(e);
            mensagem = e.toString();
        }

        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "');");
        out.println("location.href='funcionarios.jsp';");
        out.println("</script>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
