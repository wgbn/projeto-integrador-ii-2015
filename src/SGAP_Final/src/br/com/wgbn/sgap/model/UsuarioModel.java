package br.com.wgbn.sgap.model;

import br.com.wgbn.sgap.dao.UsuarioDAO;
import br.com.wgbn.sgap.entity.UsuarioEntity;

/**
 * Created by Walter Gandarella
 */
public class UsuarioModel extends GenericoModel<UsuarioEntity, UsuarioDAO> {
    private String resenha;

    public UsuarioModel(UsuarioDAO dao){
        super(dao);
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) {
        this.resenha = resenha;
    }

    public String gerenteToStr(UsuarioEntity usuario){
        return usuario.getGerente() == 1 ? "Sim":"Não";
    }

    public boolean validarSenha(){
        return this.resenha == this.entity.getSenha();
    }
}
