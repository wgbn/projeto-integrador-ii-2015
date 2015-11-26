package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.bo.ClienteBO;
import br.com.wgbn.sgap.bo.UsuarioBO;
import br.com.wgbn.sgap.dao.ClienteDAO;
import br.com.wgbn.sgap.entity.ClienteEntity;
import br.com.wgbn.sgap.util.Navegacao;
import br.com.wgbn.sgap.util.Utilidades;
import br.com.wgbn.sgap.vo.ClienteVO;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
@ManagedBean
@SessionScoped
public class ClienteFacade {

    private List<ClienteVO> clientes = new LinkedList<ClienteVO>();
    private ClienteBO       clienteBO;
    private ClienteVO       clienteVO;

    public ClienteFacade(){
        this.clienteBO = new ClienteBO();
        System.out.println("##-> ClienteFacade iniciado");
    }

    /**
     * Getters e setters
     */

    public ClienteVO getCliente() {
        return this.clienteVO;
    }

    public void setCliente(ClienteVO _cliente) {
        this.clienteVO = _cliente;
    }

    public List<ClienteVO> getClientes() {
        this.clientes = new LinkedList<ClienteVO>();
        for (ClienteEntity c : this.clienteBO.getTodos()){
            this.clientes.add(new ClienteVO(c));
        }
        return this.clientes;
    }

    public String getLogado(){
        return UsuarioBO.getLogado().getNome();
    }

    /**
     * ### Métodos do facade
     */

    public void aoCarregarCriarCliente(ComponentSystemEvent event) throws InstantiationException, IllegalAccessException {
        if (Utilidades.isNewRequest()){
            this.clienteVO = new ClienteVO();
            this.clienteVO.setDatacriacao(new Timestamp(new Date().getTime()));
            this.clienteBO.setEntityFromVo(this.clienteVO);
        }
    }

    public void cadastrarCliente() throws InstantiationException, IllegalAccessException {
        this.clienteBO.setEntityFromVo(this.clienteVO);
        this.clienteBO.inserirCliente();
        Navegacao.navegarPara("clientes/clientesListar.xhtml");
    }

    public void alterarCliente(){
        this.clienteBO.setEntityFromVo(this.clienteVO);
        this.clienteBO.alterar();
        Navegacao.navegarPara("clientes/clientesListar.xhtml");
    }

    public void apagarCliente(){
        this.clienteBO.setEntityFromVo(this.clienteVO);
        this.clienteBO.excluir();
        Navegacao.navegarPara("clientes/clientesListar.xhtml");
    }
}
