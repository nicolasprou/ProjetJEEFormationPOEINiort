package fr.eni.ecole.projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import fr.eni.ecole.projet.bo.Personne;
import fr.eni.ecole.projet.dal.PersonneDAO;

/**
 * Servlet implementation class UpdateMail
 */
@WebServlet("/UpdateMail")
public class UpdateMail extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			String email = request.getParameter("email");
			
			Personne personne = new Personne();
			int id = (int) request.getSession().getAttribute("id");
			personne.setMail(email);
			personne.setId(id);
			
			PersonneDAO.updateMail(personne);
			
			request.setAttribute("valideMail", "Vous avez bien modifié votre email.");
			RequestDispatcher rd = request.getRequestDispatcher("mon_compte");
			rd.forward(request, response);
		}
		catch(Exception e)
		{
			request.setAttribute("erreurMail", "Erreur lors de la modification de l'email, veuillez recommencer.");
			RequestDispatcher rd = request.getRequestDispatcher("mon_compte");
			rd.forward(request, response);
		}
		
	
	}

}
