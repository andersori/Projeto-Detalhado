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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Participacao;
import modelo.Usuario;

/**
 *
 * @author Anderson
 */
public class ResponsavelAvaliacaoDAO {
    /*
    +-----------------+---------+------+-----+---------+-------+
    | Field           | Type    | Null | Key | Default | Extra |
    +-----------------+---------+------+-----+---------+-------+
    | id_avaliador    | int(11) | NO   | MUL | NULL    |       |
    | id_participacao | int(11) | NO   | MUL | NULL    |       |
    +-----------------+---------+------+-----+---------+-------+
    */
    
    public void insert(Usuario user, Participacao part){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null ;
        
        try {
            stmt = con.prepareStatement("INSERT INTO responsavel_avaliacao(id_avaliador, id_participacao) VALUES(?,?)");
            stmt.setInt(1, user.getId());
            stmt.setInt(2, part.getId());
            
           
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex); 
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean isResponsavel(Usuario user, Participacao part){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null ;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM responsavel_avaliacao WHERE id_avaliador = ? AND id_participacao = ?");
            stmt.setInt(1, user.getId());
            stmt.setInt(1, part.getId());
            
            rs = stmt.executeQuery();
            if( rs.next()){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArquivoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return false;
    }
    
}
