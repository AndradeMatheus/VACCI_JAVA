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
public class FuncionarioDependente {
    
    private int idFunDep;
    private int idFun;
    private int idDep;
    private String obs;
    private Funcionario fun;
    private Dependente dep;

    public FuncionarioDependente(int idFunDep, int idFun, int idDep, String obs) {
        this.idFunDep = idFunDep;
        this.idFun = idFun;
        this.idDep = idDep;
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

    public int getIdDep() {
        return idDep;
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
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

    public Dependente getDep() {
        return dep;
    }

    public void setDep(Dependente dep) {
        this.dep = dep;
    }

    @Override
    public String toString() {
        return "FuncionarioDependente{" + "idFunDep=" + idFunDep + ", idFun=" + idFun + ", idDep=" + idDep + ", obs=" + obs + ", fun=" + fun.getNomeFunc() + ", dep=" + dep.getNomeDep() + '}';
    }
    
    
    
    
    
}
