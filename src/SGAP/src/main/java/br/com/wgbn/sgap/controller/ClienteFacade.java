package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.entity.ClienteEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
@ManagedBean
@SessionScoped
public class ClienteFacade {

    private ClienteEntity cliente;
    private List<ClienteEntity> clientes = new LinkedList<ClienteEntity>();

    public ClienteFacade(){}

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public List<ClienteEntity> getClientes() {
        return clientes;
    }
}
