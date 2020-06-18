/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.bean;

/**
 *
 * @author ProfAlexandre
 */
public class Departamento {
    
    int idDepart;
    String nomeDepart;

    public Departamento(int idDepart, String nomeDepart) {
        this.idDepart = idDepart;
        this.nomeDepart = nomeDepart;
    }
    
    public Departamento() {
    }

    public int getIdDepart() {
        return idDepart;
    }
    
    public int  getIdDepart(int teste) {
    	return idDepart + teste;
    }

    public void setIdDepart(int idDepart) {
        this.idDepart = idDepart;
    }

    public String getNomeDepart() {
        return nomeDepart;
    }

    public void setNomeDepart(String nomeDepart) {
        this.nomeDepart = nomeDepart;
    }

    @Override
    public String toString() {
        return "Departamento{" + "idDepart=" + idDepart + ", nomeDepart=" + nomeDepart + '}';
    }
    
}
