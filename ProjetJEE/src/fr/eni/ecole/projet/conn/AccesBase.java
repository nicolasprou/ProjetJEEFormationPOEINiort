package fr.eni.ecole.projet.conn;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class AccesBase 
{
	public static Connection getConnection() throws SQLException 
	{
		Connection conn = null;
		InitialContext ctxJNDI;
		DataSource ds;
		
		try 
		{
			ctxJNDI = new InitialContext();
			ds = (DataSource) ctxJNDI.lookup("java:comp/env/jdbc/dsProjetEE");
			conn = ds.getConnection();
		} 
		
		catch (NamingException e) 
		{
			e.printStackTrace();
		}
			
			return conn;
	}
		
}

