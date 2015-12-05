package br.com.wgbn.sgap.util;

import br.com.wgbn.sgap.entity.UsuarioEntity;

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
