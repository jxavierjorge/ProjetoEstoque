/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author jxavi
 */
public class Usuario {

    private Long id;
    private String username;
    private String senha;
    private Byte cargo;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Usuario{" + "username=" + username + ", senha=" + senha + '}';
    }

    public Byte getCargo() {
        return cargo;
    }

    public void setCargo(Byte cargo) {
        this.cargo = cargo;
    }

}
