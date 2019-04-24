package fr.eni.ecole.projet.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import fr.eni.ecole.projet.bo.Plat;
import fr.eni.ecole.projet.dal.PlatDAO;

/**
 * Servlet implementation class AjouterPlat
 */
public class AjouterPlat extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SAVE_DIR = "img";
	public static final int TAILLE_TAMPON = 10240;
    
	/**
     * @see HttpServlet#HttpServlet()
     */
    public AjouterPlat() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		RequestDispatcher rd = request.getRequestDispatcher("ajouter_plat");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
		try
		{	
			int id = (int) request.getSession().getAttribute("id");
			String uploadPath = getServletContext().getRealPath("") + SAVE_DIR;
			
			File fileSaveDir = new File(uploadPath);
			
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			
			Part part = request.getPart("image");
			System.out.println(part);
			String fileName = extractFileName(part);
			String cheminFichier = uploadPath + File.separator + id + fileName;
			part.write(cheminFichier);
			
			String nom = request.getParameter("nom");
			String description = request.getParameter("description");
			String ingredients = request.getParameter("ingredients");
			Float prix = Float.valueOf(request.getParameter("prix"));
			
			String filePath = SAVE_DIR + File.separator + id + fileName;
			PlatDAO platDAO = new PlatDAO();
			Plat plat = new Plat(nom, description, filePath, 0, prix, ingredients);
			platDAO.insertPlat(plat);
			
			request.setAttribute("valide", "Vous avez bien ajouté le plat");
			RequestDispatcher rd = request.getRequestDispatcher("ajouter_plat");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			request.setAttribute("erreur", "Une erreur s'est produite, veuillez recommencer");
			RequestDispatcher rd = request.getRequestDispatcher("ajouter_plat");
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
