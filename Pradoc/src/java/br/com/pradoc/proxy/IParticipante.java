/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.proxy;

import modelo.Participacao;
import modelo.Usuario;

/**
 *
 * @author Anderson
 */
public interface IParticipante {
    public void requisiatarRevisao(Usuario user, Participacao part);
    public void baixarArquivo(int id_arquivo);
}
