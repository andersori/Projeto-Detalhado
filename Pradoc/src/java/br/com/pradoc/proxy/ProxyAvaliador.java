/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.proxy;

import modelo.Competencia;
import modelo.Evento;
import modelo.Usuario;

/**
 *
 * @author Anderson
 */
public class ProxyAvaliador implements IAvaliador{
    private Evento evento;
    private Usuario usuario;

    @Override
    public void definirConceito(Competencia conceito) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void baixarArquivo(int id_arquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
