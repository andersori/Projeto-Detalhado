/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.dao;

import br.com.pradoc.iterators.FormacaoList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.pradoc.modelo.Formacao;

/**
 *
 * @author Anderson
 */
public class FormacaoDAO {
    
    public void insert(Formacao formacao){
        
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;
        
        try{
            stmt=con.prepareStatement("INSERT INTO formacao(id_usuario,id_area_conhecimento,tipo,instituicao,data_inicio,data_termino) VALUES(?,?,?,?,?,?)");
            stmt.setInt(1, formacao.getIdUsuario());
            stmt.setInt(2,formacao.getIdAreaConhecimento());
            stmt.setString(3, formacao.getTipo());
            stmt.setString(4, formacao.getInstituicao());
            stmt.setDate(5,(Date) formacao.getDataInicio().getTime());//PEGUEI ESSA LÓGICA PELO EDUARDO
            stmt.setDate(6, (Date) formacao.getDataTermino().getTime());
           
           stmt.executeUpdate();
        }catch(SQLException ex){
             Logger.getLogger(FormacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
            }        
    }
    public void delete(Formacao formacao){
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
   public void update(Formacao formacao){
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
       
       try{
           stmt=con.prepareStatement("UPDATE formacao SET id_usuario=?,id_area_conhecimento=?,tipo=?,instituicao=?,data_inicio=?,data_termino=? WHERE id_usuario=?");
           stmt.setInt(1, formacao.getIdUsuario());
           stmt.setInt(2, formacao.getIdAreaConhecimento());
           stmt.setString(3, formacao.getTipo());
           stmt.setString(4, formacao.getInstituicao());
           stmt.setDate(5, (Date) formacao.getDataInicio().getTime());
           stmt.setDate(6,(Date) formacao.getDataTermino().getTime());
           stmt.setInt(7, formacao.getIdUsuario());
           
           stmt.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(Formacao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
   }
   public FormacaoList selectAll(){
       Connection con = ConnectionFactory.getConnection();
       PreparedStatement stmt = null;
       ResultSet rs=null;
       
       FormacaoList retorno = new FormacaoList();
       try{
           stmt=con.prepareStatement("SELECT *FROM formacao");
           rs=stmt.executeQuery();
           while(rs.next()){
               Formacao temp=new Formacao();
               temp.setIdUsuario(rs.getInt("id_usuario"));
               temp.setIdAreaConhecimento(rs.getInt("id_area_conhecimento"));
               temp.setTipo(rs.getString("tipo"));
               temp.setInstituicao(rs.getString("instituicao"));
               
               Calendar c = Calendar.getInstance();//NAO SEI SE VAI FUNCIONAR NAO
               c.setTime(rs.getDate("data_inicio"));
               temp.setDataInicio(c);
               
               Calendar c1=Calendar.getInstance();
               c.setTime(rs.getDate("data_termino"));
               temp.setDataTermino(c1);
               
               retorno.append(temp);
           }
       }catch (SQLException ex) {
            Logger.getLogger(Formacao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
       }
       return retorno;
   }
}
