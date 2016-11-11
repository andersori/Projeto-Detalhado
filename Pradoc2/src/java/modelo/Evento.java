/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Anderson
 */
public class Evento {
    private int codigo;
    private String nome;
    private ArrayList<String> areaConhecimento;
    private Calendar inicioSubmicao;
    private Calendar fimSubmicao;
    private Calendar inicioAvaliacao;
    private Calendar fimAvaliacao;
    private Calendar inicioRecurso;
    private Calendar fimRecurso;
    private String instituicao;
    private Organizador organizador;
    private ArrayList<Avaliador> avaliadores;
    private ArrayList<Participacao> participacoes;
    private Documento modeloDocumento;
}
