package fr.eni.ecole.projet.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fr.eni.ecole.projet.conn.AccesBase;

/**
 * Servlet implementation class UploadPhoto
 */
public class UploadPhoto extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    private static final String SAVE_DIR = "img";
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try {
			String uploadPath = getServletContext().getRealPath("") + SAVE_DIR;		
			File fileSaveDir = new File(uploadPath);
			int id = (int) request.getSession().getAttribute("id");

			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			Part part = request.getPart("file");
			System.out.println(part);
			String fileName = extractFileName(part);
			String cheminFichier = uploadPath + File.separator + id + fileName;
			part.write(cheminFichier);
		 
			
			Connection conn = AccesBase.getConnection();
			PreparedStatement pstm = conn.prepareStatement("update personnes set avatar_uri=? where id=3");
			
			String filePath = SAVE_DIR + File.separator + id + fileName;
			pstm.setString(1, filePath);
			
			
			pstm.executeUpdate();
		
		
		
		
		 
			
		request.setAttribute("validePhoto", "Vous avez bien modifié votre photo.");
		RequestDispatcher rd = request.getRequestDispatcher("mon_compte");
		rd.forward(request, response);
					
		 
	
		
		 
		}
		catch(Exception e)
		{
			request.setAttribute("erreurPhoto", "Erreur lors de la modification de votre photo, veuillez recommencer.");
			RequestDispatcher rd = request.getRequestDispatcher("mon_compte");
			rd.forward(request, response);
		}
			
			
			
	}  
	
	private String extractFileName (Part part)
	{
		String contentDisp = part.getHeader("content-disposition");
		String [] items = contentDisp.split(";");
		for (String s : items)
		{
			if (s.trim().startsWith("filename"))
			{
				return s.substring(s.indexOf("=")+ 2, s.length()-1);
			}
		}
		return "";
	}
	
	

}
