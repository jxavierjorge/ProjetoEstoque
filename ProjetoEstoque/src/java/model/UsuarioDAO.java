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
public class UsuarioDAO extends DataBaseDAO {

    public UsuarioDAO() throws Exception {

    }

    //Metodo listar funcionários
    public ArrayList<Usuario> getLista() throws Exception {
        ArrayList<Usuario> lista = new ArrayList<>();
        String SQL = "select * from funcionarios";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(SQL);
        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getLong("id"));
            u.setUsername(rs.getString("username"));
            u.setSenha(rs.getString("senha"));
            u.setCargo(rs.getByte("cargo"));
            lista.add(u);
        }
        this.desconectar();
        return lista;
    }

    //Metodo Gravar/Inserir
    public boolean gravar(Usuario u) {
        try {
            String sql;
            this.conectar();
            if (u.getId() == 0) {
                sql = "insert into funcionarios(username, senha, cargo)"
                        + "values (?,?,?)";
            } else {
                sql = "UPDATE funcionarios SET username = ?, senha = ?, cargo = ? WHERE id = ?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, u.getUsername());
            pstm.setString(2, u.getSenha());
            pstm.setByte(3, u.getCargo());
            if (u.getId() > 0) {
                pstm.setLong(4, u.getId());
            }
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    //Método Deletar
    public boolean deletar(Usuario u) {
        try {
            String sql;
            this.conectar();
            sql = "DELETE FROM funcionarios WHERE id=?;";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setLong(1, u.getId());
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Usuario getCarregaPorID(long id) throws Exception {
        Usuario u = new Usuario();
        String sql = "select * from funcionarios where id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setLong(1, id);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            u.setId(rs.getLong("id"));
            u.setUsername(rs.getString("username"));
            u.setSenha(rs.getString("senha"));
            u.setCargo(rs.getByte("cargo"));

        }
        this.desconectar();
        return u;
    }

    public boolean login(String username, String password) throws Exception{
        //Usuario u = new Usuario();
        String sql = "select * from funcionarios where username=? and senha=? and cargo!=0";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, username);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
        return rs.next();
    }
    
}
