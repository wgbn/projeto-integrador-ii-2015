package br.com.wgbn.sgap.bo;

import br.com.wgbn.sgap.dao.TipoacaoDAO;
import br.com.wgbn.sgap.entity.TipoacaoEntity;
import br.com.wgbn.sgap.util.FabricaDAO;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class TipoacaoBO extends GenericoBO<TipoacaoEntity, TipoacaoDAO> {
    public TipoacaoBO() {
        this.dao = FabricaDAO.getInstance().getTipoAcaoDAO();
    }

    public List<TipoacaoEntity> getTodos(){
        return this.getDao().getTodos();
    }

    public TipoacaoEntity salvar(TipoacaoEntity _tipo){
        _tipo.setDatacriacao(new Timestamp(new Date().getTime()));
        return this.getDao().salvar(_tipo);
    }

    public void alterar(TipoacaoEntity _tipo){
        this.getDao().alterar(_tipo);
    }

    public void excluir(TipoacaoEntity _tipo){
        this.getDao().excluir(_tipo);
    }

    @Override
    public void resetEntity() {
        this.entity = new TipoacaoEntity();
    }

}
