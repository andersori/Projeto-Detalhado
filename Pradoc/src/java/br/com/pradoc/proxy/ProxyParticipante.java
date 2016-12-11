/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.proxy;

import modelo.Evento;
import modelo.Participacao;
import modelo.Usuario;

/**
 *
 * @author Anderson
 */
public class ProxyParticipante implements IParticipante{
    private Evento evento;
    private Usuario usuario;

    @Override
    public void requisiatarRevisao(Usuario user, Participacao part) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void baixarArquivo(int id_arquivo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
