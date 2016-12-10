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
public class Avaliador{
    Usuario usuario;
    private List<Participacao> participacoes;

    public Avaliador(Usuario usuario) {
        this.usuario = usuario;
    }

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
    
    //-----------------------------------------------------------------------------
    public boolean definirConceito(Arquivo arquivo){        
        return true;
    }
    
    public List<Arquivo> documentosParaAvaliar(){
        return null;
    }

}
