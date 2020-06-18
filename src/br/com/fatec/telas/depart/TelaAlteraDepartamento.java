package br.com.fatec.telas.depart;


import br.com.fatec.bean.Departamento;
import br.com.fatec.controler.ControleDepartamento;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ProfAlexandre
 */
public class TelaAlteraDepartamento {
    
        public static void main(String[] args) throws SQLException, ClassNotFoundException {
        
        String nomeDepart = JOptionPane.showInputDialog("NOME-DEPART");
        int idDepart = Integer.parseInt(JOptionPane.showInputDialog("ID-DEPART"));

        Departamento depart = new Departamento(idDepart,nomeDepart);
        ControleDepartamento contDepart = new ControleDepartamento();
        depart = contDepart.alteraDepartamento(depart);

        System.out.println(depart.toString());
        
        JOptionPane.showMessageDialog(null, depart.toString());
    }

    
}
