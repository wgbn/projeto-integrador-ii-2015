package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.bo.ClienteBO;
import br.com.wgbn.sgap.entity.ClienteEntity;
import br.com.wgbn.sgap.util.Navegacao;
import br.com.wgbn.sgap.util.Sessao;
import br.com.wgbn.sgap.util.Utilidades;

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
public class ClienteFacade extends GenericoBean {

    private List<ClienteEntity> clientes = new LinkedList<ClienteEntity>();
    private ClienteBO       clienteBO;
    private ClienteEntity   cliente;

    public ClienteFacade(){
        this.clienteBO = new ClienteBO();
        System.out.println("##-> ClienteFacade iniciado");
    }

    /**
     * Getters e setters
     */

    public ClienteEntity getCliente() {
        return this.cliente;
    }

    public void setCliente(ClienteEntity _cliente) {
        this.cliente = _cliente;
    }

    public List<ClienteEntity> getClientes() {
        /*this.clientes = new LinkedList<ClienteE>();
        for (ClienteEntity c : this.clienteBO.getTodos()){
            this.clientes.add(new ClienteVO(c));
        }*/
        this.clientes = this.clienteBO.getTodos();
        return this.clientes;
    }

    public String getLogado(){
        return Sessao.getInstance().getUsuarioLogado().getNome();
    }

    /**
     * ### Métodos do facade
     */

    public void aoCarregarCriarCliente(ComponentSystemEvent event) throws InstantiationException, IllegalAccessException {
        if (Utilidades.isNewRequest()){
            /*this.clienteVO = new ClienteVO();
            this.clienteVO.setDatacriacao(new Timestamp(new Date().getTime()));
            this.clienteBO.setEntityFromVo(this.clienteVO);*/
            this.cliente = new ClienteEntity();
            this.cliente.setDatacriacao(new Timestamp(new Date().getTime()));
            this.clienteBO.setEntity(this.cliente);
        }
    }

    public void cadastrarCliente() throws InstantiationException, IllegalAccessException {
        //this.clienteBO.setEntityFromVo(this.clienteVO);
        this.clienteBO.setEntity(this.cliente);
        this.clienteBO.inserirCliente();
        Navegacao.navegarPara("clientes/clientesListar.xhtml");
    }

    public void alterarCliente(){
        //this.clienteBO.setEntityFromVo(this.clienteVO);
        this.clienteBO.setEntity(this.cliente);
        this.clienteBO.alterar();
        Navegacao.navegarPara("clientes/clientesListar.xhtml");
    }

    public void apagarCliente(){
        //this.clienteBO.setEntityFromVo(this.clienteVO);
        this.clienteBO.setEntity(this.cliente);
        this.clienteBO.excluir();
        Navegacao.navegarPara("clientes/clientesListar.xhtml");
    }
}
