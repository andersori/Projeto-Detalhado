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
public class Avaliador {
    private Usuario usuario;
    private List<Participacao> participacoes;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Participacao> getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(List<Participacao> participacoes) {
        this.participacoes = participacoes;
    }
    
    public boolean avaliar(int id_participacao){
        //Não entendi o que ele deve fazer
        
        return true;
    }
    
    public boolean definirConceito(int id_participacao){
        //Para determinar o conceito é so acessar um evento especifico
        //depois uma participação especifica.
        
        return true;
    }
    
    public Arquivo baixarDocumento(int id_participacao){
        //Requisitar a uma participacao de um evento
        return null;
    }
    
    public List<Arquivo> documentosParaAvaliar(){
        //Requisitar as participacoes de um evento
        return null;
    }
}
