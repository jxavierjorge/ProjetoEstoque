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
import model.Produto;
import model.ProdutoDAO;

/**
 *
 * @author jxavi
 */
public class GerenciarProduto extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

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

        Produto p = new Produto();

        try {
            ProdutoDAO pDAO = new ProdutoDAO();
            if (acao.equals("alterar")) {
                p = pDAO.getCarregaPorID(Long.parseLong(id));
                if (p.getId() > 0) {
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_produto.jsp");
                    request.setAttribute("produto", p);
                    disp.forward(request, response);
                } else {
                    mensagem = "Produto não encontrado";
                }
            }
            if(acao.equals("delete")){
                p.setId(Long.parseLong(id));
                if(pDAO.deletar(p)){
                    mensagem="Deletado com sucesso";
                }else{
                    mensagem = "Erro ao excluir produto";
                }
            }
        } catch (Exception e) {
            mensagem = e.toString();
        }

        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "');");
        out.println("location.href='estoque.jsp';");
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
        String nome_produto = request.getParameter("nome_produto");
        String quantidade = request.getParameter("quantidade");
        String preco_unitario = request.getParameter("preco_unitario");

        String mensagem = "";

        Produto p = new Produto();
        try {
            ProdutoDAO pDAO = new ProdutoDAO();

            if (!id.isEmpty()) {
                p.setId(Long.parseLong(id));
            }else{
                p.setId(0L);
            }

            if (nome_produto.equals("") || nome_produto.isEmpty()) {
                mensagem = "Campos obrigatorios deverão ser preenchidos";
            } else {
                p.setName(nome_produto);
                p.setPrice(Double.parseDouble(preco_unitario));
                p.setQuantity(Integer.parseInt(quantidade));
                if (pDAO.gravar(p)) {
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
        out.println("location.href='estoque.jsp';");
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
