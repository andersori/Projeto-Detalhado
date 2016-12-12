/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.iterators;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import br.com.pradoc.modelo.Usuario;

/**
 *
 * @author Anderson
 */
public class UsuarioList implements AbstractList<Usuario>{
    private List<Usuario> lista;

    public UsuarioList() {
        this.lista = new ArrayList<>();
    }
    
    @Override
    public Iterator crateIterator() {
        return new UsuarioListIterator(lista);
    }

    @Override
    public boolean append(Usuario item) {
        return lista.add(item);
    }

    @Override
    public Usuario remove(int index) {
        try{
            return lista.remove(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Posição invalida");
        }
        
        return null;
    }

    @Override
    public Usuario getItem(int index) {
        try{
            return lista.get(index);
        }
        catch(IndexOutOfBoundsException ex){
            System.out.println("Posição invalida");
        }
        
        return null;
    }

    @Override
    public int size() {
        return lista.size();
    }
    
}
