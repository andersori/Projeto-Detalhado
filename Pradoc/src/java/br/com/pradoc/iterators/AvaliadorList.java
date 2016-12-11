/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Avaliador;

/**
 *
 * @author Anderson
 */
public class AvaliadorList implements AbstractList<Avaliador>{
    private List<Avaliador> lista;

    public AvaliadorList() {
        lista = new ArrayList<>();
    }
    
    @Override
    public Iterator crateIterator() {
        return new AvaliadorListIterator(lista);
    }

    @Override
    public boolean append(Avaliador item) {
        return lista.add(item);
    }

    @Override
    public Avaliador remove(int index) {
        try{
            return lista.remove(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Psicao Invalida.");
        }
        return null;
    }

    @Override
    public Avaliador getItem(int index) {
        try{
            return lista.get(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Psicao Invalida.");
        }
        return null;
    }
    
}
