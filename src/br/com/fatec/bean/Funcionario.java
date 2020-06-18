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
public class Funcionario {
    
    int idFunc;
    String nomeFunc;

    public Funcionario(int idFunc, String nomeFunc) {
        this.idFunc = idFunc;
        this.nomeFunc = nomeFunc;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int idFunc) {
        this.idFunc = idFunc;
    }

    public String getNomeFunc() {
        return nomeFunc;
    }

    public void setNomeFunc(String nomeFunc) {
        this.nomeFunc = nomeFunc;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "idFunc=" + idFunc + ", nomeFunc=" + nomeFunc + '}';
    }
    
}
