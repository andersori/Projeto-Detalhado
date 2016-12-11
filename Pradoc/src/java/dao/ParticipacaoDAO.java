/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.pradoc.iterators.AvaliacaoList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Avaliacao;
import modelo.Participacao;

/**
 *
 * @author Anderson
 */
public class ParticipacaoDAO {
    
    public void insert(Participacao participacao) throws SQLException{
        Connection con= ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        try{
        stmt=con.prepareStatement("INSERT INTO participacao(id_evento,id_arquivo,resultado_final,status,valido,) VALUES(?,?,?,?,?,?)");
        stmt.setInt(1, participacao.getIdEvento());
        stmt.setInt(2,participacao.getIdArquivo());
        stmt.setFloat(3,participacao.getResultadoFinal());
        stmt.setString(4, participacao.getStatus());
        stmt.setBoolean(5, participacao.isValido());
        stmt.setBoolean(6, participacao.isRevisar());
        
        stmt.executeUpdate();
        }catch (SQLException ex) {
            Logger.getLogger(ParticipacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    } 
    public List<Participacao> selectAll() throws SQLException{
        ResultSet rs=null;
        ResultSet rsEmails=null;
        ResultSet rsAv=null;
        List<Participacao> participacoes = new ArrayList<>();
        Connection con= ConnectionFactory.getConnection();
        PreparedStatement stmt=null;
        PreparedStatement stmt2=null;
        PreparedStatement stmt3=null;
        
        try{
            stmt=con.prepareStatement("SELECT *FROM participacao");
            rs=stmt.executeQuery();
            while(rs.next()){
                Participacao retorno= new Participacao();
                
                retorno.setIdEvento(rs.getInt("id_evento"));
                retorno.setIdArquivo(rs.getInt("id_arquivo"));
                retorno.setId(rs.getInt("id"));
                retorno.setResultadoFinal(rs.getFloat("resultado_final"));
                retorno.setRevisar(rs.getBoolean("revisar"));
                retorno.setStatus(rs.getString("status"));
                retorno.setValido(rs.getBoolean("valido"));                
                
                stmt2=con.prepareStatement("SELECT FROM email_participacao WHERE id_participacao=?");
                stmt2.setInt(1,rs.getInt("id"));
                rsEmails=stmt2.executeQuery();
                ArrayList<String> emails=new ArrayList<>();
                while(rsEmails.next()){
                    emails.add(rsEmails.getString("email"));
                    }
                retorno.setEmailsUsuarios(emails);
                
                stmt3=con.prepareStatement("SELECT FROM avalicao WHERE id_participacao=?");
                stmt3.setInt(1,rs.getInt("id"));
                rsAv=stmt3.executeQuery();
                AvaliacaoList avaliacao=new AvaliacaoList();
                while(rsAv.next()){
                    avaliacao.append(new Avaliacao(rsAv.getInt("id_participacao"),rsAv.getInt("id_competencia"),rsAv.getDouble("valor_obtido"),rsAv.getString("observacao")));
                }
                retorno.setAvaliacoes(avaliacao);             
                
                participacoes.add(retorno);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParticipacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
            ConnectionFactory.closeConnection(con,stmt2,rsEmails);
            ConnectionFactory.closeConnection(con,stmt3,rsAv);
            
        }
        return participacoes;
            
    }
    
    public void update(Participacao participacao) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt=con.prepareStatement("UPDATE participacao SET id_evento=?,id_arquivo=?,resultado_final=?,status=?,valido=?,revisar=? WHERE id=?");
            stmt.setInt(1, participacao.getIdEvento());
            stmt.setInt(2, participacao.getIdArquivo());
            stmt.setFloat(3, participacao.getResultadoFinal());
            stmt.setString(4,participacao.getStatus());
            stmt.setBoolean(5, participacao.isValido());
            stmt.setBoolean(6,participacao.isRevisar());
            stmt.setInt(7, participacao.getId());

            stmt.executeUpdate();
        }catch(SQLException ex){
            Logger.getLogger(Participacao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Participacao participacao) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt2=null;
        PreparedStatement stmt3=null;
        
        try{
            stmt=con.prepareStatement("DELETE FROM participacao WHERE id=?");
            stmt.setInt(1, participacao.getId());            
            stmt.executeUpdate();
            
            stmt2=con.prepareStatement("DELETE FROM email_participacao WHERE id_participacao=?");
            stmt2.setInt(1, participacao.getId());
            stmt2.executeUpdate();
            
            stmt3=con.prepareStatement("DELETE FROM avaliacao WHERE id_participacao=?");
            stmt3.setInt(1, participacao.getId());
            stmt3.executeUpdate();            
            
            
        }catch(SQLException ex){
             Logger.getLogger(ParticipacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
             } finally {
            ConnectionFactory.closeConnection(con, stmt);
            ConnectionFactory.closeConnection(con, stmt2);
            ConnectionFactory.closeConnection(con, stmt3);
        }
    }
}
        
    
    
    

