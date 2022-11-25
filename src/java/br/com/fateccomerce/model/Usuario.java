/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.fateccomerce.model;

/**
 *
 * @author Gabriel Rodrigues
 */
public class Usuario {
    private Integer idUsuario;
    private String nomeUsuario;
    private String username;
    private Integer tipoUsuario;

    public Usuario(String nomeUsuario, Integer tipoUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(Integer idUsuario, String username, String nomeUsuario, Integer tipoUsuario) {
        this.idUsuario = idUsuario;
        this.nomeUsuario = nomeUsuario;
        this.username = username;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String nomeUsuario, String username, Integer tipoUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.username = username;
        this.tipoUsuario = tipoUsuario;
    }
    
    
    
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public Integer getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(Integer tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String username) {
        this.username = username;
    }
    
}
