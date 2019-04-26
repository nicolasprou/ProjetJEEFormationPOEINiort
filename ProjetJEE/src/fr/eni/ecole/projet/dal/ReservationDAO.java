package fr.eni.ecole.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.ecole.projet.bo.Reservation;
import fr.eni.ecole.projet.conn.AccesBase;

public class ReservationDAO 
{

	public void ajouterResa(Reservation reservation)
	{
		Connection conn;
		try 
		{
			conn = AccesBase.getConnection();
		
			String sql = "INSERT INTO RESERVATIONS (nom, telephone_reserv, nbre_personne, id_Tables) VALUES (?,?,?,?)";
			
			PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstm.setString(1, reservation.getNom());
			pstm.setString(2, reservation.getTelephone_reserv());
			pstm.setInt(3, reservation.getNbPersonnes());
			pstm.setInt(4, reservation.getId_Table());
			
			pstm.executeUpdate();
			
			ResultSet rs = pstm.getGeneratedKeys();
			if(rs.next())
			{
				reservation.setId(rs.getInt(1));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public void deleteResa(int id)
	{
		Connection conn = null;
		String sql = "DELETE FROM Reservations WHERE id_Tables=?";
		
		try 
		{
			conn = AccesBase.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1,  id);
			pstm.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}