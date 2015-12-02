/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.tbClienteDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Matthew
 */
public class ClienteDAO extends daoUtil {

    public ClienteDAO() {
        super();
    }
    
      public boolean adicionar(tbClienteDTO cliente) throws SQLException, ClassNotFoundException {
        int idcliente = super.getMaxId("SELECT MAX(id)+1 FROM CLIENTE ");
        PreparedStatement ps = super.getPreparedStatement("INSERT INTO CLIENTE "
                + "(ID, "
                + "NOME,  "
                + "CONTATO, "
                + "EMAIL, "
                + "DATACRIACAO, "
                + "DATAEDICAO, "
                + "TELEFONE_FIXO, "
                + "TELEFONE_CELULAR, "
                + "FAX)"
                + "VALUES (?,?,?,?,?,?,?,?,?)");
        ps.setInt(1, cliente.getIdcliente());
        ps.setString(2, cliente.getNome());
        ps.setString(3, cliente.getContato());
        ps.setString(4, cliente.getEmail());
        ps.setDate(5, new java.sql.Date(cliente.getDtcriacao().getTime()));
        ps.setDate(6, new java.sql.Date(cliente.getDtedicao().getTime()));
        ps.setString(7, cliente.getTelefonefixo());
        ps.setString(8, cliente.getTelefonecelular());
        ps.setString(9, cliente.getFax());

        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
    }

    public boolean alterar(tbClienteDTO cliente) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.getPreparedStatement("UPDATE CLIENTE SET "
                + "NOME = ?,  "
                  + "CONTATO = ?, "
                + "EMAIL = ?, "
                + "DATACRIACAO = ?, "
                + "DATAEDICAO = ?, "
                + "TELEFONE_FIXO = ?, "
                + "TELEFONE_CELULAR = ?"
                + "FAX = ?)"
                + "WHERE ID = ?");

        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getContato());
        ps.setString(3, cliente.getEmail());
        ps.setDate(4, new java.sql.Date(cliente.getDtcriacao().getTime()));
        ps.setDate(5, new java.sql.Date(cliente.getDtedicao().getTime()));
        ps.setString(6,cliente.getTelefonefixo());
        ps.setString(7, cliente.getTelefonecelular());
        ps.setString(8, cliente.getFax());
        ps.setInt(8, cliente.getIdcliente());

        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
    }

    public boolean excluir(tbClienteDTO cliente) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.getPreparedStatement("DELETE FROM CLIENTE "
                + "WHERE ID = ?");
        ps.setInt(1, cliente.getIdcliente());
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret > 0;
    }

    public tbClienteDTO getPorId(tbClienteDTO cliente) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM CLIENTE "
                + "WHERE ID = ?");
        ps.setInt(1, cliente.getIdcliente());
        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            rs.close();
            ps.close();
            super.getFechaTudo();
            return null;
        }
       tbClienteDTO proRet = new tbClienteDTO(
                rs.getInt("ID"),
                rs.getString("NOME"),
                rs.getString("CONTATO"),
                rs.getString("EMAIL"),
                rs.getDate("DATACRIACAO"),
                rs.getDate("DATAEDICAO"),
                rs.getString("TELEFONE_FIXO"),
                rs.getString("TELEFONE_CELULAR"),
                rs.getString("FAX"));
                
        rs.close();
        ps.close();
        super.getFechaTudo();
        return proRet;
    }

    public List<tbClienteDTO> getTodos() throws SQLException, ClassNotFoundException {
        List<tbClienteDTO> todosOsClientes = new LinkedList<tbClienteDTO>();

        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM CLIENTE ");
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            todosOsClientes.add(new tbClienteDTO(
                rs.getInt("ID"),
                rs.getString("NOME"),
                rs.getString("CONTATO"),
                rs.getString("EMAIL"),
                rs.getDate("DATACRIACAO"),
                rs.getDate("DATAEDICAO"),
                rs.getString("TELEFONE_FIXO"),
                rs.getString("TELEFONE_CELULAR"),
                rs.getString("FAX")));
        }
        rs.close();
        ps.close();
        super.getFechaTudo();
        return todosOsClientes;
    }
    
    
}
