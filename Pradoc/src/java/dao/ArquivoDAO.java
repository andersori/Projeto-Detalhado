/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.pradoc.iterators.ArquivoList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Arquivo;
import modelo.Evento;
import modelo.Usuario;

/**
 *
 * @author Usuario
 */
public class ArquivoDAO {
    
    public void insert(Arquivo a, Usuario u){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null ;
        
        try {
            stmt = con.prepareStatement("INSERT INTO arquivo(caminho,url,id_usuario) VALUES(?,?,?)");
            stmt.setString(1, a.getCaminho());
            stmt.setString(2, a.getUrl());
            stmt.setInt(3, u.getId());
           
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public void update(Arquivo a){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null ;
        
        try {
            stmt = con.prepareStatement("UPDATE arquivo SET caminho = ?, url = ? WHERE id_arquivo = ?");
            stmt.setString(1, a.getCaminho());
            stmt.setString(2, a.getUrl());
            stmt.setInt(3, a.getId());

            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public ArquivoList selectALL(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArquivoList arquivos = new ArquivoList();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM arquivo");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Arquivo arq = new Arquivo();
                
                arq.setCaminho(rs.getString("caminho"));
                arq.setUrl(rs.getString("url"));
                arq.setId_usuario(rs.getInt("id_usuario"));
                arq.setId(rs.getInt("id"));
                
                arquivos.append(arq);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return arquivos;
    }
    
    public Arquivo selectIdUsuario(Usuario user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null ;
        ResultSet rs = null;
        Arquivo arq = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM arquivo WHERE id_usuario = ?");
            stmt.setInt(1, user.getId());
            
            rs = stmt.executeQuery();
            if( rs.next()){
                arq = new Arquivo();
                
                arq.setCaminho(rs.getString("caminho"));
                arq.setUrl(rs.getString("url"));
                arq.setId_usuario(rs.getInt("id_usuario"));
                arq.setId(rs.getInt("id"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return arq;
    }
    
    public ArquivoList selectAproEvento(Evento even){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArquivoList arquivos = new ArquivoList();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM arquivo AS a, evento AS e , participacao AS p, avaliacao AS av WHERE p.id = e.id_participacao AND p.id_arquivo = a.id AND av.id_participacao = p.id AND e.id = ? AND e.nota_de_aprovacao <= av.valor_obtido");
            stmt.setInt(1, even.getId());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Arquivo arq = new Arquivo();
                arq.setId(rs.getInt("id"));
                arq.setCaminho(rs.getString("caminho"));
                arq.setUrl(rs.getString("url"));
                arq.setId_usuario(rs.getInt("id_usuario"));
                
                arquivos.append(arq);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return arquivos;
        
    }
    
    public ArquivoList selectArqEvento( Evento even){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArquivoList arquivos = new ArquivoList();
        
        try{
            stmt = con.prepareStatement("SELECT * FROM arquivo AS a, evento AS e, participacao AS p WHERE e.id_participacao = p.id AND p.id_arquivo = a.id AND e.id = ?");
            stmt.setInt(1, even.getId());
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Arquivo arq = new Arquivo();
                
                arq.setCaminho(rs.getString("caminho"));
                arq.setUrl(rs.getString("url"));
                arq.setId_usuario(rs.getInt("id_usuario"));
                arq.setId(rs.getInt("id"));
                
                arquivos.append(arq);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return arquivos;
    } 
    
    public void delete(Arquivo a){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null ;
        
        try {
            stmt = con.prepareStatement("DELETE FROM arquivo WHERE id_arquivo = ?");
            stmt.setInt(1, a.getId());
           
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    
}
