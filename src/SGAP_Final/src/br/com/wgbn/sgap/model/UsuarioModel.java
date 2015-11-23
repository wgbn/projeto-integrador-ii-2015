package br.com.wgbn.sgap.model;

import br.com.wgbn.sgap.dao.UsuarioDAO;
import br.com.wgbn.sgap.entity.UsuarioEntity;
import br.com.wgbn.sgap.util.Navegacao;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Walter Gandarella
 */
public class UsuarioModel extends GenericoModel<UsuarioEntity, UsuarioDAO> {
    private String resenha;
    private static UsuarioEntity usuarioLogado = null;

    public UsuarioModel(UsuarioDAO dao){
        super(dao);
    }

    private String gerarHash(String _valor) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = sha.digest(_valor.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
            hexString.append(String.format("%02X", 0xFF & b));
        }
        return hexString.toString();
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String resenha) { this.resenha = resenha; }

    public UsuarioEntity getUsuarioLogado() { return usuarioLogado; }

    public static UsuarioEntity getLogado(){ return UsuarioModel.usuarioLogado; }

    public void setUsuarioLogado(UsuarioEntity usuarioLogado) { this.usuarioLogado = usuarioLogado; }

    public String gerenteToStr(UsuarioEntity usuario){
        return usuario.getGerente() == 1 ? "Sim":"Não";
    }

    public boolean validarSenha(){
        return this.resenha.equals(this.entity.getSenha());
    }

    public void inserirUsuario() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.getEntity().setSenha(this.gerarHash(this.getEntity().getSenha()));
        this.getDao().salvar(this.getEntity());
    }

    public boolean validarLogin() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.getEntity().setSenha(this.gerarHash(this.getEntity().getSenha()));
        UsuarioEntity usuarioNoBanco = this.getDao().getPorEmail(this.getEntity().getEmail());

        if (usuarioNoBanco.getSenha().equals(this.getEntity().getSenha())){
            this.setUsuarioLogado(usuarioNoBanco);
            return true;
        }
        return false;
    }
}
