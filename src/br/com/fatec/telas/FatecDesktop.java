/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas;

import br.com.fatec.telas.acesso.ValidaLogin;

/**
 *
 * @author ProfAlexandre
 */
public class FatecDesktop {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ValidaLogin().setVisible(true);
    }
    
}
