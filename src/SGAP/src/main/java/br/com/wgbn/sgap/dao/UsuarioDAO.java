package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.UsuarioEntity;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Walter Gandarella
 */
public class UsuarioDAO implements IF_DAO {

    private Session sessao;

    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    /**
     * ### Métodos da Interface
     */

    @Override
    public void salvar(UsuarioEntity usuario){
        this.sessao.save(usuario);
    }

    @Override
    public void alterar(UsuarioEntity usuario){
        this.sessao.update(usuario);
    }

    @Override
    public void excluir(UsuarioEntity usuario){
        this.sessao.delete(usuario);
    }

    @Override
    public List<UsuarioEntity> getAll(){
        return this.sessao.createCriteria(UsuarioEntity.class).list();
    }

    @Override
    public UsuarioEntity getByPk(UsuarioEntity usuario){
        return (UsuarioEntity) this.sessao.get(UsuarioEntity.class, usuario.getId());
    }

    /**
     * ### Métodos Próprios
     */

    public UsuarioEntity getByName(String nome) {
        String hql = "select t from UsuarioEntity t where t.nome = :nomeA";
        Query consulta = this.sessao.createQuery(hql);
        consulta.setString("nomeA", nome);
        return (UsuarioEntity) consulta.uniqueResult();
    }

    public List<UsuarioEntity> getAllByType(boolean gerente) {
        String hql = "select t from UsuarioEntity t where t.gerente = :ger";
        Query consulta = this.sessao.createQuery(hql);
        consulta.setBoolean("ger", gerente);
        return (List<UsuarioEntity>) consulta.list();
    }

    public List<UsuarioEntity> getAllByName(String nome){
        Criteria crit = this.sessao.createCriteria(UsuarioEntity.class);
        crit.add(Restrictions.like("nome","%"+nome+"%"));
        return (List<UsuarioEntity>) crit.list();

    }
}