/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.proxy;

import dao.EventoDAO;
import modelo.Arquivo;
import modelo.Competencia;
import modelo.Evento;
import modelo.Participacao;
import modelo.Usuario;

/**
 *
 * @author Anderson
 */
public class ProxyEvento implements IEvento{
    private Usuario usuario;
    private Evento evento;

    public ProxyEvento(Usuario usuario, Evento evento) {
        this.usuario = usuario;
        this.evento = evento;
    }

    @Override
    public boolean definirConceito(Competencia conceito, Participacao part, double valor, String observacao) {
        //Se tiver permição
        if(true){
            return evento.definirConceito(conceito, part, valor, observacao);            
        }
        else{
            return false;
        }
    }

    @Override
    public boolean baixarArquivo(int id_arquivo) {
        //Se tiver permição
        if(true){
            return evento.baixarArquivo(id_arquivo);
        }
        else{
            return false;
        }
    }

    @Override
    public boolean excluir() {
        //Se tiver permição
        if(true){
            return evento.excluir();
            
        }
        else{
            return false;
        }
    }

    @Override
    public boolean valiadarParticipacao(int idParticipacao) {
        //Se tiver permição
        if(true){
            return evento.valiadarParticipacao(idParticipacao);
        }
        else{
            return false;
        }
    }

    @Override
    public boolean adicionarAvaliador(Usuario user) {
        //Se tiver permição
        if(true){
            return evento.adicionarAvaliador(user);
        }
        else{
            return false;
        }
    }

    @Override
    public boolean removerAvaliador(Usuario user) {
        //Se tiver permição
        if(true){
            return evento.removerAvaliador(user);
        }
        else{
            return false;
        }
    }

    @Override
    public boolean anexarModelo(Arquivo arq) {
        //Se tiver permição
        if(true){
            return evento.anexarModelo(arq);
        }
        else{
            return false;
        }
    }

    @Override
    public boolean distribuirArquivos() {
        //Se tiver permição
        if(true){
            return evento.distribuirArquivos();
        }
        else{
            return false;
        }
    }

    @Override
    public boolean requisiatarRevisao(Usuario user, Participacao part) {
        //Se tiver permição
        if(true){
            return evento.requisiatarRevisao(user, part);
        }
        else{
            return false;
        }
    }
    
    
}
