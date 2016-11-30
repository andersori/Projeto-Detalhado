/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Avaliador;
import modelo.Evento;
import modelo.Usuario;

/**
 *
 * @author Anderson
 */
public class AvaliadorDAO {
    public void insert(Avaliador avaliador, Evento evento){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO avaliador (id_usuario, id_evento) values(?, ?)");
            stmt.setInt(1, avaliador.getUsuario().getId());
            stmt.setInt(2, evento.getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AvaliadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Avaliador> selectAll(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Avaliador> avaliadores = null;
        
        try {
            stmt = con.prepareStatement("SELECT DISTINCT * FROM avaliadores");
            rs = stmt.executeQuery();
            avaliadores = new ArrayList<>();
            
            while(rs.next()){
                
                UsuarioDAO userDao = new UsuarioDAO();
                Usuario user = new Usuario();
                user.setId(rs.getInt("id_usuario"));
                user = userDao.selectId(user);
                
                
                Avaliador av = new Avaliador();
                av.setUsuario(user);
                
                //Preencher as participações com o codigo do fernando
                //while(){
                //
                //}
                
                avaliadores.add(av);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvaliadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return avaliadores;
        
    }
    
    public void update(Avaliador av, Evento ev){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("UPDATE avaliador SET id_evento = ? WHERE id_usuario = ? ");
            stmt.setInt(1, ev.getId());
            stmt.setInt(2, av.getUsuario().getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AvaliadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Avaliador av){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("DELETE FROM avaliador WHERE id_usuario = ?");
            stmt.setInt(1, av.getUsuario().getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AvaliadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
