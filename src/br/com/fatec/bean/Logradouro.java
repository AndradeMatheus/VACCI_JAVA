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

// create table db2020.lo_logradouros (
//  lo_id BIGINT NOT NULL AUTO_INCREMENT,
//  lo_cod VARCHAR(10),
//  lo_end VARCHAR(255),
//  primary key (lo_id));


public class Logradouro {
    
    private int id;
    private String cod;
    private String end;

    public Logradouro(int id, String cod, String end) {
        this.id = id;
        this.cod = cod;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Logradouro{" + "id=" + id + ", cod=" + cod + ", end=" + end + '}';
    }

}