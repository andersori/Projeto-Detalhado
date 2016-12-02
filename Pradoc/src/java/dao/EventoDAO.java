/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Evento;
import modelo.Organizador;
import modelo.Usuario;

/**
 *
 * @author Biscoito
 */
public class EventoDAO {
    
    public void Insert(Evento e){
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
            Organizador o=e.getOrganizador();
            Usuario u = o.getUsuario();
            stmt.setInt(12, u.getId());
            
            
            
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con);
        }
        
    }
    
}
