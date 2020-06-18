/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.bean;

import java.io.Serializable;

/**
 *
 * @author ProfAlexandre
 */
public class UsuarioPessoa implements Serializable {
    
    private int idUsuPes;
    private int idUsuario;
    private int idPessoa;        
    private String Obs;
    private Usuario usu;
    private PessoaFisica pes;

    public UsuarioPessoa(int idUsuPes, int idPessoa, int idUsuario, String Obs) {
        this.idUsuPes = idUsuPes;
        this.idUsuario = idUsuario;
        this.idPessoa = idPessoa;
        this.Obs = Obs;
    }

    public int getIdUsuPes() {
        return idUsuPes;
    }

    public void setIdUsuPes(int idUsuPes) {
        this.idUsuPes = idUsuPes;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getObs() {
        return Obs;
    }

    public void setObs(String Obs) {
        this.Obs = Obs;
    }

    public Usuario getUsu() {
        return usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    public Pessoa getPes() {
        return pes;
    }

    public void setPes(PessoaFisica pes) {
        this.pes = pes;
    }
    
    
    
    
    
}
