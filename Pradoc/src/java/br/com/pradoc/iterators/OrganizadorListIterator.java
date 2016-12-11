/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import java.util.Iterator;
import java.util.List;
import modelo.Organizador;

/**
 *
 * @author Anderson
 */
public class OrganizadorListIterator implements Iterator{
    private List<Organizador> lista;
    private int posicao;

    public OrganizadorListIterator(List<Organizador> lista) {
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
