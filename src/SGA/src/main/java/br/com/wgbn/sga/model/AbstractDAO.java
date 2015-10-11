package br.com.wgbn.sga.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Classe Abstrata para servir de base para os DAOs do projeto
 * @author Walter GAndarella
 */
public abstract class AbstractDAO {
    
    private Connection conexao = null;
    
    /**
     * Construtor padrão da classe
     */
    public AbstractDAO(){}
    
    
    /**
     * Devolve a conexão atualmente ativa.
     * Se nenhuma conexão estiver ative, cria-se uma.
     * 
     * @return a conexão ativa
     * @throws ClassNotFoundException caso a classe não seja encontrada
     * @throws SQLException caso ocorra um erro no driver de conexão
     */
    public Connection getConexao() throws ClassNotFoundException, SQLException {
        if (conexao == null){
            // implementa conexao com banco
        }
        return conexao;
    }
    
    /**
     * Cria um <code>PrepareStatement</code> com a string SQL passada
     * 
     * @param sql a String SQL informada
     * @return o PrepareStatement
     * @throws ClassNotFoundException caso a classe não seja encontrada
     * @throws SQLException caso ocorra um erro no driver de conexão
     */
    public PreparedStatement getPrepareStatement(String sql) throws ClassNotFoundException, SQLException {
        return null;
    }
    
    /**
     * Fecha a conexão ativa com o banco
     * @throws SQLException  caso ocorra um erro no driver de conexão
     */
    public void closeConexao() throws SQLException {
        if (conexao != null){
            conexao.close();
            conexao = null;
        }
    }
    
    /**
     * ### Métodos Abstratos
     */    
    
    /**
     * Insere um <code>Objeto</code> na tabela
     * O Objeto passado como parâmetro será inserido na tabela
     * 
     * @param obj o Objeto a ser inserido na tabela
     * @return TRUE em caso de sucesso ou FALSE em caso de erro
     * @throws SQLException caso ocorra um erro no driver de conexão
     * @throws ClassNotFoundException caso a classe não seja encontrada
     */
    public abstract boolean insert(Object obj) throws SQLException, ClassNotFoundException;
    
    /**
     * Atualiza um registro da tabela através do <code>Objeto</code> passado
     * O Objeto passado como parâmetro deve conter o campo ID da tabela definido para que a atualização ocorra.
     * 
     * @param obj o Objeto a ser atualizado na tabela
     * @return TRUE em caso de sucesso ou FALSE em caso de erro
     * @throws SQLException caso ocorra um erro no driver de conexão
     * @throws ClassNotFoundException caso a classe não seja encontrada
     */
    public abstract boolean update(Object obj) throws SQLException, ClassNotFoundException;
    
    /**
     * Exclui um registro da tabela através do <code>Objeto</code> passado
     * O Objeto passado como parâmetro deve conter o campo ID da tabela definido para que a exclusão ocorra.
     * 
     * @param obj o Objeto a ser excluído na tabela
     * @return TRUE em caso de sucesso ou FALSE em caso de erro
     * @throws SQLException caso ocorra um erro no driver de conexão
     * @throws ClassNotFoundException caso a classe não seja encontrada
     */
    public abstract boolean delete(Object obj) throws SQLException, ClassNotFoundException;
    
    /**
     * Busca um registro da tabela através do <code>Objeto</code> passado
     * O Objeto passado como parâmetro deve conter o campo ID da tabela definido para que a busca ocorra.
     * 
     * @param obj o Objeto a ser encontrado na tabela
     * @return um Objeto representando o registro encontrado
     * @throws SQLException caso ocorra um erro no driver de conexão
     * @throws ClassNotFoundException caso a classe não seja encontrada
     */
    public abstract Object findById(Object obj) throws SQLException, ClassNotFoundException;
    
    /**
     * Busca todos os registros da tabela
     * 
     * @return uma lista com os registros encontrados
     * @throws SQLException caso ocorra um erro no driver de conexão
     * @throws ClassNotFoundException caso a classe não seja encontrada
     */
    public abstract List findAll() throws SQLException, ClassNotFoundException;
    
    /**
     * Busca um registro da tabela que atenda a query passada
     * 
     * @param query o conjunto de instruções SQL necessarias para a busca
     * @return um Objeto representando o registro encontrado
     * @throws SQLException caso ocorra um erro no driver de conexão
     * @throws ClassNotFoundException caso a classe não seja encontrada
     */
    public abstract Object findByQuery(String query) throws SQLException, ClassNotFoundException;
    
    /**
     * Busca uma lista de registro na tabela que atendam as condições passadas na query
     * 
     * @param query o conjunto de instruções SQL necessarias para a busca
     * @return uma lista com os registros encontrados
     * @throws SQLException caso ocorra um erro no driver de conexão
     * @throws ClassNotFoundException caso a classe não seja encontrada
     */
    public abstract List findAllByQuery(String query) throws SQLException, ClassNotFoundException;
    
}
