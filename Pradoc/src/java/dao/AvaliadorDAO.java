/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.pradoc.iterators.UsuarioList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Evento;
import modelo.Usuario;

/**
 *
 * @author Anderson
 */
public class AvaliadorDAO {
    public void insert(Usuario avaliador, Evento evento){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO avaliador (id_usuario, id_evento) values(?, ?)");
            stmt.setInt(1, avaliador.getId());
            stmt.setInt(2, evento.getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AvaliadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public UsuarioList selectAll(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioList avaliadores = null;
        
        try {
            stmt = con.prepareStatement("SELECT DISTINCT * FROM avaliadores");
            rs = stmt.executeQuery();
            avaliadores = new UsuarioList();
            
            while(rs.next()){
                UsuarioDAO userDao = new UsuarioDAO();
                Usuario user = new Usuario();
                
                user.setId(rs.getInt("id_usuario"));
                user = userDao.selectId(user);
                                
                avaliadores.append(user);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvaliadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return avaliadores;
        
    }
    
    public void update(Usuario av, Evento ev){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("UPDATE avaliador SET id_evento = ? WHERE id_usuario = ? ");
            stmt.setInt(1, ev.getId());
            stmt.setInt(2, av.getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AvaliadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Usuario av){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("DELETE FROM avaliador WHERE id_usuario = ?");
            stmt.setInt(1, av.getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AvaliadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Evento ev){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("DELETE FROM avaliador WHERE id_evento = ?");
            stmt.setInt(1, ev.getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AvaliadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
