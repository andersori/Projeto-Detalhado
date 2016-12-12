/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import br.com.pradoc.modelo.Formacao;

/**
 *
 * @author Anderson
 */
public class FormacaoList implements AbstractList<Formacao>{
    private List<Formacao> lista;

    public FormacaoList() {
        lista = new ArrayList<>();
    }
    
    @Override
    public Iterator crateIterator() {
        return new FormacaoListIterator(lista);
    }

    @Override
    public boolean append(Formacao item) {
        return lista.add(item);
    }

    @Override
    public Formacao remove(int index) {
        try{
            return lista.remove(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Posição Invalida");
        }
        return null;
    }

    @Override
    public Formacao getItem(int index) {
        try{
            return lista.remove(index);
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
