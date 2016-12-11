/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anderson
 */
public class UsuarioDAO {
    
    public void insert(Usuario user){
        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO usuario (nome, telefone, email, cpf, instituicao_ensino, username, senha) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getTelefone());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getCpf());
            stmt.setString(5, user.getInstituicaoDeEnsino());
            stmt.setString(6, user.getUsername());
            stmt.setString(7, user.getSenha());
            
            
            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Usuario> selectAll(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Usuario> usuarios = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                Usuario user = new Usuario();
                
                user.setId(rs.getInt("id"));
                user.setNome(rs.getString("nome"));
                user.setTelefone(rs.getString("telefone"));
                user.setEmail(rs.getString("email"));
                user.setCpf(rs.getString("cpf"));
                user.setInstituicaoDeEnsino(rs.getString("instituicao_ensino"));
                user.setUsername(rs.getString("username"));
                user.setSenha(rs.getString("senha"));
                
                usuarios.add(user);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return usuarios;
    }
    
    public Usuario selectUsername(Usuario user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario userEncontrado = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE username = ?");
            stmt.setString(1, user.getUsername());
            
            rs = stmt.executeQuery();
            if(rs.next()){
                userEncontrado = new Usuario();
                
                userEncontrado.setId(rs.getInt("id"));
                userEncontrado.setNome(rs.getString("nome"));
                userEncontrado.setTelefone(rs.getString("telefone"));
                userEncontrado.setEmail(rs.getString("email"));
                userEncontrado.setCpf(rs.getString("cpf"));
                userEncontrado.setInstituicaoDeEnsino(rs.getString("instituicao_ensino"));
                userEncontrado.setUsername(rs.getString("username"));
                userEncontrado.setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return userEncontrado;
        
    }
    public Usuario selectId(Usuario user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuario userEncontrado = null;
        
        try {
            stmt = con.prepareStatement("SELECT * FROM usuario WHERE id = ?");
            stmt.setInt(1, user.getId());
            
            rs = stmt.executeQuery();
            if(rs.next()){
                userEncontrado = new Usuario();
                
                userEncontrado.setId(rs.getInt("id"));
                userEncontrado.setNome(rs.getString("nome"));
                userEncontrado.setTelefone(rs.getString("telefone"));
                userEncontrado.setEmail(rs.getString("email"));
                userEncontrado.setCpf(rs.getString("cpf"));
                userEncontrado.setInstituicaoDeEnsino(rs.getString("instituicao_ensino"));
                userEncontrado.setUsername(rs.getString("username"));
                userEncontrado.setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return userEncontrado;
        
    }
    public boolean selectUserAndSenha(Usuario user){
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
                userEncontrado = new Usuario();
                
                userEncontrado.setId(rs.getInt("id"));
                userEncontrado.setNome(rs.getString("nome"));
                userEncontrado.setTelefone(rs.getString("telefone"));
                userEncontrado.setEmail(rs.getString("email"));
                userEncontrado.setCpf(rs.getString("cpf"));
                userEncontrado.setInstituicaoDeEnsino(rs.getString("instituicao_ensino"));
                userEncontrado.setUsername(rs.getString("username"));
                userEncontrado.setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return userEncontrado != null;
    }
    
    public void update(Usuario user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE usuario SET username = ?, senha = ?, nome = ?, telefone = ?, email = ?, cpf = ?, instituicao_ensino = ? WHERE id_usuario = ?");
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
    
    public void delete(Usuario user){
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
