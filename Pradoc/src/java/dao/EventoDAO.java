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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Evento;
import modelo.Usuario;

/**
 *
 * @author Biscoito
 */
public class EventoDAO {

    public void Insert(Evento e) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO evento(nome_evento,nota_de_aprovacao,descricao_evento,data_inicio_submicao,data_fim_submicao,data_inicio_avaliacao,data_fim_avaliacao,data_inicio_recurso,data_fim_recurso,data_resultado_do_recurso,instituicão,id_usuario_organizador,id_documento_modelo,hora_inicio_submissao,hora_fim_submissao,hora_inicio_avaliacao,hora_fim_avaliacao,hora_inicio_recurso,hora_fim_recurso");
            stmt.setString(1, e.getNome());
            stmt.setFloat(2, e.getNotaAprovacao());
            stmt.setString(3, e.getDescricao());
            stmt.setDate(4, e.getInicioSubmissao());
            stmt.setDate(5, e.getFimSubmissao());
            stmt.setDate(6, e.getInicioAvaliacao());
            stmt.setDate(7, e.getFimAvaliacao());
            stmt.setDate(8, e.getInicioRecurso());
            stmt.setDate(9, e.getFimRecurso());
            stmt.setDate(10, e.getResultadoRecurso());
            stmt.setString(11, e.getInstituicao());
            Organizador o = e.getOrganizador();
            stmt.setInt(12, (o.getId()));

            // stmt do arquivo
            stmt.setTime(14, e.getHoraInicioSubmissao());
            stmt.setTime(15, e.getHoraFimSubmissao());
            stmt.setTime(16, e.getHoraInicioAvaliacao());
            stmt.setTime(17, e.getHoraFimAvaliacao());
            stmt.setTime(18, e.getHoraInicioRecurso());
            stmt.setTime(19, e.getHoraFimRecurso());
            // Ele manda tudo para o Banco
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con);
        }

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
                e=new Evento();
                e.setId(rs.getInt("id_evento"));
                e.setNome(rs.getString("nome_evento"));
                e.setNotaAprovacao(rs.getFloat("nota_de_aprovacao"));
                e.setDescricao(rs.getString("descricao_evento"));
                e.setInicioSubmissao(rs.getDate("data_inicio_submissao"));
                e.setFimSubmissao(rs.getDate("data_fim_submicao"));
                e.setInicioAvaliacao(rs.getDate("data_inicio_avaliacao"));
                e.setFimAvaliacao(rs.getDate("data_fim_avaliacao"));
                e.setInicioRecurso(rs.getDate("data_inicio_recurso"));
                e.setFimRecurso(rs.getDate("data_fim_recurso"));
                e.setResultadoRecurso(rs.getDate("data_resultado_do_recurso"));
                e.setInstituicao(rs.getString("instituicão"));
                // falta a opção que eu passo o ID e ele Cria o Organizador e tbm a do documento.
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            rs=stmt.executeQuery();
            if(rs == null){
                eventos=null;
            }else{
                while (rs.next()){
                    Evento e= new Evento();
                    e.setId(rs.getInt("id_evento"));
                    e.setNome(rs.getString("nome_evento"));
                    e.setNotaAprovacao(rs.getFloat("nota_de_aprovacao"));
                    e.setDescricao(rs.getString("descricao_evento"));
                    e.setInicioSubmissao(rs.getDate("data_inicio_submissao"));
                    e.setFimSubmissao(rs.getDate("data_fim_submicao"));
                    e.setInicioAvaliacao(rs.getDate("data_inicio_avaliacao"));
                    e.setFimAvaliacao(rs.getDate("data_fim_avaliacao"));
                    e.setInicioRecurso(rs.getDate("data_inicio_recurso"));
                    e.setFimRecurso(rs.getDate("data_fim_recurso"));
                    e.setResultadoRecurso(rs.getDate("data_resultado_do_recurso"));
                    e.setInstituicao(rs.getString("instituicão"));
                    eventos.add(e);
                }
                
            }           
            
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
                    
            return eventos;
        }
}
