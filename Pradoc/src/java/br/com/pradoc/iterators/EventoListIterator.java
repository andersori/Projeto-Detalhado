/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import java.util.Iterator;
import java.util.List;
import br.com.pradoc.modelo.Evento;

/**
 *
 * @author Anderson
 */
public class EventoListIterator implements Iterator{
    private List<Evento> lista;
    private int posicao;

    public EventoListIterator(List<Evento> lista) {
        this.lista = lista;
        this.posicao = 0;
    }
    
    @Override
    public boolean hasNext() {
        return posicao < lista.size();
    }

    @Override
    public Object next() {
        return lista.get(posicao++);
    }
    
}
