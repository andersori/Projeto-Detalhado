/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Participacao;

/**
 *
 * @author Anderson
 */
public class EmailParticipacaoDAO {
    /*
    +-----------------+-------------+------+-----+---------+-------+
    | Field           | Type        | Null | Key | Default | Extra |
    +-----------------+-------------+------+-----+---------+-------+
    | id_participacao | int(11)     | NO   | MUL | NULL    |       |
    | email           | varchar(45) | YES  |     | NULL    |       |
    +-----------------+-------------+------+-----+---------+-------+
    */
    
    public void insert(String email, Participacao part){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO email_participacao (id_participacao, email) VALUES (?, ?)");
            
            stmt.setInt(1, part.getId());
            stmt.setString(2, email);
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<String> selectALL(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> emails = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT email FROM email_participacao");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                String email = rs.getString("email");
                                
                emails.add(email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return emails;
    }
    
    public List<String> selectALL(Participacao part){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<String> emails = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT email FROM email_participacao WHERE id_participacao = ?");
            stmt.setInt(1, part.getId());
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                String email = rs.getString("email");
                                
                emails.add(email);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return emails;
    }
    
    public void update(String antigoEmail, String novoEmail, Participacao part){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE email_participacao SET email = ? WHERE id_participacao = ? AND email = ?");
            
            stmt.setString(1, novoEmail);
            stmt.setInt(2, part.getId());
            stmt.setString(1, antigoEmail);
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void remove(String email, Participacao part){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM email_participacao WHERE id_participacao = ? AND email = ?");
            
            stmt.setInt(1, part.getId());
            stmt.setString(2, email);
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
