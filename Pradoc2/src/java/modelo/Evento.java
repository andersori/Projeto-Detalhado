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

    public ArrayList<String> getAreaConhecimento() {    //V
        return areaConhecimento;
    }

    public void setAreaConhecimento(String areaConhecimento) {  //V
        this.areaConhecimento.add(areaConhecimento);
    }

    public String getInicioSubmicao() {   //V  
        String hora = Integer.toString(inicioSubmicao.get(Calendar.HOUR_OF_DAY));
        String minuto = Integer.toString(inicioSubmicao.get(Calendar.MINUTE));
        String segundo = Integer.toString(inicioSubmicao.get(Calendar.SECOND));
        String dia = Integer.toString(inicioSubmicao.get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(inicioSubmicao.get(Calendar.MONTH));
        String ano = Integer.toString(inicioSubmicao.get(Calendar.YEAR));
        
        String DInicio = "Hora: " + hora.concat(":" + minuto + ":" + segundo + ". Data: " + dia + "/" + mes + "/" + ano + ".");
        
        return DInicio;
    }

    public void setInicioSubmicao(Calendar inicioSubmicao) {    //V
        this.inicioSubmicao = inicioSubmicao;
    }

    public String getFimSubmicao() {    //V
        String hora = Integer.toString(inicioSubmicao.get(Calendar.HOUR_OF_DAY));
        String minuto = Integer.toString(inicioSubmicao.get(Calendar.MINUTE));
        String segundo = Integer.toString(inicioSubmicao.get(Calendar.SECOND));
        String dia = Integer.toString(inicioSubmicao.get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(inicioSubmicao.get(Calendar.MONTH));
        String ano = Integer.toString(inicioSubmicao.get(Calendar.YEAR));
        
        String DFim = "Hora: " + hora.concat(":" + minuto + ":" + segundo + ". Data: " + dia + "/" + mes + "/" + ano + ".");
        
        return DFim;
    }

    public void setFimSubmicao(Calendar fimSubmicao) {
        this.fimSubmicao = fimSubmicao;
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
