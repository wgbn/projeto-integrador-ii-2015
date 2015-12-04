package br.com.wgbn.sgap.util;

import br.com.wgbn.sgap.entity.UsuarioEntity;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * Created by Walter Gandarella
 */
public class Sessao {
    private static Sessao ourInstance = null;
    private static UsuarioEntity usuarioLogado = null;

    public static Sessao getInstance() {
        if (ourInstance == null)
            ourInstance = new Sessao();
        return ourInstance;
    }

    private Sessao() {}

    public ExternalContext getCurrentExternalContext(){
        if (FacesContext.getCurrentInstance() == null){
            throw new RuntimeException("O FacesContext não pode ser chamado fora de uma requisição HTTP");
        }else{
            return FacesContext.getCurrentInstance().getExternalContext();
        }
    }

    public void encerrarSessao(){
        getCurrentExternalContext().invalidateSession();
    }

    public UsuarioEntity getUsuarioLogado() {
        return usuarioLogado;
    }

    public void setUsuarioLogado(UsuarioEntity usuarioLogado) {
        Sessao.usuarioLogado = usuarioLogado;
    }

    public boolean isLogado(){
        return usuarioLogado == null ? false : true;
    }
}
