/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import java.util.Iterator;
import java.util.List;
import modelo.Avaliacao;

/**
 *
 * @author Anderson
 */
public class AvaliacaoListIterator implements Iterator<Object>{
    private List<Avaliacao> lista;
    private int posicao;

    public AvaliacaoListIterator(List<Avaliacao> lista) {
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
