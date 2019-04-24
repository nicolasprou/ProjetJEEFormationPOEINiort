package fr.eni.ecole.projet.dal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.http.Part;

import fr.eni.ecole.projet.bo.Personne;
import fr.eni.ecole.projet.conn.AccesBase;
import sun.security.provider.certpath.ResponderId;


public class PersonneDAO 
{
	public static Personne checkUser(String email, String mdp) throws SQLException 
	{
		Connection conn = null;
		
		String sql = "SELECT * FROM PERSONNES WHERE email=? and mdp=?";
		Personne personne = null;
		
		conn = AccesBase.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, email);
        pstm.setString(2, mdp);
        ResultSet rs =pstm.executeQuery();
        
        if(rs.next())
        {
        	personne = new Personne(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),rs.getInt("id_statuts"), rs.getString("email"), rs.getString("mdp"));
        	
        }
        	
		
        return personne;
	}
	
	public static void insertUser(Personne personne)
	{
		String sql = "INSERT INTO PERSONNES (nom, prenom, email, mdp, commentaire, id_statuts) values (?,?,?,?,?,?); ";
		PreparedStatement pstm = null;
		Connection conn = null;
		
		try 
		{						
			conn = AccesBase.getConnection();
			pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			pstm.setString(1, personne.getNom());
			pstm.setString(2, personne.getPrenom());
			pstm.setString(3, personne.getMail());
			pstm.setString(4, personne.getMdp());
			pstm.setString(5, personne.getCom());
			pstm.setInt(6, 3);
		
			int nbLignes = pstm.executeUpdate();
			if (nbLignes==1)
			{
				ResultSet rs = pstm.getGeneratedKeys();
				if (rs.next())
				{
					int cle= rs.getInt(1);
					personne.setId(cle);
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
	}

	public static void updateMail(Personne personne)
	{
		String sql="UPDATE PERSONNES SET email=? WHERE id=?";
		PreparedStatement pstm = null;
		Connection conn = null;
		
		try {
			conn = AccesBase.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, personne.getMail());
			pstm.setInt(2, personne.getId());
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void updateMdp(Personne personne)
	{
		String sql="UPDATE PERSONNES SET mdp=? WHERE id=?";
		PreparedStatement pstm = null;
		Connection conn = null;
		
		try {
			conn = AccesBase.getConnection();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, personne.getMdp());
			pstm.setInt(2, personne.getId());
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
//	@SuppressWarnings("unused")
//	public static void updatePhoto (Personne personne) throws SQLException
//	{
//		 String sql = "INSERT INTO PERSONNES (avatar_uri) values(?) WHERE id=?";
//		 PreparedStatement pstm = null;
//		 Connection conn = null;
//		 
//		 
//		 conn = AccesBase.getConnection();
//		 pstm = conn.prepareStatement(sql);
//			
//		 pstm.setBinaryStream(1, fis);
//		 pstm.setInt(2, personne.getId());
//		 pstm.executeUpdate();
//		 
//		 
//		}
	 
				
} 
		 
		 
			 
		 
	
	
