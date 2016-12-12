/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.TestePradoc;

import br.com.pradoc.dao.FormacaoDAO;
import br.com.pradoc.iterators.FormacaoList;
import br.com.pradoc.iterators.FormacaoListIterator;
import br.com.pradoc.modelo.Formacao;
import java.util.Iterator;

/**
 *
 * @author Anderson
 */
public class FormacaoTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FormacaoDAO dao = new FormacaoDAO();
        FormacaoList f = dao.selectAll();
        
        Iterator i =  f.crateIterator();
        
        while(i.hasNext()){
            Formacao d = (Formacao) i.next();
            System.out.println(d.getIdUsuario());
        }
    }
    
}
