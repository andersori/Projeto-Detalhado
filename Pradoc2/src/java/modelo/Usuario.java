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
        //Não pode ter números
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        //Validar a quantidade e formatar o numero
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        //Validar o email
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        //Validar CPF
        this.cpf = cpf;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        //Retirar acentos e espaços
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
