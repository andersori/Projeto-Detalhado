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
class Participacao {
    
    private ArrayList<String> emailsUsuarios;
    private Documento documento;
    private boolean valido;
    private String status;

    public ArrayList<String> getEmailsUsuarios() {
        return emailsUsuarios;
    }

    public void setEmailsUsuarios(ArrayList<String> emailsUsuarios) {
        this.emailsUsuarios = emailsUsuarios;
    }

    public Documento getDocumento() {
        return documento;
    }

    public void setDocumento(Documento documento) {
        this.documento = documento;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}