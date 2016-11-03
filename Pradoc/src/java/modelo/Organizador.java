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
class Organizador {
    private Usuario usuario;
    private ArrayList<Evento> evento;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Evento> getEvento() {
        return evento;
    }

    public void setEvento(ArrayList<Evento> evento) {
        this.evento = evento;
    }
    
}
