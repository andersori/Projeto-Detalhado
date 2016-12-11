/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Organizador;

/**
 *
 * @author Anderson
 */
public class OrganizadorList implements AbstractList<Organizador>{
    private List<Organizador> lista;

    public OrganizadorList() {
        lista  =  new ArrayList<>();
    }
    
    @Override
    public Iterator crateIterator() {
        return new OrganizadorListIterator(lista);
    }

    @Override
    public boolean append(Organizador item) {
        return lista.add(item);
    }

    @Override
    public Organizador remove(int index) {
        try{
            return lista.remove(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Posicao invalida");
        }
        return null;
    }

    @Override
    public Organizador getItem(int index) {
        try{
            return lista.get(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Posicao invalida");
        }
        return null;
    }
    
}
