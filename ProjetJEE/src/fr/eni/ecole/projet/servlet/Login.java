package fr.eni.ecole.projet.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.ecole.projet.bo.Personne;
import fr.eni.ecole.projet.dal.PersonneDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher rd = request.getRequestDispatcher("connexion");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{		
		String mail = request.getParameter("mail");
		String mdp = request.getParameter("mdp");
		
		PersonneDAO pdao = new PersonneDAO();
		try 
		{
			Personne personne = PersonneDAO.checkUser(mail, mdp);
			if (personne != null)
			{
				HttpSession session = request.getSession();
				session.setAttribute("mail", mail);
				session.setAttribute("id", personne.getId());
				session.setAttribute("nom", personne.getNom());
				session.setAttribute("prenom", personne.getPrenom());
				session.setAttribute("id_statut", personne.getId_statut());
			
				RequestDispatcher rd = request.getRequestDispatcher("accueil");
				rd.forward(request, response);
			}		
			else 
			{
				RequestDispatcher rd = request.getRequestDispatcher("connexion");
				rd.forward(request, response);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
	}

	

}
