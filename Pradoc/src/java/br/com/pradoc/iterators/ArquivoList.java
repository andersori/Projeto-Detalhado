/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Arquivo;

/**
 *
 * @author Anderson
 */
public class ArquivoList implements AbstractList<Arquivo>{
    private List<Arquivo> lista;

    public ArquivoList() {
        lista = new ArrayList<>();
    }
    
    @Override
    public Iterator crateIterator() {
        return new ArquivoListIterator(lista);
    }

    @Override
    public boolean append(Arquivo item) {
        return lista.add(item);
    }

    @Override
    public Arquivo remove(int index) {
        try{
            return lista.remove(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Posicao Invalida");
        }
        return null;
    }

    @Override
    public Arquivo getItem(int index) {
        try{
            return lista.get(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Posicao Invalida");
        }
        return null;
    }
    
}
