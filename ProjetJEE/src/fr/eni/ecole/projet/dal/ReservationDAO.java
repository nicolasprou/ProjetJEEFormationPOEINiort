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
  
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	private static final String SELECT_RESA = "SELECT nom, telephone_reserv, nbre_personne FROM Reservations WHERE id_Tables = ?"; 
			
	public void fermeture()
	{
		if(pstm != null)
		{
			try 
			{
				pstm.close();
			}
			catch(SQLException e)
			{
				e.getMessage();
			}
		}
	
		if( rs != null)
		{
			try 
			{
				rs.close();
			}
			catch(SQLException e)
			{
				e.getMessage();
			}
		}
		
		if( conn != null)
		{
			try 
			{
				conn.close();
			}
			catch(SQLException e)
			{
				e.getMessage();
			}
		}
	}

	public void ajouterResa(Reservation reservation)
	{
		Connection conn;
    
		try 
		{
			conn = AccesBase.getConnection();
		
			String sql = "INSERT INTO RESERVATIONS (nom, telephone_reserv, nbre_personne, id_Tables) VALUES (?,?,?,?)";
			
			pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstm.setString(1, reservation.getNom());
			pstm.setString(2, reservation.getTelephone_reserv());
			pstm.setInt(3, reservation.getNbPersonnes());
			pstm.setInt(4, reservation.getId_Table());	
			pstm.executeUpdate();

      rs = pstm.getGeneratedKeys();	
      
			if(rs.next())
			{
				reservation.setId(rs.getInt(1));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			fermeture();
		}
	}
	
	public Reservation selectResa(int id)
	{
		Reservation reserv = null;
		
		try 
		{
			conn = AccesBase.getConnection();
			pstm = conn.prepareStatement(SELECT_RESA);		
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			if(rs.next())
			{
				reserv = new Reservation(rs.getString("nom"), rs.getString("telephone_reserv"), rs.getInt("nbre_personne"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			fermeture();
		}
		
		return reserv;
	}
	
	public void deleteResa(int id)
	{
		String sql = "DELETE FROM Reservations WHERE id_Tables=?";
		
		try 
		{
			conn = AccesBase.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1,  id);
			pstm.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			fermeture();
		}
	}
}