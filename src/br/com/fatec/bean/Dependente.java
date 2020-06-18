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
public class Dependente {
    
    private int idDep;
    private String NomeDep;

    public Dependente(int idDep, String NomeDep) {
        this.idDep = idDep;
        this.NomeDep = NomeDep;
    }

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public String getNomeDep() {
        return NomeDep;
    }

    public void setNomeDep(String NomeDep) {
        this.NomeDep = NomeDep;
    }

    @Override
    public String toString() {
        return "Dependente{" + "idDep=" + idDep + ", NomeDep=" + NomeDep + '}';
    }
    
    
    
    
}
