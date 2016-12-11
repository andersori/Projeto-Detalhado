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
import modelo.Evento;
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
        stmt.setInt(1, participacao.getEvento().getId());
        stmt.setInt(2,participacao.getArquivo().getId());
        stmt.setDouble(3,participacao.getResultadoFinal());
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
                
                retorno.setId(rs.getInt("id"));
                retorno.setResultadoFinal(rs.getDouble("resultado_final"));
                retorno.setRevisar(rs.getBoolean("revisar"));
                retorno.setStatus(rs.getString("status"));
                retorno.setValido(rs.getBoolean("valido"));    
                
                //FALTA PEGAR O OBJETO EVENTO (ESPERANDO A CLASSE EVENTODAO)
                
                
                ArquivoDAO arquivoDao=new ArquivoDAO();//PEGANDO O ARQUIVO PELO SEU ID
                retorno.setArquivo(arquivoDao.selectArquivoID(rs.getInt("id_arquivo")));
                
                stmt3=con.prepareStatement("SELECT *FROM avaliacao WHERE id_participacao=?");//PEGANDO TODAS AS AVALIACOES
                stmt3.setInt(1,rs.getInt("id"));
                rsAv=stmt3.executeQuery();
                AvaliacaoList avaliacao=new AvaliacaoList();
                while(rsAv.next()){
                    avaliacao.append(new Avaliacao(rsAv.getInt("id_participacao"),rsAv.getInt("id_competencia"),rsAv.getDouble("valor_obtido"),rsAv.getString("observacao")));
                }
                retorno.setAvaliacoes(avaliacao); 
                
                EmailParticipacaoDAO buscarEmails=new EmailParticipacaoDAO();//PEGANDO OS EMAILS DA PARTICIPAÇAO
                retorno.setEmailsUsuarios(buscarEmails.selectALL(retorno));
                
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
    public Participacao selectId(int id) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        PreparedStatement stmt2 =null;
        ResultSet rs=null;
        ResultSet rsAv=null;
        Participacao participacao=null;
        
        try{
            stmt=con.prepareStatement("SELECT *FROM participacao WHERE id=?");
            stmt.setInt(1, id);
            rs=stmt.executeQuery();
            if(rs.next()){
                participacao=new Participacao();
                participacao.setId(rs.getInt("id"));
                participacao.setRevisar(rs.getBoolean("revisar"));
                participacao.setValido(rs.getBoolean("valido"));
                participacao.setStatus(rs.getString("status"));
                participacao.setResultadoFinal(rs.getDouble("resultado_final"));
                
                ArquivoDAO arquivoDao=new ArquivoDAO();//PEGANDO O ARQUIVO PELO SEU ID
                participacao.setArquivo(arquivoDao.selectArquivoID(rs.getInt("id_arquivo")));
                
                stmt2=con.prepareStatement("SELECT *FROM avaliacao WHERE id_participacao=?");//PEGANDO TODAS AS AVALIACOES
                stmt2.setInt(1,id);
                rsAv=stmt2.executeQuery();
                AvaliacaoList avaliacao=new AvaliacaoList();
                while(rsAv.next()){
                    avaliacao.append(new Avaliacao(rsAv.getInt("id_participacao"),rsAv.getInt("id_competencia"),rsAv.getDouble("valor_obtido"),rsAv.getString("observacao")));
                }
                participacao.setAvaliacoes(avaliacao);
                
                //falta pegar o evento
                
                EmailParticipacaoDAO buscarEmails=new EmailParticipacaoDAO();//PEGANDO OS EMAILS DA PARTICIPAÇAO
                participacao.setEmailsUsuarios(buscarEmails.selectALL(participacao));
                
            }
        }catch (SQLException ex) {
            Logger.getLogger(ParticipacaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
            ConnectionFactory.closeConnection(con,stmt2,rsAv);
            
        }
        return participacao;
    }
    
    public void update(Participacao participacao) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try{
            stmt=con.prepareStatement("UPDATE participacao SET id_evento=?,id_arquivo=?,resultado_final=?,status=?,valido=?,revisar=? WHERE id=?");
            stmt.setInt(1, participacao.getEvento().getId());
            stmt.setInt(2, participacao.getArquivo().getId());
            stmt.setDouble(3, participacao.getResultadoFinal());
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
        
    
    
    

