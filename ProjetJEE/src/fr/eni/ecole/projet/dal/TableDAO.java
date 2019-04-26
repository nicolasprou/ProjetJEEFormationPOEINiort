package fr.eni.ecole.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.ecole.projet.bo.Table;
import fr.eni.ecole.projet.conn.AccesBase;

public class TableDAO {

	public List<Table> selectAll() 
	{		
		List<Table> tables = new ArrayList<Table>();
		
		Connection conn = null;		
		
		String sql = "SELECT * FROM TABLES";
		
		try {
		conn = AccesBase.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		ResultSet rs;
			rs = pstm.executeQuery();
		
		while(rs.next())
		{
			tables.add(map(rs));
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return tables;
	}
	
	public List<Table> selectTableLibre() 
	{
		
		List<Table> tables = new ArrayList<Table>();
		
		Connection conn = null;
		
		String sql = "SELECT * FROM TABLES WHERE id_Etats_Tables = 1";
		
		try {
		conn = AccesBase.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		ResultSet rs;
			rs = pstm.executeQuery();
		
		while(rs.next())
		{
			tables.add(map(rs));
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return tables;
	}

	public List<Table> selectTableLibreouReservee() 
	{
		List<Table> tables = new ArrayList<Table>();
		
		Connection conn = null;
		
		String sql = "SELECT * FROM TABLES WHERE id_Etats_Tables = 1 OR id_Etats_Tables = 2";
		
		try {
		conn = AccesBase.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		ResultSet rs;
			rs = pstm.executeQuery();
		
		while(rs.next())
		{
			tables.add(map(rs));
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		return tables;
	}
	
	public List<Table> selectTableONC() 
	{
		List<Table> tables = new ArrayList<Table>();
		
		Connection conn = null;
		
		String sql = "SELECT * FROM TABLES WHERE id_Etats_Tables = 3";
		
		try 
		{
			conn = AccesBase.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			ResultSet rs;
				rs = pstm.executeQuery();
			
			while(rs.next())
			{
				tables.add(map(rs));
			}	
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
			
		return tables;
	}
	
	public List<Table> selectTableOC() 
	{
		List<Table> tables = new ArrayList<Table>();
		
		Connection conn = null;
			
		String sql = "SELECT * FROM TABLES WHERE id_Etats_Tables = 4";
		
		try 
		{
			conn = AccesBase.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			ResultSet rs;
				rs = pstm.executeQuery();

			while(rs.next())
			{
				tables.add(map(rs));
			}		
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
			
		return tables;
	}
  
	// Changement to id_Etats_Tables --> 1
	public void etatLibre(Table table)
	{
		Connection conn = null;
		String sql = "UPDATE TABLES SET id_Etats_Tables = 1 WHERE id = ?";
		
		try 
		{
			conn = AccesBase.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, table.getId());
			pstm.executeUpdate();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}	
	
	// Changement to id_Etats_Tables --> 2
	public void libreToResa(Table table)
	{
		Connection conn = null;
		String sql = "UPDATE TABLES SET id_Etats_Tables = 2 WHERE id = ?";
		
		try 
		{
			conn = AccesBase.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, table.getId());
			pstm.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	// Changement to id_Etats_Tables --> 3
		public void etatONC(Table table)
		{
			Connection conn = null;
			String sql = "UPDATE TABLES SET id_Etats_Tables = 3 WHERE id = ?";
			
			try 
			{
				conn = AccesBase.getConnection();
				PreparedStatement pstm = conn.prepareStatement(sql);
				
				pstm.setInt(1, table.getId());
				pstm.executeUpdate();
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		
		}
		
		// Changement to id_Etats_Tables --> 3
				public void etatOC(Table table)
				{
					Connection conn = null;
					String sql = "UPDATE TABLES SET id_Etats_Tables = 4 WHERE id = ?";
					
					try 
					{
						conn = AccesBase.getConnection();
						PreparedStatement pstm = conn.prepareStatement(sql);
						
						pstm.setInt(1, table.getId());
						pstm.executeUpdate();
					} 
					catch (SQLException e) 
					{
						e.printStackTrace();
					}
				
				}
	
	private Table map(ResultSet rs) throws SQLException 
	{	
		int id = rs.getInt("id");
		int id_statuts_table = rs.getInt("id_Etats_Tables");
		int id_Restaurants = rs.getInt("id_Restaurants");
		
		return new Table(id, id_statuts_table, id_Restaurants);
	}	
}
