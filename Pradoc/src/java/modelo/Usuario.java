/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.List;
/**
 *
 * @author Anderson
 */
public abstract class Usuario {
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String username;
    private String senha;
    private String instituicaoDeEnsino;
    private List<String> especializacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if(!ValidacaoString.isNome(nome)){
            //O que deve ser feito?
        }
        
        //Se não encontrou é so setar
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(!ValidacaoString.isTelefone(telefone)){
            //O que deve ser feito?
        }
        
        //Validar a quantidade
        
        //Formatar o numero
        
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(!ValidacaoString.isEmail(email)){
            //O que deve ser feito
        }
        
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if(!ValidacaoString.isCPF(cpf)){
            //O que deve ser feito?
        }
        
        this.cpf = cpf;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(!ValidacaoString.isUsernme(username)){
            //O que deve ser feito?
        }
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        //Verificação de quantidade minima de digitos
        this.senha = senha;
    }

    public String getInstituicaoDeEnsino() {
        return instituicaoDeEnsino;
    }

    public void setInstituicaoDeEnsino(String instituicaoDeEnsino) {
        this.instituicaoDeEnsino = instituicaoDeEnsino;
    }

    public List<String> getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(List<String> especializacao) {
        this.especializacao = especializacao;
    }
    
    //Função padrão de um usuário
    public abstract void criarEvento(Evento evento);
    
    public abstract boolean efetuarLogin(String senha);
}
