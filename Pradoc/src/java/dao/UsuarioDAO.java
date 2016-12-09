/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import modelo.Usuario;
import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.UsuarioConcreto;

/**
 *
 * @author Anderson
 */
public class UsuarioDAO {
    
    public void insert(Usuario user){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO usuario (username, senha, nome, telefone, email, cpf, instituicao_de_ensino) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getNome());
            stmt.setString(4, user.getTelefone());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getCpf());
            stmt.setString(7, user.getInstituicaoDeEnsino());
            
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<UsuarioConcreto> selectAll(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<UsuarioConcreto> usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                UsuarioConcreto user = new UsuarioConcreto();
                
                user.setCpf(rs.getString("cpf"));
                user.setEmail(rs.getString("email"));
                user.setInstituicaoDeEnsino(rs.getString("instituicao_de_ensino"));
                user.setNome(rs.getString("nome"));
                user.setSenha(rs.getString("senha"));
                user.setTelefone(rs.getString("telefone"));
                user.setUsername(rs.getString("username"));
                user.setId(rs.getInt("id_usuario"));
                
                usuarios.add(user);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return usuarios;
    }
    
    public UsuarioConcreto selectUsername(UsuarioConcreto user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioConcreto userEncontrado = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE username = ?");
            stmt.setString(1, user.getUsername());
            
            rs = stmt.executeQuery();
            if(rs.next()){
                userEncontrado = new UsuarioConcreto();
                
                userEncontrado.setCpf(rs.getString("cpf"));
                userEncontrado.setEmail(rs.getString("email"));
                userEncontrado.setInstituicaoDeEnsino(rs.getString("instituicao_de_ensino"));
                userEncontrado.setNome(rs.getString("nome"));
                userEncontrado.setSenha(rs.getString("senha"));
                userEncontrado.setTelefone(rs.getString("telefone"));
                userEncontrado.setUsername(rs.getString("username"));
                userEncontrado.setId(rs.getInt("id_usuario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return userEncontrado;
        
    }
    public UsuarioConcreto selectId(UsuarioConcreto user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioConcreto userEncontrado = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE id_usuario = ?");
            stmt.setInt(1, user.getId());
            
            rs = stmt.executeQuery();
            if(rs.next()){
                userEncontrado = new UsuarioConcreto();
                
                userEncontrado.setCpf(rs.getString("cpf"));
                userEncontrado.setEmail(rs.getString("email"));
                userEncontrado.setInstituicaoDeEnsino(rs.getString("instituicao_de_ensino"));
                userEncontrado.setNome(rs.getString("nome"));
                userEncontrado.setSenha(rs.getString("senha"));
                userEncontrado.setTelefone(rs.getString("telefone"));
                userEncontrado.setUsername(rs.getString("username"));
                userEncontrado.setId(rs.getInt("id_usuario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return userEncontrado;
        
    }
    public boolean selectUserAndSenha(UsuarioConcreto user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario userEncontrado = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE username = ? AND senha = ?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getSenha());
            
            rs = stmt.executeQuery();
            if(rs.next()){
                userEncontrado = new UsuarioConcreto();
                
                userEncontrado.setCpf(rs.getString("cpf"));
                userEncontrado.setEmail(rs.getString("email"));
                userEncontrado.setInstituicaoDeEnsino(rs.getString("instituicao_de_ensino"));
                userEncontrado.setNome(rs.getString("nome"));
                userEncontrado.setSenha(rs.getString("senha"));
                userEncontrado.setTelefone(rs.getString("telefone"));
                userEncontrado.setUsername(rs.getString("username"));
                userEncontrado.setId(rs.getInt("id_usuario"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return userEncontrado != null;
    }
    
    public void update(UsuarioConcreto user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE usuario SET username = ?, senha = ?, nome = ?, telefone = ?, email = ?, cpf = ?, instituicao_de_ensino = ? WHERE id_usuario = ?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getSenha());
            stmt.setString(3, user.getNome());
            stmt.setString(4, user.getTelefone());
            stmt.setString(5, user.getEmail());
            stmt.setString(6, user.getCpf());
            stmt.setString(7, user.getInstituicaoDeEnsino());
            stmt.setInt(8, user.getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(UsuarioConcreto user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM usuario WHERE id = ?");
            stmt.setInt(1, user.getId());
            
            stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
      
}
