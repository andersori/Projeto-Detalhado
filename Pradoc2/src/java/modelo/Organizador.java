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
public class Organizador {
    private Usuario usuario;
    private ArrayList<Evento> eventos;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(Evento evento) {
        this.eventos.add(evento);
    }
    
    /**
     * Funções do ORGANZADOR
     */
    
    public boolean excluirEvento(int id_evento){
        return true;
    }
    
    public boolean validarDocumento(int id_documento){
        return true;
    }
    
    public Evento eventoEspecifico(int id_evento){
        for(int i = 0; i< eventos.size(); i++){
            Evento temp = eventos.get(i);
            
            if(id_evento == temp.getCodigo()){
                return temp;
            }
        }
        
        return null;
    }
}
