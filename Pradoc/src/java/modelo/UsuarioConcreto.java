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
public class UsuarioConcreto extends Usuario{

    public UsuarioConcreto() {
        
    }
    
    
    @Override
    public boolean efetuarLogin(String senha){
        return getSenha().equals(senha);
    }

    @Override
    public void criarEvento(Evento evento) {
        //Não sei o deve ser feito
    }
    
}
