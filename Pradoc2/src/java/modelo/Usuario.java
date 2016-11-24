/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
/**
 *
 * @author Anderson
 */
public class Usuario {
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String username;
    private String senha;
    private String caminhoImagem;
    private String instituicaoDeEnsino;
    private ArrayList<String> especializacao;

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

    private String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        //Verificação de quantidade minima de digitos
        this.senha = senha;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        //Retirar acentos
        this.caminhoImagem = caminhoImagem;
    }

    public String getInstituicaoDeEnsino() {
        return instituicaoDeEnsino;
    }

    public void setInstituicaoDeEnsino(String instituicaoDeEnsino) {
        this.instituicaoDeEnsino = instituicaoDeEnsino;
    }

    public ArrayList<String> getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(ArrayList<String> especializacao) {
        this.especializacao = especializacao;
    }

    /**
     * Funções dO USUARIO
     */
    
    public ArrayList<Evento> eventosParticipando(){
        //Requisita a alguma classe do DAO
        return null;
    }
    
    public boolean fazerLogin(String senha){
        return getSenha().equals(senha);
    }
    
    public void criarEvento(Evento evento){
        //Alguma classe da DAO salva isso no banco
        //associando esse usuário com o evento criado
    }
}
