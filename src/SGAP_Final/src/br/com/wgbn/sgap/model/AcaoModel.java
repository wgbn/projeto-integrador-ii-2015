package br.com.wgbn.sgap.model;

import br.com.wgbn.sgap.dao.AcaoDAO;
import br.com.wgbn.sgap.entity.AcaoEntity;

import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class AcaoModel extends GenericoModel<AcaoEntity, AcaoDAO> {

    public AcaoModel(AcaoDAO dao) { super(dao); }

    @Override
    public void resetEntity() {
        this.entity = new AcaoEntity();
    }

    public List<AcaoEntity> getTodasNaoRealizadas(){
        if (UsuarioModel.getLogado().getGerente() == 1)
            return this.getDao().getTodosNaoRealizadosGerente();
        else
            return this.getDao().getTodosNaoRealizadosPromotor(UsuarioModel.getLogado().getId());
    }
}
