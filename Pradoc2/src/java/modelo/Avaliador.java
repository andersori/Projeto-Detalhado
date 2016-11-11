/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Anderson
 */
public class Avaliador {
    private Usuario usuario;
    private ArrayList<Documento> documentos;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Documento getDocumentos(int idDoc) {
        Documento doc = null;
        
        for(int i = 0; i < documentos.size(); i++){
            if(documentos.get(i).getId() == idDoc){
                doc = documentos.get(i);
                break;
            }
        }
        
        return doc;
    }

    public void setDocumentos(Documento doc) {
        documentos.add(doc);
    }
    
}
