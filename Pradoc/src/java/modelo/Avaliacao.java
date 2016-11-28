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
public class Avaliacao {
    private List<Competencia> conceitos;
    private float notaFinal;
    private float valorObitido;
    private String observacao;

    public List<Competencia> getConceitos() {
        return conceitos;
    }

    public void setConceitos(List<Competencia> conceitos) {
        this.conceitos = conceitos;
    }

    public float getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(float notaFinal) {
        this.notaFinal = notaFinal;
    }

    public float getValorObitido() {
        return valorObitido;
    }

    public void setValorObitido(float valorObitido) {
        this.valorObitido = valorObitido;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}
