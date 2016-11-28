/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import modelo.Avaliacao;
import connection.ConnectionFactory;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Competencia;

/**
 *
 * @author Douglas
 */
public class AvaliacaoDAO {
    
    public void insert(Avaliacao av){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt=con.prepareStatement("INSERT INTO avaliacao(conceitos, notaFinal, valorObtido, observacao,id_competencia, id_participacao,id_usuario,) VALUES (?, ?, ?, ?)");
            stmt.setArray(1, (Array) av.getConceitos());
            stmt.setFloat(2, av.getNotaFinal());
            stmt.setFloat(3, av.getValorObitido());
            stmt.setString(4, av.getObservacao());
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    public List<Avaliacao> selectAll(){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        List<Avaliacao> avaliacoes=new ArrayList<>();
        try {
            stmt=con.prepareStatement("SELECT *FROM avaliacao");
            rs=stmt.executeQuery();
            
            while(rs.next()){
                Avaliacao av=new Avaliacao();
                av.setConceitos((List<Competencia>) rs.getArray("conceitos"));
                av.setNotaFinal(rs.getFloat("notaFinal"));
                av.setValorObitido(rs.getFloat("valorObtido"));
                av.setObservacao(rs.getString("observacao"));
                avaliacoes.add(av);               
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con,stmt,rs);
        }
        return avaliacoes;        
    }
    public void update(Avaliacao av){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        try {
            stmt=con.prepareStatement("UPDATE avaliacao SET conceitos=?,notaFinal=?,valorObtido=?,observacao=?");
            stmt.setArray(1, (Array) av.getConceitos());
            stmt.setFloat(2, av.getNotaFinal());
            stmt.setFloat(3, av.getValorObitido());
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
            stmt=con.prepareStatement("DELETE FROM avaliacao WHERE id=?");
            stmt.setInt(1, av.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AvaliacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public Avaliacao select(int id){
        Connection con=ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        Avaliacao av=null;
        try {
            stmt=con.prepareStatement("SELECT *FROM avaliacao WHERE id=?");
            stmt.setInt(1, id);
            rs=stmt.executeQuery();
            
            if(rs.next()){
                av=new Avaliacao();
                av.setConceitos((List<Competencia>) rs.getArray("conceitos"));
                av.setNotaFinal(rs.getFloat("notaFinal"));
                av.setValorObitido(rs.getFloat("valorObtido"));
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
