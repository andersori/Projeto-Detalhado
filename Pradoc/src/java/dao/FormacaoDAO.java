/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        }   //stmt.setDate(5,formacao.getDataInicio());
    }
}
