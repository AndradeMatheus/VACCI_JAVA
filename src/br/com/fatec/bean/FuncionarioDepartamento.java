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
public class FuncionarioDepartamento {
    
    private int idFunDep;
    private int idFun;
    private int idDepart;
    private String obs;
    private Funcionario fun;
    private Departamento depart;

    public FuncionarioDepartamento(int idFunDep, int idFun, int idDepart, String obs) {
        this.idFunDep = idFunDep;
        this.idFun = idFun;
        this.idDepart = idDepart;
        this.obs = obs;
    }

    public int getIdFunDep() {
        return idFunDep;
    }

    public void setIdFunDep(int idFunDep) {
        this.idFunDep = idFunDep;
    }

    public int getIdFun() {
        return idFun;
    }

    public void setIdFun(int idFun) {
        this.idFun = idFun;
    }

    public int getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(int idDepart) {
        this.idDepart = idDepart;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public Funcionario getFun() {
        return fun;
    }

    public void setFun(Funcionario fun) {
        this.fun = fun;
    }

    public Departamento getDepart() {
        return depart;
    }

    public void setDepart(Departamento depart) {
        this.depart = depart;
    }

    @Override
    public String toString() {
        return "FuncionarioDepartamento{" + "idFunDep=" + idFunDep + ", idFun=" + idFun + ", idDepart=" + idDepart + ", obs=" + obs + ", fun=" + fun.getNomeFunc() + ", depart=" + depart.getNomeDepart() + '}';
    }



}
