/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Competencia;

/**
 *
 * @author Anderson
 */
public class CompetenciaList implements AbstractList<Competencia>{
    private List<Competencia> lista;

    public CompetenciaList() {
        lista = new ArrayList<>();
    }
    
    @Override
    public Iterator crateIterator() {
        return new CompetenciaListIterator(lista);
    }

    @Override
    public boolean append(Competencia item) {
        return lista.add(item);
    }

    @Override
    public Competencia remove(int index) {
        try{
            return lista.remove(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Posicao Invalida");
        }
        return null;
    }

    @Override
    public Competencia getItem(int index) {
        try{
            return lista.get(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Posicao Invalida");
        }
        return null;
    }

    @Override
    public int size() {
        return lista.size();
    }
    
}
