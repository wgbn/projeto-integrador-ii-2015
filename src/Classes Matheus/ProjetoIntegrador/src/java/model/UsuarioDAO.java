/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.tbUsuarioDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Matthew
 */
public class UsuarioDAO extends daoUtil {

    public UsuarioDAO() {
        super();
    }

    public boolean adicionar(tbUsuarioDTO usuario) throws SQLException, ClassNotFoundException {
        int idusuario = super.getMaxId("SELECT MAX(id)+1 FROM USUARIO");
        PreparedStatement ps = super.getPreparedStatement("INSERT INTO USUARIO "
                + "(ID, "
                + "NOME,  "
                + "EMAIL, "
                + "SENHA, "
                + "BANCO, "
                + "AGENCIA, "
                + "CONTA, "
                + "GERENTE, "
                + "DATACRIACAO, "
                + "DATAEDICAO, "
                + "TELEFONE_FIXO, "
                + "TELEFONE_CELULAR)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, idusuario);
        ps.setString(2, usuario.getNome());
        ps.setString(3, usuario.getEmail());
        ps.setString(4, usuario.getSenha());
        ps.setString(5, usuario.getBanco());
        ps.setString(6, usuario.getAgencia());
        ps.setString(7, usuario.getConta());
        ps.setBoolean(8, usuario.getGerente());
        ps.setDate(9, new java.sql.Date(usuario.getDtcriacao().getTime()));
        ps.setDate(10, new java.sql.Date(usuario.getDtedicao().getTime()));
        ps.setString(11, usuario.getTelefonefixo());
        ps.setString(12, usuario.getTelefonecelular());

        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
    }

    public boolean alterar(tbUsuarioDTO usuario) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.getPreparedStatement("UPDATE USUARIO SET "
                + "NOME = ?,  "
                + "EMAIL = ?, "
                + "SENHA = ?, "
                + "BANCO = ?, "
                + "AGENCIA = ?, "
                + "CONTA = ?, "
                + "GERENTE = ?, "
                + "DATACRIACAO = ?, "
                + "DATAEDICAO = ?, "
                + "TELEFONE_FIXO = ?, "
                + "TELEFONE_CELULAR = ?)"
                + "WHERE ID = ?");

        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getSenha());
        ps.setString(4, usuario.getBanco());
        ps.setString(5, usuario.getAgencia());
        ps.setString(6, usuario.getConta());
        ps.setBoolean(7, usuario.getGerente());
        ps.setDate(8, new java.sql.Date(usuario.getDtcriacao().getTime()));
        ps.setDate(9, new java.sql.Date(usuario.getDtedicao().getTime()));
        ps.setString(10, usuario.getTelefonefixo());
        ps.setString(11, usuario.getTelefonecelular());
        ps.setInt(12, usuario.getIdusuario());

        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
    }

    public boolean excluir(tbUsuarioDTO usuario) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.getPreparedStatement("DELETE FROM USUARIO "
                + "WHERE ID = ?");
        ps.setInt(1, usuario.getIdusuario());
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
    }

    public tbUsuarioDTO getPorId(tbUsuarioDTO usuario) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM USUARIO "
                + "WHERE ID = ?");
        ps.setInt(1, usuario.getIdusuario());
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            rs.close();
            ps.close();
            super.getFechaTudo();
            return null;
        }
        tbUsuarioDTO proRet = new tbUsuarioDTO(rs.getInt("ID"),
                rs.getString("NOME"),
                rs.getString("EMAIL"),
                rs.getString("SENHA"),
                rs.getString("BANCO"),
                rs.getString("AGENCIA"),
                rs.getString("CONTA"),
                rs.getBoolean("GERENTE"),
                rs.getDate("DATACRIACAO"),
                rs.getDate("DATAEDICAO"),
                rs.getString("TELEFONE_FIXO"),
                rs.getString("TELEFONE_CELULAR"));
        rs.close();
        ps.close();
        super.getFechaTudo();
        return proRet;
    }

    public List<tbUsuarioDTO> getTodos() throws SQLException, ClassNotFoundException {
        List<tbUsuarioDTO> todosOsUsuarios = new LinkedList<tbUsuarioDTO>();

        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM USUARIO ");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            todosOsUsuarios.add(new tbUsuarioDTO(rs.getInt("ID"),
                    rs.getString("NOME"),
                    rs.getString("EMAIL"),
                    rs.getString("SENHA"),
                    rs.getString("BANCO"),
                    rs.getString("AGENCIA"),
                    rs.getString("CONTA"),
                    rs.getBoolean("GERENTE"),
                    rs.getDate("DATACRIACAO"),
                    rs.getDate("DATAEDICAO"),
                    rs.getString("TELEFONE_FIXO"),
                    rs.getString("TELEFONE_CELULAR")));
        }
        rs.close();
        ps.close();
        super.getFechaTudo();
        return todosOsUsuarios;
    }
}
