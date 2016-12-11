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
    public void definirConceito(Competencia conceito, Participacao part, double valor, String observacao);  /*OK*/
    public String baixarArquivo(int id_arquivo);                /*OK*/
    public boolean excluir();                                   /*FALTA*/
    public boolean valiadarParticipacao(int idParticipacao);    /*FALTA*/
    public boolean adicionarAvaliador(Usuario user);            /*OK*/
    public boolean removerAvaliador(Usuario user);              /*OK*/
    public boolean anexarModelo(Arquivo arq);                   /*OK*/
    public boolean distribuirArquivos();                        /*FALTA*/
    public boolean requisiatarRevisao(Usuario user, Participacao part);    
}
