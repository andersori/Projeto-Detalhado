/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.proxy;

import br.com.pradoc.dao.ArquivoDAO;
import br.com.pradoc.dao.ParticipacaoDAO;
import br.com.pradoc.dao.ResponsavelAvaliacaoDAO;
import br.com.pradoc.iterators.ParticipacaoList;
import br.com.pradoc.modelo.Arquivo;
import br.com.pradoc.modelo.Competencia;
import br.com.pradoc.modelo.Evento;
import br.com.pradoc.modelo.Participacao;
import br.com.pradoc.modelo.Usuario;
import java.util.Iterator;

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
    public String baixarArquivo(int idArquivo){
        //Se tiver permição
        ArquivoDAO arq=new ArquivoDAO();
        if(usuario.getId()==arq.selectArquivoID(idArquivo).getId_usuario())
            return evento.baixarArquivo(idArquivo);
        
        ParticipacaoDAO part=new ParticipacaoDAO();
        ParticipacaoList participacoes = part.selectAll();
        Iterator iPart = participacoes.crateIterator();
        
        while(iPart.hasNext()){
            Participacao p = (Participacao) iPart.next();
            Iterator iAval = p.getEvento().getAvaliadores().crateIterator();
            
            while(iAval.hasNext()){
                Usuario av = (Usuario) iAval.next();
                if(av.getId() == usuario.getId() && p.getArquivo().getId() == idArquivo){
                    return evento.baixarArquivo(idArquivo);
                }
            }
            if(p.getEvento().getOrganizador().getId() == usuario.getId() && p.getArquivo().getId() == idArquivo){
                return evento.baixarArquivo(idArquivo);
            }
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
