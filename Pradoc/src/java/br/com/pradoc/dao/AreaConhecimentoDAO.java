/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.pradoc.modelo.Evento;

/**
 *
 * @author Anderson
 */
public class AreaConhecimentoDAO {
    
    public void insert(String nome, Evento evento){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null ;
        
        try {
            stmt = con.prepareStatement("INSERT INTO area_conhecimento(id_evento, nome) VALUES(?,?)");
            stmt.setInt(1, evento.getId());
            stmt.setString(2, nome);
           
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void update(int id, String novoNome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null ;
        
        try {
            stmt = con.prepareStatement("UPDATE area_conhecimento SET nome = ? WHERE id = ?");
            stmt.setInt(1, id);
            stmt.setString(2, novoNome);
           
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void update(String antigoNome, String novoNome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null ;
        
        try {
            stmt = con.prepareStatement("UPDATE area_conhecimento SET nome = ? WHERE nome = ?");
            stmt.setString(1, antigoNome);
            stmt.setString(2, novoNome);
           
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<String> selectALL(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> areas = new ArrayList<>();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM area_conhecimento");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                String area = rs.getString("nome");
                                
                areas.add(area);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return areas;
    }
    
    public String select(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null ;
        ResultSet rs = null;
        String nomeResultante = null;
        
        try {
            stmt = con.prepareStatement("SELECT nome FROM area_conhecimento WHERE nome = ?");//Não é possivel pesquisar um arquivo de determinado usuario
            stmt.setString(1, nome);
            
            rs = stmt.executeQuery();
            if( rs.next()){
                nomeResultante = new String();
                nomeResultante = rs.getString("nome");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return nomeResultante;
    }
    
    public String select (int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null ;
        ResultSet rs = null;
        String nomeResultante = null;
        
        try {
            stmt = con.prepareStatement("SELECT nome FROM area_conhecimento WHERE nome = ?");//Não é possivel pesquisar um arquivo de determinado usuario
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            if( rs.next()){
                nomeResultante = new String();
                nomeResultante = rs.getString("nome");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return nomeResultante;
    }
    
    public void remove(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null ;
        
        try {
            stmt = con.prepareStatement("DELETE FROM arquivo WHERE id_arquivo = ?");
            stmt.setString(1, nome);
           
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
