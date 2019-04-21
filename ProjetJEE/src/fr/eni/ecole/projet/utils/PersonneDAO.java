package fr.eni.ecole.projet.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.ecole.projet.beans.Personne;
import fr.eni.ecole.projet.conn.AccesBase;


public class PersonneDAO 
{
	public static Personne checkUser(String email, String mdp) throws SQLException 
	{
		Connection conn = null;
		
		String sql = "SELECT * FROM PERSONNE WHERE mail=? and mdp=?";
		Personne personne = null;
		
		conn = AccesBase.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, email);
        pstm.setString(2, mdp);
        ResultSet rs =pstm.executeQuery();
        
        if(rs.next())
        {
        	personne = new Personne(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),rs.getInt("id_statut"), rs.getString("mail"), rs.getString("mdp"));
        	
        }
        	
		
        return personne;
	}
	
	public static void insertUser(Personne personne)
	{
		String sql = "INSERT INTO PERSONNE (nom, prenom, id_statut, mail, mdp) values (?,?,?,?,?); ";
		PreparedStatement pstm = null;
		Connection conn = null;
		
		try 
			{
				conn = AccesBase.getConnection();
				pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				pstm.setString(1, personne.getNom());
				pstm.setString(2, personne.getPrenom());
				pstm.setInt(3, 3);
				pstm.setString(4, personne.getMail());
				pstm.setString(5, personne.getMdp());
//				pstm.setString(6, null);
//				pstm.setString(7, null);
			
				int nbLignes = pstm.executeUpdate();
				if (nbLignes==1)
				{
					ResultSet rs = pstm.getGeneratedKeys();
					if (rs.next())
					{
						int cle= rs.getInt(1);
						System.out.println(cle);
						personne.setId(cle);
					}
				}
			} 
		catch (SQLException e) 
			{
				e.printStackTrace();
			}
		
	}
}
