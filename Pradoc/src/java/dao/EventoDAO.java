/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import br.com.pradoc.iterators.CompetenciaList;
import br.com.pradoc.iterators.UsuarioList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Evento;

/**
 *
 * @author Biscoito
 */
public class EventoDAO {

    public void insert(Evento e) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO evento(id_usuario_organizador, id_documento_modelo, nome, nota_aprovacao, descricao, inicio_submicao, fim_submicao, inicio_avaliacao, fim_avaliacao, inicio_recurso, fim_recurso, instituicao) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            
            stmt.setInt(1, e.getOrganizador().getId());
            stmt.setInt(2, e.getModeloDocumento().getId());
            stmt.setString(3, e.getNome());
            stmt.setDouble(4, e.getNotaDeAprovacao());
            stmt.setString(5, e.getDescricao());
            stmt.setDate(6, (Date) e.getInicioSubimicao().getTime());
            stmt.setDate(7, (Date) e.getFimSubmicao().getTime());
            stmt.setDate(8, (Date) e.getInicioAvaliacao().getTime());
            stmt.setDate(9, (Date) e.getFimAvaliacao().getTime());
            stmt.setDate(10, (Date) e.getInicioRecurso().getTime());
            stmt.setDate(11, (Date) e.getFimRecurso().getTime());
            stmt.setString(12, e.getInstituicao());
            
