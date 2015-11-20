package br.com.wgbn.sgap.controller;

import br.com.wgbn.sgap.entity.ClienteEntity;
import br.com.wgbn.sgap.util.Navegacao;

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

    public ClienteFacade(){
        this.preencheClientes();
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }

    public List<ClienteEntity> getClientes() {
        return clientes;
    }

    /**
     * ### Funções do facade
     */

    private void preencheClientes(){
        ClienteEntity cli;
        for (int i = 1; i < 11; i++){
            cli = new ClienteEntity();
            cli.setId(i);
            cli.setContato("Leleco");
            cli.setNome("André Portugal " + i);
            cli.setEmail("portuga@miseravi.com");
            cli.setTelefoneFixo("(71) 3369-6969");
            cli.setTelefoneCelular("(71) 9969-6969");
            cli.setFax("(71) 7769-6969");

            this.clientes.add(cli);
        }
    }

    public String cadastrarCliente(){
        return "";
    }

    public void actionClientesCadastrar(){
        this.cliente = new ClienteEntity();
        Navegacao.navegarPara("clientes/clientesCadastrar.xhtml");
    }
}
