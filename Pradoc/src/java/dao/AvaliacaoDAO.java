/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.pradoc.iterators.AvaliacaoList;
import br.com.pradoc.iterators.UsuarioList;
import java.sql.Connection;
import modelo.Avaliacao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Evento;
import modelo.Usuario;

/**
 *
 * @author Douglas
 */
public class AvaliacaoDAO {
    /*
    +-----------------+--------------+------+-----+---------+-------+
    | Field           | Type         | Null | Key | Default | Extra |
    +-----------------+--------------+------+-----+---------+-------+
    | id_competencia  | int(11)      | NO   | MUL | NULL    |       |
    | id_participacao | int(11)      | NO   | MUL | NULL    |       |
    | valor_obtido    | decimal(6,2) | YES  |     | NULL    |       |
    | observacao      | text         | YES  |     | NULL    |       |
    +-----------------+--------------+------+-----+---------+-------+
    */
    
    public void insert(Avaliacao av){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt=con.prepareStatement("INSERT INTO avaliacao(id_competencia, id_participacao, valor_obtido, observacao) VALUES (?, ?, ?, ?)");
            stmt.setInt(1, av.getId_competencia());
            stmt.setInt(2, av.getId_participacao());
            stmt.setDouble(3, av.getValorObitido());
            stmt.setString(4, av.getObservacao());

            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public AvaliacaoList selectAll(){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        AvaliacaoList avaliacoes = new AvaliacaoList();
        
        try {
            stmt=con.prepareStatement("SELECT *FROM avaliacao");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Avaliacao av = new Avaliacao();
                av.setId_competencia(rs.getInt("id_comptencia"));
                av.setId_participacao(rs.getInt("id_participacao"));
                av.setValorObitido(rs.getDouble("valor_obtido"));
                av.setObservacao(rs.getString("observacao"));
                
                avaliacoes.append(av);               
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return avaliacoes;        
    }
    
    
public UsuarioList selectIdEvento(Evento e){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioList avaliadores = null;
        
        try {
            stmt = con.prepareStatement("SELECT DISTINCT * FROM avaliadores AS A, evento AS E WHERE A.id_evento = E.id AND E.id = ?");
            stmt.setInt(1, e.getId());
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
    
    public void update(Avaliacao av){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        try {
            stmt=con.prepareStatement("UPDATE avaliacao SET id_competencia=?,id_participacao=?,valor_obtido=?,observacao=?");
            stmt.setInt(1, av.getId_competencia());
            stmt.setInt(2, av.getId_participacao());
            stmt.setDouble(3, av.getValorObitido());
            stmt.setString(4, av.getObservacao());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    
    public void delete(Avaliacao av){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
         
        try {
            stmt=con.prepareStatement("DELETE FROM avaliacao WHERE id_competencia = ? OR id_participacao = ?");
            stmt.setInt(1, av.getId_competencia());
            stmt.setInt(1, av.getId_participacao());
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public Avaliacao select(int id_competencia, int id_participacao){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Avaliacao av = null;
        try {
            stmt=con.prepareStatement("SELECT * FROM avaliacao WHERE id_competencia = ? OR id_participacao = ? ");
            stmt.setInt(1, id_competencia);
            stmt.setInt(2, id_participacao);
            
            rs=stmt.executeQuery();
            
            if(rs.next()){
                av = new Avaliacao();
                av.setId_competencia(rs.getInt("id_comptencia"));
                av.setId_participacao(rs.getInt("id_participacao"));
                av.setValorObitido(rs.getDouble("valor_obtido"));
                av.setObservacao(rs.getString("observacao"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        
        return av;        
    }
    
}
