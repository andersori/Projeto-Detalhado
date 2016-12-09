/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Anderson
 */
public class Decorator extends Usuario{
    private Usuario usuario;

    public Decorator(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @Override
    public void criarEvento(Evento evento){
        usuario.criarEvento(evento);
    }

    @Override
    public boolean efetuarLogin(String senha) {
        return usuario.efetuarLogin(senha);
    }
    
    public Arquivo BaixarDoumento(Arquivo arquivo){
        //Não sei como faz
        return null;
    }
}
