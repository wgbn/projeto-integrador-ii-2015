package br.com.wgbn.sgap.bo;

import br.com.wgbn.sgap.dao.ClienteDAO;
import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.ClienteEntity;
import br.com.wgbn.sgap.entity.MetricaEntity;
import br.com.wgbn.sgap.util.FabricaDAO;
import br.com.wgbn.sgap.vo.AcaoVO;
import br.com.wgbn.sgap.vo.ClienteVO;

import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class ClienteBO extends GenericoBO<ClienteEntity, ClienteDAO> {

    public ClienteBO() {
        this.dao = FabricaDAO.getInstance().getClienteDAO();
    }

    public List<ClienteEntity> getTodos(){
        return this.getDao().getTodos();
    }

    public ClienteEntity inserirCliente(){
        return this.salvar();
    }
    public ClienteEntity inserirCliente(ClienteEntity _cliente){
        this.setEntity(_cliente);
        return this.salvar();
    }

    private ClienteEntity salvar(){
        return this.getDao().salvar(this.getEntity());
    }

    public void alterar(){
        this.getDao().alterar(this.getEntity());
    }
    public void alterar(ClienteEntity _cliente){
        this.getDao().alterar(_cliente);
    }

    public void excluir(){
        this.getDao().excluir(this.getEntity());
    }
    public void excluir(ClienteEntity _cliente){
        this.getDao().excluir(_cliente);
    }

    public MetricaEntity getClienteMetrica(){
        MetricaEntity cliente = new MetricaEntity();
        cliente.setDescricao("clientes");
        cliente.setValor(this.getDao().getTotalClientes().intValue());

        int anterior = this.getDao().getTotalClientesMesAnterior().intValue();
        int atual = this.getDao().getTotalClientesMesAtual().intValue();
        String diferenca = atual > anterior ? "+"+(atual - anterior)+" que mês anterior" : "-"+(anterior - atual)+" que mês anterior";

        cliente.setStatusAtual(diferenca);
        cliente.setIcone("ic-user-tie");

        return cliente;
    }

    @Override
    public void resetEntity() {
        this.entity = new ClienteEntity();
    }

}
