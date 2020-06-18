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

// create table db2020.pl_pessoas_logradouros (
//  pl_id BIGINT NOT NULL AUTO_INCREMENT,
//  pl_pe_id BIGINT,
//  pl_lo_id BIGINT, 
//  pl_obs VARCHAR(255),
//  primary key (pl_id));

public class PessoaLogradouro {
    
    private int id;
    private int idPes;
    private int idLog;
    private String obs;
    private PessoaFisica p;
    private Logradouro l;

    public PessoaLogradouro(int id, int idPes, int idLog, String obs) {
        this.id = id;
        this.idPes = idPes;
        this.idLog = idLog;
        this.obs = obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPes() {
        return idPes;
    }

    public void setIdPes(int idPes) {
        this.idPes = idPes;
    }

    public int getIdLog() {
        return idLog;
    }

    public void setIdLog(int idLog) {
        this.idLog = idLog;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public PessoaFisica getP() {
        return p;
    }

    public void setP(PessoaFisica p) {
        this.p = p;
    }

    public Logradouro getL() {
        return l;
    }

    public void setL(Logradouro l) {
        this.l = l;
    }

    @Override
    public String toString() {
        return "PessoaLogradouro{" + "id=" + id + ", idPes=" + idPes + ", idLog=" + idLog + ", obs=" + obs + ", p=" + p.getNome() + ", l=" + l.getEnd() + '}';
    }
    
    

    
}
