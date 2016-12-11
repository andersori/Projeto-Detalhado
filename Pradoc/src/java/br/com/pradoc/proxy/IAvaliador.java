/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.pradoc.proxy;

import modelo.Competencia;



/**
 *
 * @author Anderson
 */
public interface IAvaliador {
    public void definirConceito(Competencia conceito);
    public void baixarArquivo(int id_arquivo);
    
}
