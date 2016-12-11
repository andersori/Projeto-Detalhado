/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import java.util.Iterator;

/**
 * Factory Method para os Iterators apropriados
 * @author Anderson
 * @param <Tipo>
 */
public interface AbstractList<Tipo> {    
    public Iterator crateIterator();
    public boolean append(Tipo item);
    public Tipo remove(int index);
    public Tipo getItem(int index);
    public int size();
}
