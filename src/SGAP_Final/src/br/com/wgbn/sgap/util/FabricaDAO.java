package br.com.wgbn.sgap.util;

import br.com.wgbn.sgap.controller.MainApp;
import br.com.wgbn.sgap.dao.*;

/**
 * Created by Walter Gandarella
 */
public class FabricaDAO {
    private static FabricaDAO ourInstance = new FabricaDAO();
    private AcaoDAO         acaodao         = null;
    private ClienteDAO      clientedao      = null;
    private TipoacaoDAO     tipoacao        = null;
    private UsuarioAcaoDAO  usuarioacaodao  = null;
    private UsuarioDAO      usuariodao      = null;

    public static FabricaDAO getInstance() {
        return ourInstance;
    }

    private FabricaDAO() {
    }

    public AcaoDAO getAcaoDAO(){
        if (this.acaodao == null)
            this.acaodao = new AcaoDAO(MainApp.getFacadeEntityManager().getEntityManager());
        return this.acaodao;
    }

    public ClienteDAO getClienteDAO(){
        if (this.clientedao == null)
            this.clientedao = new ClienteDAO(MainApp.getFacadeEntityManager().getEntityManager());
        return this.clientedao;
    }

    public TipoacaoDAO getTipoAcaoDAO(){
        if (this.tipoacao == null)
            this.tipoacao = new TipoacaoDAO(MainApp.getFacadeEntityManager().getEntityManager());
        return this.tipoacao;
    }

    public UsuarioAcaoDAO getUsuarioAcaoDAO(){
        if (this.usuarioacaodao == null)
            this.usuarioacaodao = new UsuarioAcaoDAO(MainApp.getFacadeEntityManager().getEntityManager());
        return this.usuarioacaodao;
    }

    public UsuarioDAO getUsuarioDAO(){
        if (this.usuariodao == null)
            this.usuariodao = new UsuarioDAO(MainApp.getFacadeEntityManager().getEntityManager());
        return this.usuariodao
    }
}
