/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TestePradoc;
import connection.ConnectionFactory;
import dao.UsuarioDAO;
import java.sql.Connection;
import modelo.Usuario;

/**
 *
 * @author Anderson
 */
public class TesteDeConexao {
    
    public static void main(String[] args){
        ConnectionFactory.getConnection();
        
        /*  Teste de Inserção - TA FUNCIONANDO
        Usuario user = new Usuario();
        user.setCpf("77437022354");
        user.setEmail("user@email.com");
        user.setInstituicaoDeEnsino("Unopar");
        user.setNome("Anderson Soriano de Araújo");
        user.setSenha("1234");
        user.setTelefone("123456789");
        user.setUsername("andersori");
        
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
