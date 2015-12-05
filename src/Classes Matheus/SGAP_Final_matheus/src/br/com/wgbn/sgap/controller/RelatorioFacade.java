package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.ClienteEntity;
import br.com.wgbn.sgap.entity.UsuarioEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
@ManagedBean
@SessionScoped
public class RelatorioFacade extends GenericoBean {

    private List<ClienteEntity> clientes = new LinkedList<ClienteEntity>();
    private List<UsuarioEntity> usuarios = new LinkedList<UsuarioEntity>();
    private List<AcaoEntity>    acoes    = new LinkedList<AcaoEntity>();

    public List<ClienteEntity> getClientes() {
        return clientes;
    }

    public List<UsuarioEntity> getUsuarios() {
        return usuarios;
    }

    public List<AcaoEntity> getAcoes() {
        return acoes;
    }
}
