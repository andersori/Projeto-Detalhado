/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import br.com.pradoc.iterators.CompetenciaList;
import br.com.pradoc.iterators.UsuarioList;
import java.util.Calendar;

/**
 *
 * @author Anderson
 */
public class Evento {
    private int id;
    private String nome;
    private String descricao;
    private String instituicao;
    private double notaDeAprovacao;
    private Calendar inicioSubimicao;
    private Calendar fimSubmicao;
    private Calendar inicioAvaliacao;
    private Calendar fimAvaliacao;
    private Calendar inicioRecurso;
    private Calendar fimRecurso;
    private Usuario organizador;
    private UsuarioList avaliadores;
    private Arquivo modeloDocumento;
    private CompetenciaList competencias;

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
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(String instituicao) {
        this.instituicao = instituicao;
    }

    public double getNotaDeAprovacao() {
        return notaDeAprovacao;
    }

    public void setNotaDeAprovacao(double notaDeAprovacao) {
        this.notaDeAprovacao = notaDeAprovacao;
    }

    public Calendar getInicioSubimicao() {
        return inicioSubimicao;
    }

    public void setInicioSubimicao(Calendar inicioSubimicao) {
        this.inicioSubimicao = inicioSubimicao;
    }

    public Calendar getFimSubmicao() {
        return fimSubmicao;
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

    public Usuario getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Usuario organizador) {
        this.organizador = organizador;
    }

    public UsuarioList getAvaliadores() {
        return avaliadores;
    }

    public void setAvaliadores(UsuarioList avaliadores) {
        this.avaliadores = avaliadores;
    }

    public Arquivo getModeloDocumento() {
        return modeloDocumento;
    }

    public void setModeloDocumento(Arquivo modeloDocumento) {
        this.modeloDocumento = modeloDocumento;
    }

    public CompetenciaList getCompetencias() {
        return competencias;
    }

    public void setCompetencias(CompetenciaList competencias) {
        this.competencias = competencias;
    }
    
    
}   

