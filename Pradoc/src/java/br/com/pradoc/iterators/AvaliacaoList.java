/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Avaliacao;

/**
 *
 * @author Anderson
 */
public class AvaliacaoList implements AbstractList<Avaliacao>{
    private List<Avaliacao> lista;

    public AvaliacaoList() {
        lista = new ArrayList<>();
    }
    
    @Override
    public Iterator crateIterator() {
        return new AvaliacaoListIterator(lista);
    }

    @Override
    public boolean append(Avaliacao item) {
        return lista.add(item);
    }

    @Override
    public Avaliacao remove(int index) {
        try{
            return lista.remove(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Posicao Invalida");
        }
        return null;
    }

    @Override
    public Avaliacao getItem(int index) {
        try{
            return lista.get(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Posicao Invalida");
        }
        return null;
    }
    
}
