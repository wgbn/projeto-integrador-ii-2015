/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.tbTipoAcaoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Matthew
 */
public class TipoAcaoDAO extends daoUtil{

    public TipoAcaoDAO() {
        super();
    }
    
    public boolean adicionar(tbTipoAcaoDTO tipoacao) throws SQLException, ClassNotFoundException {
        int idacao = super.getMaxId("SELECT MAX(id)+1 FROM TIPOACAO");
        PreparedStatement ps = super.getPreparedStatement("INSERT INTO TIPOACAO "
                + "(ID, "
                + "TIPO"
                + "DATACRIACAO, "
                + "DATAEDICAO, "
                + "VALUES (?,?,?,?)");
        ps.setInt(1, tipoacao.getIdtipoacao());
        ps.setString(2,tipoacao.getTipo() );
        ps.setDate(9, new java.sql.Date(tipoacao.getDtcriacao().getTime()));
        ps.setDate(10, new java.sql.Date(tipoacao.getDtedicao().getTime()));

        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
    }

    public boolean alterar(tbTipoAcaoDTO tipoacao) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.getPreparedStatement("UPDATE TIPOACAO SET "
                + "DATACRIACAO = ?, "
                + "DATAEDICAO = ? )"
                + "WHERE ID = ?");

        
        ps.setDate(1, new java.sql.Date(tipoacao.getDtcriacao().getTime()));
        ps.setDate(2, new java.sql.Date(tipoacao.getDtedicao().getTime()));
        ps.setInt(3, tipoacao.getIdtipoacao());

        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
    }

    public boolean excluir(tbTipoAcaoDTO tipoacao) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.getPreparedStatement("DELETE FROM TIPOACAO "
                + "WHERE ID = ?");
        ps.setInt(1, tipoacao.getIdtipoacao());
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
    }

    public tbTipoAcaoDTO getPorId(tbTipoAcaoDTO tipoacao) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM TIPOACAO "
                + "WHERE ID = ?");
        ps.setInt(1, tipoacao.getIdtipoacao());
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            rs.close();
            ps.close();
            super.getFechaTudo();
            return null;
        }
        tbTipoAcaoDTO proRet = new tbTipoAcaoDTO(rs.getInt("ID"),
                rs.getString("TIPO"),
                rs.getDate("DATACRIACAO"),
                rs.getDate("DATAEDICAO"));
        rs.close();
        ps.close();
        super.getFechaTudo();
        return proRet;
    }

    public List<tbTipoAcaoDTO> getTodos() throws SQLException, ClassNotFoundException {
        List<tbTipoAcaoDTO> todosOsTipoAcao = new LinkedList<tbTipoAcaoDTO>();

        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM TIPOACAO ");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            todosOsTipoAcao.add( new tbTipoAcaoDTO(rs.getInt("ID"),
                rs.getString("TIPO"),
                rs.getDate("DATACRIACAO"),
                rs.getDate("DATAEDICAO")));
        }
        rs.close();
        ps.close();
        super.getFechaTudo();
        return todosOsTipoAcao;
    }
    
    
}
