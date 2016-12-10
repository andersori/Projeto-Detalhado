/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Usuario;

/**
 *
 * @author Anderson
 */
public class UsuarioListIterator implements Iterator<Usuario>{
    private final List<Usuario> lista;
    private int posicao;
    
    public UsuarioListIterator(List<Usuario> lista) {
        this.lista = lista;
        this.posicao = 0;
    }
    
    
    @Override
    public boolean hasNext() {
        return posicao < lista.size();
    }

    @Override
    public Usuario next() {
        return lista.get(posicao++);
    }
    
}
