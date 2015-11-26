package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.dao.ClienteDAO;
import br.com.wgbn.sgap.entity.ClienteEntity;
import br.com.wgbn.sgap.bo.ClienteModel;
import br.com.wgbn.sgap.bo.UsuarioModel;
import br.com.wgbn.sgap.util.Navegacao;
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
public class ClienteFacade {

    private List<ClienteEntity> clientes = new LinkedList<ClienteEntity>();
    private ClienteModel        model;
    private ClienteDAO          dao;

    public ClienteFacade(){
        if (this.dao == null && MainApp.getFacadeEntityManager() != null)
            this.dao = new ClienteDAO(MainApp.getFacadeEntityManager().getEntityManager());
        model = new ClienteModel(dao);

        System.out.println("##-> ClienteFacade iniciado");
    }

    /**
     * Getters e setters
     */

    public ClienteEntity getCliente() {
        return this.model.getEntity();
    }

    public void setCliente(ClienteEntity cliente) {
        this.model.setEntity(cliente);
    }

    public List<ClienteEntity> getClientes() {
        this.clientes = this.model.getDao().getTodos();
        return clientes;
    }

    public String getLogado(){
        return UsuarioModel.getLogado().getNome();
    }

    /**
     * ### Métodos do facade
     */

    public void aoCarregarCriarCliente(ComponentSystemEvent event) throws InstantiationException, IllegalAccessException {
        if (Utilidades.isNewRequest()){
            this.model.resetEntity();
            this.model.getEntity().setDatacriacao(new Timestamp(new Date().getTime()));
        }
    }

    public void cadastrarCliente() throws InstantiationException, IllegalAccessException {
        this.model.getDao().salvar(this.model.getEntity());
        this.model.resetEntity();
        Navegacao.navegarPara("clientes/clientesListar.xhtml");
    }

    public void alterarCliente(){
        this.model.getDao().alterar(this.model.getEntity());
        Navegacao.navegarPara("clientes/clientesListar.xhtml");
    }

    public void apagarCliente(){
        this.model.getDao().excluir(this.model.getEntity());
        Navegacao.navegarPara("clientes/clientesListar.xhtml");
    }
}
