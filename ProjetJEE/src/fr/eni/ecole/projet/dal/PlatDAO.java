package fr.eni.ecole.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.ecole.projet.bo.Personne;
import fr.eni.ecole.projet.bo.Plat;
import fr.eni.ecole.projet.conn.AccesBase;

public class PlatDAO 
{
	private Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	
	private static final String INSERT_PLAT = "INSERT INTO Plats (nom, description_plat, image_plat, nbre_commande, prix, ingredients)"
											+ "VALUES (?,?,?,?,?,?)";
	
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
	
	public void insertPlat(Plat plat)
	{
			try 
			{
				conn = AccesBase.getConnection();
				pstm = conn.prepareStatement(INSERT_PLAT, Statement.RETURN_GENERATED_KEYS);
				
				pstm.setString(1, plat.getNom());
				pstm.setString(2, plat.getDescription_plat());
				pstm.setString(3, plat.getImage_plat());
				pstm.setInt(4, plat.getNbre_commande());
				pstm.setFloat(5, plat.getPrix());
				pstm.setString(6, plat.getIngredients());
			
				int nbLignes = pstm.executeUpdate();
				if (nbLignes==1)
				{
					ResultSet rs = pstm.getGeneratedKeys();
					if (rs.next())
					{
						int cle= rs.getInt(1);
						plat.setId(cle);
					}
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

}
