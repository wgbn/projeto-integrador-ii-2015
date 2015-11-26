package br.com.wgbn.sgap.bo;

import br.com.wgbn.sgap.dao.TipoacaoDAO;
import br.com.wgbn.sgap.entity.TipoacaoEntity;

/**
 * Created by Walter Gandarella
 */
public class TipoacaoModel extends GenericoModel<TipoacaoEntity, TipoacaoDAO> {
    public TipoacaoModel(TipoacaoDAO dao) { super(dao); }

    @Override
    public void resetEntity() {
        this.entity = new TipoacaoEntity();
    }
}
