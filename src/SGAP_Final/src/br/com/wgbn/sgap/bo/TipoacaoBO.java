package br.com.wgbn.sgap.bo;

import br.com.wgbn.sgap.dao.TipoacaoDAO;
import br.com.wgbn.sgap.entity.AcaoEntity;
import br.com.wgbn.sgap.entity.TipoacaoEntity;
import br.com.wgbn.sgap.util.FabricaDAO;
import br.com.wgbn.sgap.vo.AcaoVO;
import br.com.wgbn.sgap.vo.TipoacaoVO;

import java.util.List;

/**
 * Created by Walter Gandarella
 */
public class TipoacaoBO extends GenericoBO<TipoacaoEntity, TipoacaoDAO, TipoacaoVO> {
    public TipoacaoBO() {
        this.dao = FabricaDAO.getInstance().getTipoAcaoDAO();
    }

    public List<TipoacaoEntity> getTodos(){
        return this.getDao().getTodos();
    }

    public TipoacaoEntity salvar(TipoacaoEntity _tipo){
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

    @Override
    public TipoacaoVO toVo() {
        TipoacaoVO vo = new TipoacaoVO(this.getEntity());
        for (AcaoEntity a : this.getEntity().getAcoes()){
            vo.getAcoes().add(new AcaoVO(a));
        }
        return vo;
    }

    @Override
    public TipoacaoEntity toEntity(TipoacaoVO tipoacaoVO) {
        TipoacaoEntity t = new TipoacaoEntity(tipoacaoVO);
        for (AcaoVO a : tipoacaoVO.getAcoes()){
            t.getAcoes().add(new AcaoEntity(a));
        }
        return t;
    }
}
