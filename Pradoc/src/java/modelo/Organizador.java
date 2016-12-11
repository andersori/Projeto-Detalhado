/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import br.com.pradoc.iterators.EventoList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class Organizador{
    private Usuario usuario;
    private EventoList eventos;

    public Organizador(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public EventoList getEventos() {
        return eventos;
    }

    public void setEventos(EventoList eventos) {
        this.eventos = eventos;
    }
    

    //-----------------------------------------------------------------------------
    public boolean excluirEvento(Evento evento){
        return true;
    }
    
    public boolean validarParticipacao(Arquivo arquivo){
        return true;
    }
    
    public Evento eventoEspecifico(int index){
        return eventos.getItem(index);
    }
    
}
