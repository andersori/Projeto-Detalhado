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
public class Avaliador {
    private Usuario usuario;
    private ArrayList<Participacao> participacoes;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Participacao> getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(Participacao participacao) {
        this.participacoes.add(participacao);
    }

    
    /**
     * Funções de uma AVALIADOR
     */
    
    public boolean avaliar(int id_participacao){
        //Não entendi o que ele deve fazer
        
        return true;
    }
    
    public boolean definirConceito(int id_participacao){
        //Para determinar o conceito é so acessar um evento especifico
        //depois uma participação especifica.
        
        return true;
    }
    
    public Documento baixarDocumento(int id_participacao){
        //Requisitar a uma participacao de um evento
        return null;
    }
    
    public ArrayList<Documento> documentosParaAvaliar(){
        //Requisitar as participacoes de um evento
        return null;
    }
}
