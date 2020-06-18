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
public class PessoaFisica extends Pessoa implements Serializable{
    
    private int idPessoa;
    private String cpf;

    public PessoaFisica(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public PessoaFisica(int idPessoa, String nome, String cpf, String tipo, String email) {

        this.idPessoa = idPessoa;
        this.nome = nome;
        this.tipo = tipo;
        this.cpf = cpf;
        this.email = email;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String getTipo() {
        return tipo;
    }

    @Override
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    
}
