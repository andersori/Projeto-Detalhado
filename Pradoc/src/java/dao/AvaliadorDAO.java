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
            stmt = con.prepareStatement("SELECT * FROM avaliadores");
            rs = stmt.executeQuery();
            avaliadores = new ArrayList<>();
            
            while(rs.next()){
                Avaliador av = new Avaliador();
                
                UsuarioDAO userDao = new UsuarioDAO();
                Usuario user = userDao.selectId(rs.getInt("id_usuario"));
                av.setUsuario(user);
                
                avaliadores.add(av);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvaliadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return avaliadores;
        
    }
}
