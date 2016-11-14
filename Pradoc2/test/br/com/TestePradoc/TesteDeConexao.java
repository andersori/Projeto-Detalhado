/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TestePradoc;
import br.com.ConexaoBanco.*;

/**
 *
 * @author Anderson
 */
public class TesteDeConexao {
    
    public static void main(String[] args){
        System.out.println("Status antes de conectar: " + ConexaoMySQL.statusConection() + ".");
        
        ConexaoMySQL.getConexaoSQL();
        
        System.out.println("Status depois de conectar: " + ConexaoMySQL.statusConection() + ".");
    }
}
