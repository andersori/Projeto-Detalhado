/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import br.com.pradoc.iterators.ArquivoList;
import br.com.pradoc.iterators.ParticipacaoList;

/**
 *
 * @author Anderson
 */
public class Avaliador{
    Usuario usuario;
    private ParticipacaoList participacoes;

    public Avaliador(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ParticipacaoList getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(ParticipacaoList participacoes) {
        this.participacoes = participacoes;
    }
    
    //-----------------------------------------------------------------------------
    public boolean definirConceito(Arquivo arquivo){        
        return true;
    }
    
    public ArquivoList documentosParaAvaliar(){
        return null;
    }

}
