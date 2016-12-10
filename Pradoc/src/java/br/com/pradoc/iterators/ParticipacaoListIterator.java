/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import java.util.Iterator;
import java.util.List;
import modelo.Participacao;

/**
 *
 * @author Anderson
 */
public class ParticipacaoListIterator implements Iterator<Participacao>{
    private final List<Participacao> lista;
    private int posiscao;

    public ParticipacaoListIterator(List<Participacao> lista) {
        this.lista = lista;
    }
    
    @Override
    public boolean hasNext() {
        return posiscao < lista.size();
    }

    @Override
    public Participacao next() {
        return lista.get(posiscao++);
    }
    
}
