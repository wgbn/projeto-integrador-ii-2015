package br.com.wgbn.sgap.dao;

import br.com.wgbn.sgap.entity.UsuarioEntity;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metamodel.domain.Entity;

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
    public void salvar(Entity usuario){
        this.sessao.save(usuario);
    }

    @Override
    public void alterar(Entity usuario){
        this.sessao.update(usuario);
    }

    @Override
    public void excluir(Entity usuario){
        this.sessao.delete(usuario);
    }

    @Override
    public List<Entity> getAll(){
        return this.sessao.createCriteria(UsuarioEntity.class).list();
    }

    @Override
    public Entity getByPk(Entity usuario){
        return null; //(UsuarioEntity) this.sessao.get(UsuarioEntity.class, ((UsuarioEntity)usuario).getId());
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