package fr.eni.ecole.projet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.ecole.projet.bo.Personne;
import fr.eni.ecole.projet.dal.PersonneDAO;

/**
 * Servlet implementation class UpdateMdp
 */
@WebServlet("/UpdateMdp")
public class UpdateMdp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String mdp = request.getParameter("mdp");
		String mdpConf = request.getParameter("mdpConf");
		
		Personne personne = new Personne();
		
		int id = (int) request.getSession().getAttribute("id");
		try
		{
			if(mdp.equals(mdpConf))
			{
				personne.setMdp(mdp);
				personne.setId(id);
				
				PersonneDAO.updateMdp(personne);
				
				request.setAttribute("valideMdp", "Vous avez bien modifié votre mot de passe.");
				RequestDispatcher rd = request.getRequestDispatcher("mon_compte");
				rd.forward(request, response);
			}
		}
		catch(Exception e)
		{
			request.setAttribute("erreurMdp", "Erreur lors de la modification du mot de passe, veuillez recommencer.");
			RequestDispatcher rd = request.getRequestDispatcher("mon_compte");
			rd.forward(request, response);
		}	
	
	}

}
