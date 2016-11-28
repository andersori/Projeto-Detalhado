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
import modelo.Competencia;
import modelo.Evento;

/**
 *
 * @author Anderson
 */
public class CompetenciaDAO {
    public void insert(Competencia competencia, Evento evento){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO competecnia (id_evento, descricao, valor_max, peso, titulo) VALUES (?, ?, ?, ?, ?)");
            
            stmt.setInt(1, evento.getId());
            stmt.setString(2, competencia.getDescricao());
            stmt.setDouble(3, competencia.getValorMax());
            stmt.setInt(4, competencia.getPeso());
            stmt.setString(5, competencia.getTitulo());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Competencia> selectALL(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Competencia> competencias = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM competencia");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Competencia competencia = new Competencia();
                
                competencia.setDescricao(rs.getString("descicao"));
                competencia.setPeso(rs.getInt("peso"));
                competencia.setValorMax(rs.getDouble("valor_max"));
                competencia.setTitulo(rs.getString("titulo"));
                competencia.setId(rs.getInt("id_competencia"));
                competencias.add(competencia);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return competencias;
    }
    
    public List<Competencia> selectTitulo(String titulo){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Competencia> competencias = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM competencia WHERE titulo = '%?%'");
            
            stmt.setString(1, titulo);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                Competencia competencia = new Competencia();
                
                competencia.setDescricao(rs.getString("descicao"));
                competencia.setPeso(rs.getInt("peso"));
                competencia.setValorMax(rs.getDouble("valor_max"));
                competencia.setTitulo(rs.getString("titulo"));
                competencia.setId(rs.getInt("id_competencia"));
                competencias.add(competencia);
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
            stmt = con.prepareStatement("SELECT * FROM competencia WHERE id_competencia = '?'");
            
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            if(rs.next()){
                competencia = new Competencia();
                
                competencia.setDescricao(rs.getString("descicao"));
                competencia.setPeso(rs.getInt("peso"));
                competencia.setValorMax(rs.getDouble("valor_max"));
                competencia.setTitulo(rs.getString("titulo"));
                competencia.setId(rs.getInt("id_competencia"));
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
            stmt.setInt(6, competencia.getId());
            
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
            stmt = con.prepareStatement("DELETE FROM competencia WHERE id_comperencia = ?");
            stmt.setInt(1, competencia.getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(CompetenciaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
