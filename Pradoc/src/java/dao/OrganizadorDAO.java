/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Evento;
import modelo.Organizador;
import modelo.Usuario;

/**
 *
 * @author Douglas
 */
public class OrganizadorDAO {
    
    /*public List<Organizador> selectAll(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs=null;
        List<Organizador> organizadores=new ArrayList<>();
        try {
            stmt=con.prepareStatement("SELECT id_usuario_organizador FROM evento ");
            rs=stmt.executeQuery();
            while(rs.next()){
                Organizador org=new Organizador();
                org.setUsuario((Usuario) rs.getObject("usuario"));
                org.setEventos((List<Evento>) rs.getArray("eventos"));
                organizadores.add(org);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrganizadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return organizadores;
    }*/
   
}
