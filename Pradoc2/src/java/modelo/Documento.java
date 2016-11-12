/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 *
 * @author Anderson
 */
public class Documento {
    private int id;
    private int codigoEvento;
    private String username;
    private String caminho;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigoEvento() {
        return codigoEvento;
    }

    public void setCodigoEvento(int codigoEvento) {
        this.codigoEvento = codigoEvento;
    }

    public String getUsername() {
        return username;
    }

    public boolean setUsername(String username) {
        if(username.contains(" ")){
            return false;
        }
        
        this.username = ValidacaoString.retirarAcentos(username);
        return false;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = ValidacaoString.retirarAcentos(caminho);
    }
    
}
