/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import br.com.pradoc.iterators.AvaliacaoList;
import java.util.List;


/**
 *
 * @author Anderson
 */
public class Participacao {
    private int id;
    private List<String> emailsUsuarios;
    private Arquivo arquivo;
    private boolean valido;
    private String status;
    private float resultadoFinal;
    private AvaliacaoList avaliacoes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getEmailsUsuarios() {
        return emailsUsuarios;
    }

    public void setEmailsUsuarios(List<String> emailsUsuarios) {
        this.emailsUsuarios = emailsUsuarios;
    }

    public Arquivo getArquivo() {
        return arquivo;
    }

    public void setArquivo(Arquivo arquivo) {
        this.arquivo = arquivo;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getResultadoFinal() {
        return resultadoFinal;
    }

    public void setResultadoFinal(float resultadoFinal) {
        this.resultadoFinal = resultadoFinal;
    }

    public AvaliacaoList getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(AvaliacaoList avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    
}
