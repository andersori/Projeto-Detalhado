/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import br.com.pradoc.modelo.Evento;

/**
 *
 * @author Anderson
 */
public class EventoList implements AbstractList<Evento>{
    private List<Evento> lista;

    public EventoList() {
        lista = new ArrayList<>();
    }
    
    @Override
    public Iterator crateIterator() {
        return new EventoListIterator(lista);
    }

    @Override
    public boolean append(Evento item) {
        return lista.add(item);
    }

    @Override
    public Evento remove(int index) {
        try{
            return lista.remove(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Posição Invalida");
        }
        return null;
    }

    @Override
    public Evento getItem(int index) {
        try{
            return lista.get(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Posição Invalida");
        }
        return null;
    }

    @Override
    public int size() {
        return lista.size();
    }
    
}
