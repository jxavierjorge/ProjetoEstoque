/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jxavi
 */
public class ProdutoDAO extends DataBaseDAO {

    public ProdutoDAO() throws Exception {
    }

    //Método Listar
    public ArrayList<Produto> getLista() throws Exception {
        ArrayList<Produto> lista = new ArrayList<Produto>();
        String SQL = "select * from estoque_produto";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(SQL);
        while (rs.next()) {
            Produto p = new Produto();
            p.setId(rs.getLong("id"));
            p.setName(rs.getString("nome_produto"));
            p.setQuantity(rs.getInt("quantidade"));
            p.setPrice(rs.getFloat("preco_unitario"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }

    //Metodo Gravar
    public boolean gravar(Produto p) {
        try {
            String sql;
            this.conectar();
            if (p.getId() == 0) {
                sql = "insert into estoque_produto(nome_produto, quantidade, preco_unitario)"
                        + "values (?,?,?)";
            } else {
                sql = "UPDATE estoque_produto SET nome_produto = ?, quantidade = ?, preco_unitario = ? WHERE id = ?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, p.getName());
            pstm.setInt(2, p.getQuantity());
            pstm.setDouble(3, p.getPrice());
            if (p.getId() > 0) {
                pstm.setLong(4, p.getId());
            }
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deletar(Produto p) {
        try {
            String sql;
            this.conectar();
            sql = "DELETE FROM estoque_produto WHERE id=?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setLong(1, p.getId());
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Produto getCarregaPorID(long id) throws Exception {
        Produto p = new Produto();
        String sql = "select * from estoque_produto where id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setLong(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            p.setId(rs.getLong("id"));
            p.setName(rs.getString("nome_produto"));
            p.setPrice(rs.getDouble("preco_unitario"));
            p.setQuantity(rs.getInt("quantidade"));

        }
        this.desconectar();
        return p;
    }

}
