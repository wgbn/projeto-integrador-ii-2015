package br.com.wgbn.sgap.bo;

import br.com.wgbn.sgap.dao.UsuarioDAO;
import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.UsuarioAcaoEntity;
import br.com.wgbn.sgap.entity.UsuarioEntity;
import br.com.wgbn.sgap.util.FabricaDAO;
import br.com.wgbn.sgap.util.Sessao;
import br.com.wgbn.sgap.vo.UsuarioAcaoVO;
import br.com.wgbn.sgap.vo.UsuarioVO;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class UsuarioBO extends GenericoBO<UsuarioEntity, UsuarioDAO> {
    private String resenha;
    private static UsuarioEntity usuarioLogado = null;

    public UsuarioBO(){
        this.dao = FabricaDAO.getInstance().getUsuarioDAO();
    }

    public String getResenha() {
        return resenha;
    }

    public void setResenha(String _resenha) { this.resenha = _resenha; }

    public String gerenteToStr(UsuarioEntity _usuario){
        return _usuario.getGerente() == 1 ? "Sim":"Não";
    }

    public String gerenteToStr(UsuarioVO _usuario){
        return _usuario.getGerente() == 1 ? "Sim":"Não";
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

    public boolean validarSenha(){
        return this.validarSenhaUsuario();
    }
    public boolean validarSenha(UsuarioEntity _usuario){
        this.setEntity(_usuario);
        return this.validarSenhaUsuario();
    }

    private boolean validarSenhaUsuario(){
        return this.resenha.equals(this.getEntity().getSenha());
    }

    public void inserirUsuario() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.salvar();
    }
    public void inserirUsuario(UsuarioEntity _usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.setEntity(_usuario);
        this.salvar();
    }

    private void salvar() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.getEntity().setSenha(this.gerarHash(this.getEntity().getSenha()));
        this.getDao().salvar(this.getEntity());
        this.setEntity(null);
    }

    public boolean validarLogin() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        return this.validarLoginUsuario();
    }
    public boolean validarLogin(UsuarioEntity _usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.setEntity(_usuario);
        return this.validarLoginUsuario();
    }

    private boolean validarLoginUsuario() throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.getEntity().setSenha(this.gerarHash(this.getEntity().getSenha()));
        UsuarioEntity usuarioNoBanco = this.getDao().getPorEmail(this.getEntity().getEmail());

        if (usuarioNoBanco.getSenha().equals(this.getEntity().getSenha())){
            Sessao.getInstance().setUsuarioLogado(usuarioNoBanco);
            return true;
        }
        return false;
    }

    public List<UsuarioEntity> getTodos(){
        return this.getDao().getTodos();
    }

    public List<UsuarioEntity> getTodosDisponiveis(AcaoEntity _acao){
        List<UsuarioEntity> usuarios = new LinkedList<UsuarioEntity>();

        for (UsuarioEntity u : this.getDao().getTodos()){
            if (u.getAcoes().size() == 0)
                usuarios.add(u);

            for (UsuarioAcaoEntity ua : u.getAcoes()){
                boolean t1 = ua.getAcao().getDatainicio().getTime() < _acao.getDatainicio().getTime();
                boolean t2 = ua.getAcao().getDatafim().getTime() > _acao.getDatafim().getTime();
                if (
                        ua.getAcao().getDatainicio().getTime() < _acao.getDatainicio().getTime() &&
                        ua.getAcao().getDatafim().getTime() > _acao.getDatafim().getTime()
                    ){
                    if (!usuarios.contains(u))
                        usuarios.add(u);
                }
            }
        }
        System.out.println("## getTodosDisponiveis");
        return usuarios;
    }

    public UsuarioEntity getPorPk(UsuarioEntity _usuario){
        return this.getDao().getPorPk(_usuario.getId());
    }

    public void alterar(){
        this.getDao().alterar(this.getEntity());
    }
    public void alterar(UsuarioEntity _usuario){
        this.getDao().alterar(_usuario);
    }

    public void excluir(){
        this.getDao().excluir(this.getEntity());
    }
    public void excluir(UsuarioEntity _usuario){
        this.getDao().excluir(_usuario);
    }

    @Override
    public void resetEntity() {
        this.entity = new UsuarioEntity();
    }

}
