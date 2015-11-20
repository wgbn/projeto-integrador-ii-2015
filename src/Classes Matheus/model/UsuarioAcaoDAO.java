/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.tbUsuarioDTO;
import dto.tbAcaoDTO;
import dto.tbClienteDTO;
import dto.tbTipoAcaoDTO;
import dto.tbUsuarioAcaoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Matthew
 */
public class UsuarioAcaoDAO extends daoUtil{
    private UsuarioDAO usuariodao = new UsuarioDAO();
    private AcaoDAO acaodao = new AcaoDAO();
    public UsuarioAcaoDAO() {
        super();
    }
    
    public boolean adicionar (tbUsuarioAcaoDTO usuarioacao) throws SQLException, ClassNotFoundException{
        int idusuarioacao = super.getMaxId("SELECT MAX(idusuarioacao)+1 FROM USUARIO_ACAO");

        PreparedStatement ps = super.getPreparedStatement("INSERT INTO USUARIO_ACAO "
                + "(usuario_id, acao_id, confirmado, lider , datacadastro , dataedicao) "
                + " VALUES (?,?,?,?,?,?)");
        
        ps.setInt(1, usuarioacao.getUsuario().getIdusuario());
        ps.setInt(2, usuarioacao.getAcao().getIdacao());
        ps.setBoolean(3, usuarioacao.getConfirmado());
        ps.setBoolean(4, usuarioacao.getLider());
        ps.setDate(5, new java.sql.Date(usuarioacao.getDtcadastro().getTime()));
        ps.setDate(6,new java.sql.Date(usuarioacao.getDtedicao().getTime()));
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        
        return ret >0;
    }
    
    public boolean alterar(tbUsuarioAcaoDTO usuarioacao) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = super.getPreparedStatement("UPDATE USUARIO_ACAO SET "
                                    + "CONFIRMADO = ?, "
                                    + "LIDER = ?, "
                                    + "DATACADASTRO = ?, "
                                    + "DATAEDICAO = ? )"
                                    + "WHERE USUARIO_ID = ? AND ACAO_ID = ?");
       
        ps.setBoolean(1, usuarioacao.getConfirmado());
        ps.setBoolean(2, usuarioacao.getLider());
        ps.setDate(3, new java.sql.Date(usuarioacao.getDtcadastro().getTime()));
        ps.setDate(4,new java.sql.Date(usuarioacao.getDtedicao().getTime()));
        ps.setInt(5, usuarioacao.getUsuario().getIdusuario());
        ps.setInt(6, usuarioacao.getAcao().getIdacao());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret >0;
    }
    public boolean excluir(tbUsuarioAcaoDTO usuarioacao) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = super.getPreparedStatement("DELETE FROM USUARIO_ACAO "
                                    + "WHERE USUARIO_ID = ? AND ACAO_ID = ?");
        ps.setInt(1, usuarioacao.getUsuario().getIdusuario());
        ps.setInt(2, usuarioacao.getAcao().getIdacao());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret >0;
    }
    
    public tbUsuarioAcaoDTO getPorId(tbUsuarioAcaoDTO usuarioacao) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM USUARIO_ACAO "
                                    + "WHERE USUARIO_ID = ? AND ACAO_ID = ?");
        ps.setInt(1, usuarioacao.getUsuario().getIdusuario());
        ps.setInt(2, usuarioacao.getAcao().getIdacao());
        ResultSet rs = ps.executeQuery();
        if(!rs.next()){
            rs.close();
            ps.close();
            super.getFechaTudo();
            return null;
        }
        
        tbUsuarioDTO usuario = usuariodao.getPorId(new tbUsuarioDTO(rs.getInt("id"),rs.getString("NOME"), rs.getString("EMAIL"), rs.getString("SENHA"), rs.getString("BANCO"), rs.getString("AGENCIA"), rs.getString("CONTA"), rs.getBoolean("GERENTE"), rs.getDate("DATACRIACAO"), rs.getDate("DATAEDICAO"),rs.getString("TELEFONE_FIXO"), rs.getString("TELEFONE_CELULAR")));
        tbAcaoDTO acao = acaodao.getPorId(new tbAcaoDTO(rs.getInt("id"),rs.getDate("DATAINICIO"),rs.getDate("DATAFIM"),rs.getString("DESCRICAO"),rs.getString("LOCAL"),rs.getDouble("LATITUDE"),rs.getDouble("LONGITUDE"),rs.getFloat("VALOR"),rs.getString("TITULO"),rs.getDate("DATACRIACAO"),rs.getDate("DATAEDICAO"),usuario,tipoacao,cliente)));
        
        rs.close();
        ps.close();
        super.getFechaTudo();
        return acao;
    }
    
    public List<tbUsuarioAcaoDTO> getTodasAsVendas() throws ClassNotFoundException, SQLException{
        List<tbUsuarioAcaoDTO> todososUsuariosAcao = new LinkedList<tbUsuarioAcaoDTO>();
        
        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM USUARIO_ACAO ");
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            tbUsuarioDTO usuario  = usuariodao.getPorId(new tbUsuarioDTO(rs.getInt("id"),null,null,null,null,null,null,null,null,null,null,null));
            tbAcaoDTO acao = new tbAcaoDTO(rs.getInt("id"),null,null,null,null,null,null,null,null,null,null,usuario,tipoacao,cliente));
        }
        rs.close();
        ps.close();
        super.getFechaTudo();
        return todososUsuariosAcao;
    }
    
}
