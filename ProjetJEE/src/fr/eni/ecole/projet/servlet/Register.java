package fr.eni.ecole.projet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import fr.eni.ecole.projet.beans.Personne;
import fr.eni.ecole.projet.utils.PersonneDAO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("email");
		String mdp = request.getParameter("mdp");
		String mdpConf = request.getParameter("mdpConf");
		String com = request.getParameter("com");
		int id_statut = 3;
		
		
		Personne personne = new Personne(nom, prenom, id_statut, mail, mdp);
		
		if(mdp.equals(mdpConf))
			{
				personne.setNom(nom);
				personne.setPrenom(prenom);
				personne.setId_statut(id_statut);
				personne.setMail(mail);
				personne.setMdp(mdp);
				
				PersonneDAO.insertUser(personne);
				
				PrintWriter out = response.getWriter();
				out.println("You have successfully registered");
			}
		else
			{
			JOptionPane.showMessageDialog(null, "Les 2 mots de passe doivent être identiques");
			RequestDispatcher rd = request.getRequestDispatcher("/inscription");
			rd.forward(request, response);
			}
	}

}
