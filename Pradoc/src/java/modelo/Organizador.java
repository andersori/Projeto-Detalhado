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
public class Organizador {
    private Usuario usuario;
    private List<Evento> eventos;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(List<Evento> eventos) {
        this.eventos = eventos;
    }

    
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
