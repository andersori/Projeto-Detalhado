/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


/**
 *
 * @author Anderson
 */
public class Avaliacao {
    private int id_participacao;
    private int id_competencia;
    private double valorObitido;
    private String observacao;
    
    public Avaliacao(int id_participacao,int id_competencia, double valorObitido, String observacao){
        this.id_participacao=id_participacao;
        this.id_competencia=id_competencia;
        this.valorObitido=valorObitido;
        this.observacao=observacao;
    }

    public Avaliacao() {
        
    }
    public int getId_participacao() {
        return id_participacao;
    }

    public void setId_participacao(int id_participacao) {
        this.id_participacao = id_participacao;
    }

    public int getId_competencia() {
        return id_competencia;
    }

    public void setId_competencia(int id_competencia) {
        this.id_competencia = id_competencia;
    }

    public double getValorObitido() {
        return valorObitido;
    }

    public void setValorObitido(double valorObitido) {
        this.valorObitido = valorObitido;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
}
