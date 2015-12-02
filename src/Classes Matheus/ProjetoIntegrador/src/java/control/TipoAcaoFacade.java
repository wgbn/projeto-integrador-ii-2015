package control;

import dto.tbTipoAcaoDTO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.TipoAcaoDAO;


@ManagedBean
@SessionScoped
public class TipoAcaoFacade {
    private TipoAcaoDAO tipoAcaoDAO = new TipoAcaoDAO();
    private  tbTipoAcaoDTO tiposelecionado;
    private List<tbTipoAcaoDTO> tipos;
    private int idCombo;

    public tbTipoAcaoDTO getTipoSelecionado() {
        return tiposelecionado;
    }
    public String preparaParaIncluir(){
        tiposelecionado = new tbTipoAcaoDTO();
        return "VaiParaIncluir";
    }
    
    public String alteraTipo() throws SQLException, ClassNotFoundException{
        tipoAcaoDAO.alterar(tiposelecionado);
        tipos = null;
        return "VoltaParaListar";
    }
    
    public String finalizar() throws SQLException, ClassNotFoundException{
        tipos = null;
        tipoAcaoDAO.adicionar(tiposelecionado);
        return "VoltaParaListar";
    }
    
    public String deletar() throws SQLException, ClassNotFoundException{
        tipoAcaoDAO.excluir(tiposelecionado);
        tipos = null;
        return "refresh";        
    }

    public void setTipoSelecionado(tbTipoAcaoDTO tiposelecao) {
        this.tiposelecionado = tiposelecao;
    }

    public List<tbTipoAcaoDTO> getTipos() throws ClassNotFoundException, SQLException {
         if (tipos == null){
           tipos = tipoAcaoDAO.getTodos();
        }
        return tipos;
    }

    public void setTipos(List<tbTipoAcaoDTO> acoes) {
        this.tipos = acoes;
    }

    public int getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(int idCombo) {
        this.idCombo = idCombo;
    }

    public TipoAcaoFacade() {
      tipos = null;
    }
}
