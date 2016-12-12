/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.dao;

import br.com.pradoc.iterators.CompetenciaList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.pradoc.modelo.Competencia;
import br.com.pradoc.modelo.Evento;

/**
 *
 * @author Anderson
 */
public class CompetenciaDAO {
    /*
    +-----------+--------------+------+-----+---------+-------+
    | Field     | Type         | Null | Key | Default | Extra |
    +-----------+--------------+------+-----+---------+-------+
    | id        | int(11)      | NO   | PRI | NULL    |       |
    | id_evento | int(11)      | NO   | MUL | NULL    |       |
    | titulo    | varchar(45)  | NO   |     | NULL    |       |
    | valor_max | decimal(6,2) | NO   |     | NULL    |       |
    | peso      | int(11)      | YES  |     | NULL    |       |
    | descricao | text         | YES  |     | NULL    |       |
    +-----------+--------------+------+-----+---------+-------+
    */
    
    public void insert(Competencia competencia, Evento evento){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO competecnia (id_evento, titulo, valor_max, peso, descricao) VALUES (?, ?, ?, ?, ?)");
            
            stmt.setInt(1, evento.getId());
            stmt.setString(2, competencia.getTitulo());
            stmt.setDouble(3, competencia.getValorMax());
            stmt.setInt(4, competencia.getPeso());
            stmt.setString(5, competencia.getDescricao());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public CompetenciaList selectALL(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CompetenciaList competencias = new CompetenciaList();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM competencia");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Competencia competencia = new Competencia();
                
                competencia.setId(rs.getInt("id"));
                competencia.setIdEvento(rs.getInt("id_evento"));
                competencia.setDescricao(rs.getString("descicao"));
                competencia.setPeso(rs.getInt("peso"));
                competencia.setValorMax(rs.getDouble("valor_max"));
                competencia.setTitulo(rs.getString("titulo"));
                
                
                competencias.append(competencia);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return competencias;
    }
    
    public CompetenciaList selectIdEvento(Evento evento){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        CompetenciaList competencias = new CompetenciaList();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM competencia WHERE id_evento = ?");
            
            stmt.setInt(1, evento.getId());
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                Competencia competencia = new Competencia();
                
                competencia.setId(rs.getInt("id"));
                competencia.setIdEvento(rs.getInt("id_evento"));
                competencia.setDescricao(rs.getString("descicao"));
                competencia.setPeso(rs.getInt("peso"));
                competencia.setValorMax(rs.getDouble("valor_max"));
                competencia.setTitulo(rs.getString("titulo"));
                
                competencias.append(competencia);
            }
         
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return competencias;
    }
    
    public Competencia selectId(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Competencia competencia = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM competencia WHERE id = ?");
            
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                competencia = new Competencia();
                
                competencia.setId(rs.getInt("id"));
                competencia.setIdEvento(rs.getInt("id_evento"));
                competencia.setDescricao(rs.getString("descicao"));
                competencia.setPeso(rs.getInt("peso"));
                competencia.setValorMax(rs.getDouble("valor_max"));
                competencia.setTitulo(rs.getString("titulo"));
            }
         
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return competencia;
    }
    
    public void update(Competencia competencia, Evento evento){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE competencia SET id_evento = ?, descricao = ?, valor_max = ?, peso = ?, titulo = ? WHERE id = ?");
            
            stmt.setInt(1, evento.getId());
            stmt.setString(2, competencia.getDescricao());
            stmt.setDouble(3, competencia.getValorMax());
            stmt.setInt(4, competencia.getPeso());
            stmt.setString(5, competencia.getTitulo());
            stmt.setInt(1, competencia.getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Competencia competencia){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM competencia WHERE id = ?");
            stmt.setInt(1, competencia.getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
