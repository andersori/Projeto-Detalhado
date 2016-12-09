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
public class Organizador extends Decorator{
    private List<Evento> eventos;

    public Organizador(Usuario usuario) {
        super(usuario);
    }
    
    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    //-----------------------------------------------------------------------------
    public boolean excluirEvento(Evento evento){
        return true;
    }
    
    public boolean validarParticipacao(Arquivo arquivo){
        return true;
    }
    
    public Evento eventoEspecifico(Evento evento){
        for(int i = 0; i< eventos.size(); i++){
            Evento temp = eventos.get(i);
            
            if(evento.getId() == temp.getId()){
                return temp;
            }
        }
        
        return null;
    }
    
}
