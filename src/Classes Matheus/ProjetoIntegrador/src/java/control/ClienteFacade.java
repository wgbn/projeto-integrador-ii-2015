package control;

import dto.tbClienteDTO;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.ClienteDAO;


@ManagedBean
@SessionScoped
public class ClienteFacade {
    private ClienteDAO clienteDAO = new ClienteDAO();
    private tbClienteDTO clienteselecionado;
    private List<tbClienteDTO> clientes;
    private int idCombo;

    public tbClienteDTO getClienteSelecionado() {
        return clienteselecionado;
    }
    public String preparaParaIncluir(){
        clienteselecionado = new tbClienteDTO();
        return "VaiParaIncluir";
    }
    
    public String alteraCliente() throws SQLException, ClassNotFoundException{
        clienteDAO.alterar(clienteselecionado);
        clientes = null;
        return "VoltaParaListar";
    }
    
    public String finalizaCliente() throws SQLException, ClassNotFoundException{
        clientes = null;
        clienteDAO.adicionar(clienteselecionado);
        return "VoltaParaListar";
    }
    
    public String deletaCliente() throws SQLException, ClassNotFoundException{
        clienteDAO.excluir(clienteselecionado);
        clientes = null;
        return "refresh";        
    }

    public void setClienteSelecionado(tbClienteDTO clienteSelecionado) {
        this.clienteselecionado = clienteSelecionado;
    }

    public List<tbClienteDTO> getClientes() throws ClassNotFoundException, SQLException {
         if (clientes == null){
           clientes =clienteDAO.getTodos();
        }
        return clientes;
    }

    public void setClientes(List<tbClienteDTO> clientes) {
        this.clientes = clientes;
    }

    public int getIdCombo() {
        return idCombo;
    }

    public void setIdCombo(int idCombo) {
        this.idCombo = idCombo;
    }

    public ClienteFacade() {
        clientes = null;
    }
}
