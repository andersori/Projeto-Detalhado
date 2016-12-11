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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Formacao;

/**
 *
 * @author Anderson
 */
public class FormacaoDAO {
    
    public void insert(Formacao formacao) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;
        
        try{
            stmt=con.prepareStatement("INSERT INTO formacao(id_usuario,id_area_conhecimento,tipo,instituicao,data_inicio,data_termino) VALUES(?,?,?,?,?,?)");
            stmt.setInt(1, formacao.getIdUsuario());
            stmt.setInt(2,formacao.getIdAreaConhecimento());
            stmt.setString(3, formacao.getTipo());
            stmt.setString(4, formacao.getInstituicao());
           //stmt.setDate(5,formacao.getDataInicio());
           //stmt.setDate(6, formacao.getDataTermino());
           
           stmt.executeUpdate();
        }catch(SQLException ex){
             Logger.getLogger(FormacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            }        
    }
    public void delete(Formacao formacao) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try{
            stmt=con.prepareStatement("DELETE FROM formacao WHERE id_usuario=?");
            stmt.setInt(1, formacao.getIdUsuario());
            stmt.executeUpdate();
            
        }catch(SQLException ex){
             Logger.getLogger(FormacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
             } finally {
            ConnectionFactory.closeConnection(con, stmt);
            }         
    }
   public void update(Formacao formacao) throws SQLException{
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
       
       try{
           stmt=con.prepareStatement("UPDATE formacao SET id_usuario=?,id_area_conhecimento=?,tipo=?,instituicao=?,data_inicio=?,data_termino=? WHERE id_usuario=?");
           stmt.setInt(1, formacao.getIdUsuario());
           stmt.setInt(2, formacao.getIdAreaConhecimento());
           stmt.setString(3, formacao.getTipo());
           stmt.setString(4, formacao.getInstituicao());
           //stmt.setDate(5, formacao.getDataInicio());
           //stmt.setDate(6,formacao.getDataTermino());
           stmt.setInt(7, formacao.getIdUsuario());
           
           stmt.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(Formacao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
   }
   public ArrayList<Formacao> selectAll() throws SQLException{
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
       ResultSet rs=null;
       ArrayList<Formacao> retorno=new ArrayList<>();
       try{
           stmt=con.prepareStatement("SELECT *FROM formacao");
           rs=stmt.executeQuery();
           while(rs.next()){
               Formacao temp=new Formacao();
               temp.setIdUsuario(rs.getInt("id_usuario"));
               temp.setIdAreaConhecimento(rs.getInt("id_area_conhecimento"));
               temp.setTipo(rs.getString("tipo"));
               temp.setInstituicao(rs.getString("instituicao"));
               //temp.setDataInicio(rs.getDate("data_inicio"));
               //temp.setDataTermino(rs.getDate("data_termino"));
               
               retorno.add(temp);
           }
       }catch (SQLException ex) {
            Logger.getLogger(Formacao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
       }
       return retorno;
   }
}
