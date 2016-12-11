/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import java.util.Iterator;
import java.util.List;
import modelo.Avaliador;

/**
 *
 * @author Anderson
 */
public class AvaliadorListIterator implements Iterator{
    private List<Avaliador> lista;
    private int posicao;
    
    public AvaliadorListIterator(List<Avaliador> lista) {
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