            stmt.executeUpdate();
            //passando id do evento
            e.setId(this.buscarIdEvento(e));
            //cadastrando avaliadores
            UsuarioList ava = e.getAvaliadores();
            AvaliadorDAO avaliadores = new AvaliadorDAO();
            int i=0;
            while(ava.getItem(i)!=null){
                avaliadores.insert(ava.getItem(i),e);
            }
            //cadastrando competencias
            CompetenciaList comp = e.getCompetencias();
            CompetenciaDAO competencias = new CompetenciaDAO();
            i = 0;
            while(comp.getItem(i) != null){
                competencias.insert(comp.getItem(i), e);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con);
        }

    }
    
    public Evento selectId(int id){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Evento e = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM evento WHERE id = ?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            
            while(rs.next()){
                e = new Evento();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setNotaDeAprovacao(rs.getFloat("nota_aprovacao"));
                e.setDescricao(rs.getString("descricao"));
                e.setInstituicao(rs.getString("instituicão"));
                
                Calendar calIS = Calendar.getInstance();
                calIS.setTime(rs.getDate("inicio_submicao"));
                e.setInicioSubimicao(calIS);
                Calendar calFS = Calendar.getInstance();
                calFS.setTime(rs.getDate("fim_submicao"));
                e.setFimSubmicao(calFS);
                Calendar calIA = Calendar.getInstance();
                calIA.setTime(rs.getDate("inicio_avaliacao"));
                e.setInicioAvaliacao(calIA);
                Calendar calFA = Calendar.getInstance();
                calFA.setTime(rs.getDate("fim_avaliacao"));
                e.setFimAvaliacao(calFA);
                Calendar calIR = Calendar.getInstance();
                calIR.setTime(rs.getDate("inicio_recurso"));
                e.setInicioSubimicao(calIR);
                Calendar calFR = Calendar.getInstance();
                calFR.setTime(rs.getDate("fim_recurso"));
                e.setInicioSubimicao(calFR);
                
                AvaliadorDAO avaliadores = new AvaliadorDAO();
                e.setAvaliadores(avaliadores.selectAll());
                
                CompetenciaDAO comp = new CompetenciaDAO();
                e.setCompetencias(comp.selectIdEvento(e));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
        return e;
        
    }
    
    public int buscarIdEvento( Evento ev){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            int id = 0;
            
        try {
            stmt = con.prepareStatement("SELECT id FROM evento WHERE nome = ? AND descricao = ? AND instituicao = ?");
            stmt.setString(1, ev.getNome());
            stmt.setString(2, ev.getDescricao());
            stmt.setString(3, ev.getInstituicao());
            rs = stmt.executeQuery();
            
            id = rs.getInt("id");
         
            
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        return id;   
        
    }
    
    public Evento buscarEvento(String Nome){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            Evento e= null;
            ResultSet rs = null;
            
        try {
            stmt=con.prepareStatement("SELECT * FROM evento WHERE nome LIKE ?");
            stmt.setString(1, Nome);
            rs = stmt.executeQuery();
            
            if(rs.next()){
                e = new Evento();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                e.setNotaDeAprovacao(rs.getFloat("nota_aprovacao"));
                e.setDescricao(rs.getString("descricao"));
                e.setInstituicao(rs.getString("instituicão"));
                
                Calendar calIS = Calendar.getInstance();
                calIS.setTime(rs.getDate("inicio_submicao"));
                e.setInicioSubimicao(calIS);
                Calendar calFS = Calendar.getInstance();
                calFS.setTime(rs.getDate("fim_submicao"));
                e.setFimSubmicao(calFS);
                Calendar calIA = Calendar.getInstance();
                calIA.setTime(rs.getDate("inicio_avaliacao"));
                e.setInicioAvaliacao(calIA);
                Calendar calFA = Calendar.getInstance();
                calFA.setTime(rs.getDate("fim_avaliacao"));
                e.setFimAvaliacao(calFA);
                Calendar calIR = Calendar.getInstance();
                calIR.setTime(rs.getDate("inicio_recurso"));
                e.setInicioSubimicao(calIR);
                Calendar calFR = Calendar.getInstance();
                calFR.setTime(rs.getDate("fim_recurso"));
                e.setInicioSubimicao(calFR);
                
                AvaliadorDAO avaliadores = new AvaliadorDAO();
                e.setAvaliadores(avaliadores.selectAll());
                
                CompetenciaDAO comp = new CompetenciaDAO();
                e.setCompetencias(comp.selectIdEvento(e));
                 
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }     
                
            return e;
        }
        
    public List<Evento> SelectAll(){
            Connection con = ConnectionFactory.getConnection();
            PreparedStatement stmt = null;
            ResultSet rs = null;
            List<Evento> eventos = new ArrayList<>();
            
        try {
            stmt=con.prepareStatement("SELECT * FROM evento GROUP BY id_evento DESC");
            rs = stmt.executeQuery();
            if(rs == null){
                eventos=null;
            }else{
                while (rs.next()){
                    Evento e = new Evento();
                    e.setId(rs.getInt("id"));
                    e.setNome(rs.getString("nome"));
                    e.setNotaDeAprovacao(rs.getFloat("nota_aprovacao"));
                    e.setDescricao(rs.getString("descricao"));
                    e.setInstituicao(rs.getString("instituicão"));
                
                    Calendar calIS = Calendar.getInstance();
                    calIS.setTime(rs.getDate("inicio_submicao"));
                    e.setInicioSubimicao(calIS);
                    Calendar calFS = Calendar.getInstance();
                    calFS.setTime(rs.getDate("fim_submicao"));
                    e.setFimSubmicao(calFS);
                    Calendar calIA = Calendar.getInstance();
                    calIA.setTime(rs.getDate("inicio_avaliacao"));
                    e.setInicioAvaliacao(calIA);
                    Calendar calFA = Calendar.getInstance();
                    calFA.setTime(rs.getDate("fim_avaliacao"));
                    e.setFimAvaliacao(calFA);
                    Calendar calIR = Calendar.getInstance();
                    calIR.setTime(rs.getDate("inicio_recurso"));
                    e.setInicioSubimicao(calIR);
                    Calendar calFR = Calendar.getInstance();
                    calFR.setTime(rs.getDate("fim_recurso"));
                    e.setInicioSubimicao(calFR);
                
                    AvaliadorDAO avaliadores = new AvaliadorDAO();
                    e.setAvaliadores(avaliadores.selectIdEvento(e));
                
                    CompetenciaDAO comp = new CompetenciaDAO();
                    e.setCompetencias(comp.selectIdEvento(e));
                    
                    eventos.add(e);
                }
                
            }           
            
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
                    
            return eventos;
    }
        
    public void delete(Evento e){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM evento WHERE id = ?");
            stmt.setInt(1, e.getId());
           
            stmt.executeUpdate(); 
            
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
        
}
