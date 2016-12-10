/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TestePradoc;
import connection.ConnectionFactory;
import dao.UsuarioDAO;
import java.sql.Connection;
import modelo.Avaliador;
import modelo.Usuario;

/**
 *
 * @author Anderson
 */
public class TesteDeConexao {
    
    public static void main(String[] args){
        ConnectionFactory.getConnection();
        
        
        
        
        /*
        Usuario user = new Usuario();
        
        user.setUsername("eduardo");
        user.setSenha("9876");
        
        UsuarioDAO uDao = new UsuarioDAO();
        
        if (uDao.selectUserAndSenha(user)){
            System.out.println("Encontrou");
        }
        else{
            System.out.println("Não encontrou");
        }
        */
        
        
        /*// Teste de Inserção - TA FUNCIONANDO
        Usuario user = new Usuario();
        user.setCpf("0554327543");
        user.setEmail("mouse@email.com");
        user.setInstituicaoDeEnsino("Unifor");
        user.setNome("Carlos Eduardo Araújo Duarte");
        user.setSenha("9876");
        user.setTelefone("86453231");
        user.setUsername("eduardo");
        
        UsuarioDAO userDao = new UsuarioDAO();
        userDao.insert(user);
        */
        
        /*  Teste de Update - TA FUNCIONANDO
        UsuarioDAO userDao = new UsuarioDAO();
        Usuario user = userDao.selectUsername("andersori"); //Buscando as informações do usuario "andersori"
        
        user.setInstituicaoDeEnsino("Univercidade Federal do Ceará");   //Modificando sua instituição de ensino
        
        userDao.update(user);   //Realizando o update
        */
    }
}
