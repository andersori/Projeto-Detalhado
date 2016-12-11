/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Participacao;

/**
 *
 * @author Anderson
 */
public class ParticipacaoList implements AbstractList<Participacao>{
    private List<Participacao> lista;

    public ParticipacaoList() {
        lista = new ArrayList<>();
    }

    @Override
    public Iterator crateIterator() {
        return new ParticipacaoListIterator(lista);
    }

    @Override
    public boolean append(Participacao item) {
        return lista.add(item);
    }

    @Override
    public Participacao remove(int index) {
        try{
            return lista.remove(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Posição invalida");
        }
        
        return null;
    }

    @Override
    public Participacao getItem(int index) {
        try{
            return lista.get(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Posição invalida");
        }
        
        return null;
    }

    @Override
    public int size() {
        return lista.size();
    }
    
}
