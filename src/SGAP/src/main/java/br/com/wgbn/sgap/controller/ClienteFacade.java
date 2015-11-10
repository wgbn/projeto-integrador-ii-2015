package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.entity.ClienteEntity;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class ClienteFacade {

    private ClienteEntity cliente;
    private List<ClienteEntity> clientes = new LinkedList<ClienteEntity>();

    public ClienteFacade(){}
}
