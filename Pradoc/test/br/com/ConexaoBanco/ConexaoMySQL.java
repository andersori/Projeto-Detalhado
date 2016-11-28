/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ConexaoBanco;

//Classes necessárias para a conexão com o banco
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
        
/**
 *
 * @author Anderson
 */
public class ConexaoMySQL {
    public static String status = "Não conectado";
    
    public ConexaoMySQL(){
        
    }
    
    public static java.sql.Connection getConexaoSQL(){
        Connection connection = null;
        
        try{
            String driveName = "com.mysql.jdbc.Driver";
            
            //Serve para inicializar a classe "com.mysql.jdbc.Driver".
            Class.forName(driveName);
            
            //Configurando a conexão com o banco de dados
            String serverName = "localhost";
            String mysqlDataBase = "mysql";
            String url = "jdbc:mysql://" + serverName + "/" + mysqlDataBase;
            String username = "root";        //nome de um usuário de seu BD      
            String password = "1234";      //sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);
            
            //Testa sua conexão//  
 
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            
            return connection;
 
        } catch (ClassNotFoundException e) {  //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
 
        } catch (SQLException e) {
            //Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }
    
    
    //Método que retorna o status da sua conexão//
    public static String statusConection() {
        return status;
    }
 
   
    //Método que fecha sua conexão//
    public static boolean FecharConexao() {
        try {
            ConexaoMySQL.getConexaoSQL().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
        
    }
 
   
 
   //Método que reinicia sua conexão//
 
    public static java.sql.Connection ReiniciarConexao() {
        FecharConexao();
        return ConexaoMySQL.getConexaoSQL();
    }
}
