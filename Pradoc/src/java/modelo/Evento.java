/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import br.com.pradoc.iterators.AvaliadorList;
import br.com.pradoc.iterators.ParticipacaoList;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class Evento {
    private int id;
    private String nome;
    private List<String> areaConhecimento;// No banco não tem essa Lista 29/11
    private float notaAprovacao;
    private String descricao;
    private Date inicioSubmissao;
    private Date fimSubmissao;
    private Date inicioAvaliacao;
    private Date fimAvaliacao;
    private Date inicioRecurso;
    private Date fimRecurso;
    private Date resultadoRecurso;
    private Time horaInicioSubmissao;
    private Time horaFimSubmissao;
    private Time horaInicioAvaliacao;
    private Time horaFimAvaliacao;
    private Time horaInicioRecurso;
    private Time horaFimRecurso;
    private String instituicao;
    private Organizador organizador;
    private AvaliadorList avaliadores;
    private ParticipacaoList participacoes;
    private Arquivo modeloDocumento;

    public Date getResultadoRecurso() {
        return resultadoRecurso;
    }

    public void setResultadoRecurso(Date resultadoRecurso) {
        this.resultadoRecurso = resultadoRecurso;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
        
    public float getNotaAprovacao() {
        return notaAprovacao;
    }

    public void setNotaAprovacao(float notaAprovacao) {
        this.notaAprovacao = notaAprovacao;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInicioAvaliacao() {
        return inicioAvaliacao;
    }

    public void setInicioAvaliacao(Date inicioAvaliacao) {
        this.inicioAvaliacao = inicioAvaliacao;
    }

    public Date getFimAvaliacao() {
        return fimAvaliacao;
    }

    public void setFimAvaliacao(Date fimAvaliacao) {
        this.fimAvaliacao = fimAvaliacao;
    }

    public Date getInicioRecurso() {
        return inicioRecurso;
    }

    public void setInicioRecurso(Date inicioRecurso) {
        this.inicioRecurso = inicioRecurso;
    }

    public Date getFimRecurso() {
        return fimRecurso;
    }

    public void setFimRecurso(Date fimRecurso) {
        this.fimRecurso = fimRecurso;
    }

    public Time getHoraFimSubmissao() {
        return horaFimSubmissao;
    }

    public void setHoraFimSubmissao(Time horaFimSubmissao) {
        this.horaFimSubmissao = horaFimSubmissao;
    }

    public Time getHoraInicioAvaliacao() {
        return horaInicioAvaliacao;
    }

    public void setHoraInicioAvaliacao(Time horaInicioAvaliacao) {
        this.horaInicioAvaliacao = horaInicioAvaliacao;
    }

    public Time getHoraFimAvaliacao() {
        return horaFimAvaliacao;
    }

    public void setHoraFimAvaliacao(Time horaFimAvaliacao) {
        this.horaFimAvaliacao = horaFimAvaliacao;
    }

    public Time getHoraInicioRecurso() {
        return horaInicioRecurso;
    }

    public void setHoraInicioRecurso(Time horaInicioRecurso) {
        this.horaInicioRecurso = horaInicioRecurso;
    }

    public Time getHoraFimRecurso() {
        return horaFimRecurso;
    }

    public void setHoraFimRecurso(Time horaFimRecurso) {
        this.horaFimRecurso = horaFimRecurso;
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

    public Date getInicioSubmissao() {
        return inicioSubmissao;
    }
    

    public void setHoraInicioSubmissao(Time horaInicioSubmissao) {
        this.horaInicioSubmissao = horaInicioSubmissao;
    }

    public Date getFimSubmissao() {
        return fimSubmissao;
    }

    public void setFimSubmissao(Date fimSubmissao) {
        this.fimSubmissao = fimSubmissao;
    }

    public void setInicioSubmissao(Date inicioSubmissao) {
        this.inicioSubmissao = inicioSubmissao;
    }

    public Time getHoraInicioSubmissao() {
        return horaInicioSubmissao;
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

    public AvaliadorList getAvaliadores() {
        return avaliadores;
    }

    public void setAvaliadores(AvaliadorList avaliadores) {
        this.avaliadores = avaliadores;
    }

    public ParticipacaoList getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(ParticipacaoList participacoes) {
        this.participacoes = participacoes;
    }
    
    public Arquivo getModeloDocumento() {
        return modeloDocumento;
    }

    public void setModeloDocumento(Arquivo modeloDocumento) {
        this.modeloDocumento = modeloDocumento;
    }
    
    
}
