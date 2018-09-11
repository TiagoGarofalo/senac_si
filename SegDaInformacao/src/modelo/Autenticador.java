/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import persistencia.ConexaoBanco;

/**
 *
 * @author Aluno
 */
public class Autenticador {
    
    public Usuario autentica(String login, String senha){
        Usuario usr=null;
        
        
        Connection conn = ConexaoBanco.getConnection();
		Statement stmt = ConexaoBanco.getStatement(conn);
		ResultSet resultado = null;
		String query = "SELECT login, senha, nivel FROM usuario WHERE login= '" + login + "' and senha= md5('" + senha +"')";
		try {
			resultado = stmt.executeQuery(query);
			if (resultado.next()) {
				usr = new Usuario();
                                usr.setLogin(login);
                                usr.setSenha(senha);
                                int nivelAcesso=resultado.getInt("nivel");
                                usr.setNivelAcesso(nivelAcesso);
			}else {
		}
			
		}catch (SQLException e) {
			System.out.println("Erro ao executar Query que autentica os usuários!");
		}finally {
			ConexaoBanco.closeResultSet(resultado);
			ConexaoBanco.closeStatement(stmt);
			ConexaoBanco.closeConnection(conn);
		}
        
        
        
        return usr;
    }
    
    
}
