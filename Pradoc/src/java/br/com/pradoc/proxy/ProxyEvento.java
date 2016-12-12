/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.proxy;

import dao.ArquivoDAO;
import dao.EventoDAO;
import dao.ParticipacaoDAO;
import java.util.ArrayList;
import java.util.List;
import dao.ResponsavelAvaliacaoDAO;
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
    public void definirConceito(Competencia conceito, Participacao part, double valor, String observacao) {
                   
         ResponsavelAvaliacaoDAO dao = new ResponsavelAvaliacaoDAO();
        
        if(dao.isResponsavel(usuario, part)){
            evento.definirConceito(conceito, part, valor, observacao);            
        }
        else{
            return;
        }
    }
    

    @Override
    public boolean anexarModelo(Arquivo arq) {
        //Se tiver permição
        if(usuario.getId()==evento.getOrganizador().getId()){
            return evento.anexarModelo(arq);
        }
        else{
            return false;
        }
    }

    @Override
    public boolean distribuirArquivos() {
        //Se tiver permição
        if(usuario.getId()==evento.getOrganizador().getId()){
            return evento.distribuirArquivos();
        }
        else{
            return false;
        }
    }

    @Override
    public boolean requisiatarRevisao(Participacao part) {
        //Se tiver permição
        for(int i=0;i<part.getEmailsUsuarios().size();i++){
            if(usuario.getEmail().equals(part.getEmailsUsuarios().get(i)))
                return evento.requisiatarRevisao(part);
        }
        return false;
    }   

    @Override
    public String baixarArquivo(int id_arquivo){
        //Se tiver permição
        ArquivoDAO arq=new ArquivoDAO();
        if(usuario.getId()==arq.selectArquivoID(id_arquivo).getId_usuario())
            return evento.baixarArquivo(id_arquivo);
        
        ParticipacaoDAO part=new ParticipacaoDAO();
        List<Participacao> participacoes=part.selectAll();
        
        for(int i=0;i<participacoes.size();i++){
            for(int j=0;j<participacoes.get(i).getEvento().getAvaliadores().size();j++){
                if((participacoes.get(i).getEvento().getAvaliadores().getItem(j).getId()==usuario.getId())&&(participacoes.get(i).getArquivo().getId()==id_arquivo))
                    return evento.baixarArquivo(id_arquivo);
            }
            if((participacoes.get(i).getEvento().getOrganizador().getId()==usuario.getId())&&(participacoes.get(i).getArquivo().getId()==id_arquivo))
                return evento.baixarArquivo(id_arquivo);
        }
        return null;        

    }

    @Override
    public boolean excluir() {
        if(usuario.getId()==evento.getOrganizador().getId())
            return evento.excluir();
        else
            return false;
    }

    @Override
    public boolean valiadarParticipacao(int idParticipacao, boolean isValido) {
        //Se tiver permição
        if(usuario.getId()==evento.getOrganizador().getId()){
            return evento.valiadarParticipacao(idParticipacao, isValido);
        }
        else{
            return false;
        }
    }

    @Override
    public boolean adicionarAvaliador(Usuario user) {
        //Se tiver permição
        if(usuario.getId()==evento.getOrganizador().getId()){
            return evento.adicionarAvaliador(user);
        }
        else{
            return false;
        }
    }

    @Override
    public boolean removerAvaliador(Usuario user) {
        //Se tiver permição
        if(usuario.getId()==evento.getOrganizador().getId()){
            return evento.removerAvaliador(user);
        }
        else{
            return false;
        }
    }
    
    
    
}
