package fr.eni.ecole.projet.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fr.eni.ecole.projet.bo.Commentaire;
import fr.eni.ecole.projet.conn.AccesBase;

public class CommentaireDAO 
{
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	private static final String SELECT_BY_ID_PERSONNE = "SELECT contenu, nom, note, date_com  FROM Commentaires AS com " + 
														"INNER JOIN Asso_com_uti_plat_table AS asso ON com.id = asso.id_Commentaires " + 
														"INNER JOIN Plats AS p ON p.id = asso.id_Plats " + 
														"WHERE id_Personnes = ?";
	
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
	
	public List<Commentaire> selectByIdPersonne(int id) 
	{
		List<Commentaire> listCommentaires = new ArrayList<>();
		Commentaire com = null;
		
		try 
		{
			conn = AccesBase.getConnection();
			pstm = conn.prepareStatement(SELECT_BY_ID_PERSONNE);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			
			while(rs.next()) 
			{
				com = new Commentaire(rs.getString("contenu"), rs.getDate("date_com"), rs.getFloat("note"), rs.getString("nom"));
				listCommentaires.add(com);
			}	
		} 
		catch (SQLException e)
		{
			e.getMessage();
		}	
		finally
		{
			fermeture();
		}
		
		return listCommentaires;
	}

}
