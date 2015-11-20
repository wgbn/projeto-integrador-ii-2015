/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import dto.tbClienteDTO;
import dto.tbUsuarioDTO;
import dto.tbTipoAcaoDTO;
import dto.tbAcaoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Matthew
 */
public class AcaoDAO extends daoUtil {

    private UsuarioDAO usuariodao = new UsuarioDAO();
    private TipoAcaoDAO tipoacaodao = new TipoAcaoDAO();
    private ClienteDAO clientedao = new ClienteDAO();
    
    public AcaoDAO() {
        super();
    }
    
    public boolean adicionar (tbAcaoDTO acao) throws SQLException, ClassNotFoundException{
        int idacao = super.getMaxId("SELECT MAX(id)+1 FROM ACAO");

        PreparedStatement ps = super.getPreparedStatement("INSERT INTO ACAO "
                + "(id, usuario_id , tipoacao_id , cliente_id , datainicio, datafim , descricao , local , latitude , longitude , valor , titulo , datacriacao , dataedicao) "
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
        
        ps.setInt(1, acao.getIdacao());
        ps.setInt(2, acao.getUsuarioacao().getIdusuario());
        ps.setInt(3, acao.getTipoacao().getIdtipoacao());
        ps.setInt(4, acao.getCliente().getIdcliente());
        ps.setDate(5, new java.sql.Date(acao.getDtinicio().getTime()));
        ps.setDate(6, new java.sql.Date(acao.getDtfim().getTime()));
        ps.setString(7, acao.getDescricao());
        ps.setString(8, acao.getLocal());
        ps.setDouble(9, acao.getLatitude());
        ps.setDouble(10, acao.getLongitude());
        ps.setFloat(11, acao.getValor());
        ps.setString(12, acao.getTitulo());
        ps.setDate(13, new java.sql.Date(acao.getDtcriacao().getTime()));
        ps.setDate(14, new java.sql.Date(acao.getDtedicao().getTime()));
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret >0;
    }
    
    public boolean alterar(tbAcaoDTO acao) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = super.getPreparedStatement("UPDATE ACAO SET "
                                    + "USUARIO_ID = ?, "
                                    + "TIPOACAO_ID = ?, "
                                    + "CLIENTE_ID = ?, "
                                    + "DATAINICIO = ?, "
                                    + "DATEFIM = ?, "
                                    + "DESCRICAO = ?, "
                                    + "LOCAL = ?, "
                                    + "LATITUDE = ?, "
                                    + "LONGITUDE = ?, "
                                    + "VALOR = ?, "
                                    + "TITULO = ?, "
                                    + "DATACRIACAO = ?, "
                                    + "DATAEDICAO = ?) "
                                    + "WHERE id = ?");
         
        ps.setInt(1, acao.getUsuarioacao().getIdusuario());
        ps.setInt(2, acao.getTipoacao().getIdtipoacao());
        ps.setInt(3, acao.getCliente().getIdcliente());
        ps.setDate(4, new java.sql.Date(acao.getDtinicio().getTime()));
        ps.setDate(5, new java.sql.Date(acao.getDtfim().getTime()));
        ps.setString(6, acao.getDescricao());
        ps.setString(7, acao.getLocal());
        ps.setDouble(8, acao.getLatitude());
        ps.setDouble(9, acao.getLongitude());
        ps.setFloat(10, acao.getValor());
        ps.setString(11, acao.getTitulo());
        ps.setDate(12, new java.sql.Date(acao.getDtcriacao().getTime()));
        ps.setDate(13, new java.sql.Date(acao.getDtedicao().getTime()));
        ps.setInt(14, acao.getIdacao());
             
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret >0;
    }
    public boolean excluir(tbAcaoDTO acao) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = super.getPreparedStatement("DELETE FROM ACAO "
                                    + "WHERE id = ?");
        ps.setInt(1, acao.getIdacao());
        
        int ret = ps.executeUpdate();
        ps.close();
        super.getFechaTudo();
        return ret >0;
    }
    
    public tbAcaoDTO getPorId(tbAcaoDTO acao) throws ClassNotFoundException, SQLException{
        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM ACAO "
                                    + "WHERE id = ?");
        ps.setInt(1, acao.getIdacao());
        ResultSet rs = ps.executeQuery();
        if(!rs.next()){
            rs.close();
            ps.close();
            super.getFechaTudo();
            return null;
        }
        
        tbUsuarioDTO usuario  = usuariodao.getPorId(new tbUsuarioDTO(rs.getInt("id"),null,null,null,null,null,null,null,null,null,null,null));
        tbTipoAcaoDTO tipoacao = tipoacaodao.getPorId(new tbTipoAcaoDTO(rs.getInt("id"),rs.getString("TIPO"),rs.getDate("DATACRIACAO"),rs.getDate("DATAEDICAO")));
        tbClienteDTO cliente = clientedao.getPorId(new tbClienteDTO(rs.getInt("id"),null,null,null,null,null,null,null,null));
        tbAcaoDTO acao = (new tbAcaoDTO(rs.getInt("id"),rs.getDate("DATAINICIO"),rs.getDate("DATAFIM"),rs.getString("DESCRICAO"),rs.getString("LOCAL"),rs.getDouble("LATITUDE"),rs.getDouble("LONGITUDE"),rs.getFloat("VALOR"),rs.getString("TITULO"),rs.getDate("DATACRIACAO"),rs.getDate("DATAEDICAO"),usuario,tipoacao,cliente));
        rs.close();
        ps.close();
        super.getFechaTudo();
        return acao;
    }
    
    public List<tbAcaoDTO> getTodasAsAcoes() throws ClassNotFoundException, SQLException{
        List<tbAcaoDTO> todasasacoes = new LinkedList<tbAcaoDTO>();
        
        PreparedStatement ps = super.getPreparedStatement("SELECT * FROM tbVenda ");
        ResultSet rs = ps.executeQuery();
        
        while(rs.next()){
            tbUsuarioDTO usuario  = usuariodao.getPorId(new tbUsuarioDTO(rs.getInt("id"),null,null,null,null,null,null,null,null,null,null,null));
        tbTipoAcaoDTO tipoacao = tipoacaodao.getPorId(new tbTipoAcaoDTO(rs.getInt("id"),rs.getString("TIPO"),rs.getDate("DATACRIACAO"),rs.getDate("DATAEDICAO")));
        tbClienteDTO cliente = clientedao.getPorId(new tbClienteDTO(rs.getInt("id"),null,null,null,null,null,null,null,null));
        tbAcaoDTO acao = new tbAcaoDTO(rs.getInt("id"),null,null,null,null,null,null,null,null,null,null,usuario,tipoacao,cliente));
        }
        rs.close();
        ps.close();
        super.getFechaTudo();
        return todasasacoes;
    }
    
    
}
