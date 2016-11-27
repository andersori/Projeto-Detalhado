/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Calendar;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class Evento {
    private int codigo;
    private String nome;
    private List<String> areaConhecimento;
    private Calendar inicioSubmicao;
    private Calendar fimSubmicao;
    private Calendar inicioAvaliacao;
    private Calendar fimAvaliacao;
    private Calendar inicioRecurso;
    private Calendar fimRecurso;
    private String instituicao;
    private Organizador organizador;
    private List<Avaliador> avaliadores;
    private List<Participacao> participacoes;
    private Arquivo modeloDocumento;
    private int maxParticipantes;

    public int getCodigo() {    //V
        return codigo;
    }

    public void setCodigo(int codigo) { //V
        this.codigo = codigo;
    }

    public String getNome() {   //V
        return nome;
    }

    public void setNome(String nome) {
        //Aqui deve se verificar se "nome" já não esta atribuido a outro evento
        //Mas presisa da implementação da camada DAO
        this.nome = nome;
    }

    public List<String> getAreaConhecimento() {    //V
        return areaConhecimento;
    }

    public void setAreaConhecimento(List<String> areaConhecimento) {  //V
        this.areaConhecimento= areaConhecimento;
    }

    public Calendar getInicioSubmicao() {   //V  
        return inicioSubmicao;
    }

    public void setInicioSubmicao(int hora, int minuto, int segundo, int dia, int mes, int ano) {
        
        //Verificar os erro nessas passagem de parametros
        
        this.inicioSubmicao.set(Calendar.HOUR_OF_DAY, hora);
        this.inicioSubmicao.set(Calendar.MINUTE, minuto);
        this.inicioSubmicao.set(Calendar.SECOND, segundo);
        this.inicioSubmicao.set(Calendar.DAY_OF_MONTH, dia);
        this.inicioSubmicao.set(Calendar.MONTH, mes);
        this.inicioSubmicao.set(Calendar.YEAR, ano);
    }

    public Calendar getFimSubmicao() {    //V
        return fimAvaliacao;
    }

    public void setFimSubmicao(int hora, int minuto, int segundo, int dia, int mes, int ano) {
        
        //Verificar os erro nessas passagem de parametros
        
        this.fimSubmicao.set(Calendar.HOUR_OF_DAY, hora);
        this.fimSubmicao.set(Calendar.MINUTE, minuto);
        this.fimSubmicao.set(Calendar.SECOND, segundo);
        this.fimSubmicao.set(Calendar.DAY_OF_MONTH, dia);
        this.fimSubmicao.set(Calendar.MONTH, mes);
        this.fimSubmicao.set(Calendar.YEAR, ano);
        
    }

    public Calendar getInicioAvaliacao() {  //OK
        return inicioAvaliacao;
    }

    public void setInicioAvaliacao(int hora, int minuto, int segundo, int dia, int mes, int ano) {
        
        //Verificar os erro nessas passagem de parametros
        
        this.inicioAvaliacao.set(Calendar.HOUR_OF_DAY, hora);
        this.inicioAvaliacao.set(Calendar.MINUTE, minuto);
        this.inicioAvaliacao.set(Calendar.SECOND, segundo);
        this.inicioAvaliacao.set(Calendar.DAY_OF_MONTH, dia);
        this.inicioAvaliacao.set(Calendar.MONTH, mes);
        this.inicioAvaliacao.set(Calendar.YEAR, ano);
    }

    public Calendar getFimAvaliacao() {
        return fimAvaliacao;
    }

    public void setFimAvaliacao(int hora, int minuto, int segundo, int dia, int mes, int ano) {
        
        //Verificar os erro nessas passagem de parametros
        
        this.fimAvaliacao.set(Calendar.HOUR_OF_DAY, hora);
        this.fimAvaliacao.set(Calendar.MINUTE, minuto);
        this.fimAvaliacao.set(Calendar.SECOND, segundo);
        this.fimAvaliacao.set(Calendar.DAY_OF_MONTH, dia);
        this.fimAvaliacao.set(Calendar.MONTH, mes);
        this.fimAvaliacao.set(Calendar.YEAR, ano);
    }

    public Calendar getInicioRecurso() {
        return inicioRecurso;
    }

    public void setInicioRecurso(int hora, int minuto, int segundo, int dia, int mes, int ano) {
        
        //Verificar os erro nessas passagem de parametros
        
        this.inicioRecurso.set(Calendar.HOUR_OF_DAY, hora);
        this.inicioRecurso.set(Calendar.MINUTE, minuto);
        this.inicioRecurso.set(Calendar.SECOND, segundo);
        this.inicioRecurso.set(Calendar.DAY_OF_MONTH, dia);
        this.inicioRecurso.set(Calendar.MONTH, mes);
        this.inicioRecurso.set(Calendar.YEAR, ano);
    }

    public Calendar getFimRecurso() {
        return fimRecurso;
    }

    public void setFimRecurso(int hora, int minuto, int segundo, int dia, int mes, int ano) {
        
        //Verificar os erro nessas passagem de parametros
        
        this.fimRecurso.set(Calendar.HOUR_OF_DAY, hora);
        this.fimRecurso.set(Calendar.MINUTE, minuto);
        this.fimRecurso.set(Calendar.SECOND, segundo);
        this.fimRecurso.set(Calendar.DAY_OF_MONTH, dia);
        this.fimRecurso.set(Calendar.MONTH, mes);
        this.fimRecurso.set(Calendar.YEAR, ano);
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {    //OK?
        this.instituicao = instituicao;
    }

    public Organizador getOrganizador() {   //OK?
        return organizador;
    }

    public void setOrganizador(Organizador organizador) {
        this.organizador = organizador;
    }

    public List<Avaliador> getAvaliadores() {
        return avaliadores;
    }

    public void setAvaliadores(List<Avaliador> avaliadores) {
        this.avaliadores = avaliadores;
    }

    public List<Participacao> getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(List<Participacao> participacoes) {
        this.participacoes = participacoes;
    }

    public Arquivo getModeloDocumento() {
        return modeloDocumento;
    }

    public void setModeloDocumento(Arquivo modeloDocumento) {
        this.modeloDocumento = modeloDocumento;
    }
    
    
}
