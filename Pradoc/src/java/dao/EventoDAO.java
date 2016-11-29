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

/**
 *
 * @author Biscoito
 */
public class EventoDAO {
    
    public void Insert(Evento e){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO evento(nome_evento,nota_de_aprovacao,descricao_evento, inicio_submicao, fim_submicao,inicio_avaliacao, fim_avaliacao, inicio_recurso, fim_recurso, resultado_do_recurso, instituicão, id_usuario_organizador, id_documento_modelo )");
            stmt.setString(1, e.getNome());
            stmt.setFloat(2, e.getNotaAprovacao());
            stmt.setString(3, e.getDescricao());
            
            
            
            
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con);
        }
        
    }
    
}
