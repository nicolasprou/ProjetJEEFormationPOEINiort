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

	public List<Table> selectAll() {
		
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
	
	public List<Table> selectTableLibre() {
		
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

	public List<Table> selectTableLibreouReservee() {
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
	
	public List<Table> selectTableONCetOC() {
	List<Table> tables = new ArrayList<Table>();
		
		Connection conn = null;
		
		
		String sql = "SELECT * FROM TABLES WHERE id_Etats_Tables = 3 OR id_Etats_Tables = 4";
		
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
	
	
		private Table map(ResultSet rs) throws SQLException {
		
		int id = rs.getInt("id");
		int id_statuts_table = rs.getInt("id_Etats_Tables");
		
		return new Table(id, id_statuts_table);
	}

			
	
}
