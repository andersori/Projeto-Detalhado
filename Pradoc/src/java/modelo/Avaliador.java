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
class Avaliador {
    private Usuario usuario;
    private ArrayList<Documento> documentos;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(ArrayList<Documento> documentos) {
        this.documentos = documentos;
    }
    
}
