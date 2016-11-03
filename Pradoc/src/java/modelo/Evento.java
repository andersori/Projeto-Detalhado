/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Anderson
 */
public class Evento {
    private int codigo;
    private String nome;
    private ArrayList<String> areaConhecimento;
    private Calendar inicioSubmicao;
    private Calendar fimSubmicao;
    private Calendar inicioAvaliacao;
    private Calendar fimAvaliacao;
    private Calendar inicioRecurso;
    private Calendar fimRecurso;
    private String instituicao;
    private Organizador organizador;
    private ArrayList<Avaliador> avaliadores;
    private ArrayList<Participacao> participacoes;
    private Documento modeloDocumento; 

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<String> getAreaConhecimento() {
        return areaConhecimento;
    }

    public void setAreaConhecimento(ArrayList<String> areaConhecimento) {
        this.areaConhecimento = areaConhecimento;
    }

    public Calendar getInicioSubmicao() {
        return inicioSubmicao;
    }

    public void setInicioSubmicao(Calendar inicioSubmicao) {
        this.inicioSubmicao = inicioSubmicao;
    }

    public Calendar getFimSubmicao() {
        return fimSubmicao;
    }

    public void setFimSubmicao(Calendar fimSubmicao) {
        this.fimSubmicao = fimSubmicao;
    }

    public Calendar getInicioRecurso() {
        return inicioRecurso;
    }

    public void setInicioRecurso(Calendar inicioRecurso) {
        this.inicioRecurso = inicioRecurso;
    }

    public Calendar getFimRecurso() {
        return fimRecurso;
    }

    public void setFimRecurso(Calendar fimRecurso) {
        this.fimRecurso = fimRecurso;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public Organizador getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public ArrayList<Avaliador> getAvaliadores() {
        return avaliadores;
    }
    

    public Calendar getInicioAvaliacao() {
        return inicioAvaliacao;
    }

    public void setInicioAvaliacao(Calendar inicioAvaliacao) {
        this.inicioAvaliacao = inicioAvaliacao;
    }

    public Calendar getFimAvaliacao() {
        return fimAvaliacao;
    }

    public void setFimAvaliacao(Calendar fimAvaliacao) {
        this.fimAvaliacao = fimAvaliacao;
    }

    public void setAvaliadores(ArrayList<Avaliador> avaliadores) {
        this.avaliadores = avaliadores;
    }

    public ArrayList<Participacao> getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(ArrayList<Participacao> participacoes) {
        this.participacoes = participacoes;
    }

    public Documento getModeloDocumento() {
        return modeloDocumento;
    }

    public void setModeloDocumento(Documento modeloDocumento) {
        this.modeloDocumento = modeloDocumento;
    }

    
}
