/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.proxy;

import modelo.Arquivo;
import modelo.Usuario;

/**
 *
 * @author Anderson
 */
public interface IOrganizador {
    public void excluir();
    public void valiadarParticipacao(int idParticipacao);
    public void adicionarAvaliador(Usuario user);
    public void removerAvaliador(Usuario user);
    public void anexarModelo(Arquivo arq);
    public void distribuirArquivos();
    public void baixarArquivo(int id_aquivo);
}
