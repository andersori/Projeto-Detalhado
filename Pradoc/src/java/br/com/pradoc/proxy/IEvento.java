/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.proxy;

import modelo.Arquivo;
import modelo.Competencia;
import modelo.Participacao;
import modelo.Usuario;

/**
 *
 * @author Anderson
 */
public interface IEvento {
    public void definirConceito(Competencia conceito, Participacao part, double valor, String observacao);
    public String baixarArquivo();
    public boolean excluir();
    public boolean valiadarParticipacao(int idParticipacao, boolean isValido);
    public boolean adicionarAvaliador(Usuario user);
    public boolean removerAvaliador(Usuario user);            
    public boolean anexarModelo(Arquivo arq);              
    public boolean distribuirArquivos();                        /*FALTA*/
    public boolean requisiatarRevisao(Participacao part);
}
