package br.com.wgbn.sgap.util;

import br.com.wgbn.sgap.dao.UsuarioDAO;

/**
 *
 * @author André Portugal
 */
public class FabricaDAO {

    public static UsuarioDAO getUsuarioDAO(){
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
        return usuarioDAO;
    }
}