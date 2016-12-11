/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import br.com.pradoc.iterators.UsuarioList;
import java.util.List;
/**
 *
 * @author Anderson
 */
public class Usuario {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String username;
    private String senha;
    private String instituicaoDeEnsino;
    private UsuarioList especializacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public boolean setNome(String nome) {
        if(!ValidacaoString.isNome(nome)){
            return false;
        }
        else{
            this.nome = nome;
            return true;
        }
        
    }

    public String getTelefone() {
        return telefone;
    }

    public boolean setTelefone(String telefone) {
        if(!ValidacaoString.isTelefone(telefone)){
            return false;
        }
        else{
            this.telefone = telefone;
            return true;
        }
        
    }

    public String getEmail() {
        return email;
    }

    public boolean setEmail(String email) {
        if(!ValidacaoString.isEmail(email)){
            return false;
        }
        else{
            this.email = email;
            return true;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public boolean setCpf(String cpf) {
        if(!ValidacaoString.isCPF(cpf)){
            return false;
        }
        else{
            this.cpf = cpf;
            return true;
        }
    }

    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {
        if(!ValidacaoString.isUsernme(username)){
            return false;
        }
        else{
            this.username = username;
            return true;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getInstituicaoDeEnsino() {
        return instituicaoDeEnsino;
    }

    public void setInstituicaoDeEnsino(String instituicaoDeEnsino) {
        this.instituicaoDeEnsino = instituicaoDeEnsino;
    }

    public UsuarioList getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(UsuarioList especializacao) {
        this.especializacao = especializacao;
    }
    
    //Função padrão de um usuário
    public void criarEvento(Evento evento){
        //Não sei o que deve ser feito
    }
    
    public boolean efetuarLogin(String senha){
        return getSenha().equals(senha);
    }
}
