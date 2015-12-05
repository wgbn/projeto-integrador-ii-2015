package control;

import dto.tbUsuarioDTO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.UsuarioDAO;


@ManagedBean
@SessionScoped
public class UsuarioFacade {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private  tbUsuarioDTO usuarioselecionado;
    private List<tbUsuarioDTO> usuarios;
    private int idCombo;

    public tbUsuarioDTO getUsuarioSeolecionado() {
        return usuarioselecionado;
    }
    public String preparaParaIncluir(){
        usuarioselecionado = new tbUsuarioDTO();
        return "VaiParaIncluir";
    }
    
    public String alteraUsuario() throws SQLException, ClassNotFoundException{
        usuarioDAO.alterar(usuarioselecionado);
        usuarios = null;
        return "VoltaParaListar";
    }
    
    public String finalizaUsuario() throws SQLException, ClassNotFoundException{
        usuarios = null;
        usuarioDAO.adicionar(usuarioselecionado);
        return "VoltaParaListar";
    }
    
    public String deletaUsuario() throws SQLException, ClassNotFoundException{
        usuarioDAO.excluir(usuarioselecionado);
        usuarios = null;
        return "refresh";        
    }

    public void setUsuarioSelecionado(tbUsuarioDTO usuarioSelecionado) {
        this.usuarioselecionado = usuarioSelecionado;
    }

    public List<tbUsuarioDTO> getUsuarios() throws ClassNotFoundException, SQLException {
         if (usuarios == null){
           usuarios = usuarioDAO.getTodos();
        }
        return usuarios;
    }

    public void setUsuarios(List<tbUsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

    public int getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(int idCombo) {
        this.idCombo = idCombo;
    }

    public UsuarioFacade() {
      usuarios = null;
    }
}
