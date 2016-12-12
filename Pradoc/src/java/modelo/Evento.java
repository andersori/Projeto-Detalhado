/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import br.com.pradoc.iterators.CompetenciaList;
import br.com.pradoc.iterators.UsuarioList;
import br.com.pradoc.proxy.IEvento;
import dao.ArquivoDAO;
import dao.AvaliacaoDAO;
import dao.AvaliadorDAO;
import dao.EmailParticipacaoDAO;
import dao.EventoDAO;
import dao.ParticipacaoDAO;
import java.util.Calendar;

/**
 *
 * @author Anderson
 */
public class Evento implements IEvento{
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

    @Override   /*OK*/
    public void definirConceito(Competencia conceito, Participacao part, double valor, String observacao) {
        Avaliacao av = new Avaliacao();
        AvaliacaoDAO dao = new AvaliacaoDAO();
        
        av.setId_competencia(conceito.getId());
        av.setId_participacao(part.getId());
        av.setObservacao(observacao);
        av.setValorObitido(valor);
        
        dao.insert(av);
        
    }

    @Override   /*OK*/
    public String baixarArquivo(int id_arquivo) {
        ArquivoDAO dao = new ArquivoDAO();
        Arquivo arq = dao.selectIdUsuario(this.organizador);
        
        return arq.getCaminho();
    }

    @Override   /*OK*/
    public boolean excluir() {
        EventoDAO dao = new EventoDAO();
        
       dao.delete(this);
        
        return true;
    }

    @Override   /*OK*/
    public boolean valiadarParticipacao(int idParticipacao, boolean isValido) {
        ParticipacaoDAO dao = new ParticipacaoDAO();
        Participacao p = dao.selectId(idParticipacao);
        
        p.setValido(isValido);
        
        dao.update(p);
        return true;
    }

    @Override   /*OK*/
    public boolean adicionarAvaliador(Usuario user) {
        AvaliadorDAO dao =  new AvaliadorDAO();
        dao.insert(user, this);
        
        return true;
    }

    @Override   /*OK*/
    public boolean removerAvaliador(Usuario user) {
        AvaliadorDAO dao = new AvaliadorDAO();
        dao.delete(user);
        return true;
    }

    @Override   /*OK*/
    public boolean anexarModelo(Arquivo arq) {
        ArquivoDAO dao = new ArquivoDAO();
        dao.insert(arq, this.organizador);
        
        this.modeloDocumento = arq;
        return true;
    }

    @Override   /*Falta*/
    public boolean distribuirArquivos() {
        AvaliadorDAO dao = new AvaliadorDAO();
        UsuarioList avaliadores = dao.selectAll();
        
        return true;
    }

    @Override   /*OK*/
    public boolean requisiatarRevisao(Participacao part) {
        ParticipacaoDAO dao = new ParticipacaoDAO();
        part.setRevisar(true);
        
        dao.update(part);
        return true;
    }
    
    
}   

