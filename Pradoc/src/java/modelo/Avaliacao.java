/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import br.com.pradoc.iterators.CompetenciaList;
import java.util.List;

/**
 *
 * @author Anderson
 */
public class Avaliacao {
    private int id;
    private CompetenciaList conceitos;
    private float valorObitido;
    private String observacao;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CompetenciaList getConceitos() {
        return conceitos;
    }

    public void setConceitos(CompetenciaList conceitos) {
        this.conceitos = conceitos;
    }
    
    public float getValorObitido() {
        return valorObitido;
    }

    public void setValorObitido(float valorObitido) {
        this.valorObitido = valorObitido;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}
