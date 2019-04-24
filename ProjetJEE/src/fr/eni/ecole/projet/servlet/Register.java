package fr.eni.ecole.projet.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import fr.eni.ecole.projet.bo.Personne;
import fr.eni.ecole.projet.dal.PersonneDAO;

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
		String avatar = null;
		int id_statut = 3;
		
		
		Personne personne = new Personne(nom, prenom, id_statut, mail, mdp);
		
		if(mdp.equals(mdpConf))
		{
			personne.setNom(nom);
			personne.setPrenom(prenom);
			personne.setId_statut(id_statut);
			personne.setMail(mail);
			personne.setMdp(mdp);
			personne.setAvatar_uri(avatar);
			personne.setCom(com);
			
			PersonneDAO.insertUser(personne);
			
			HttpSession session = request.getSession();
			session.setAttribute("id", personne.getId());
			session.setAttribute("mail", mail);
			session.setAttribute("nom", nom);
			session.setAttribute("prenom", prenom);
			session.setAttribute("id_statut", id_statut);
		
			RequestDispatcher rd = request.getRequestDispatcher("accueil");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("erreurPassword", "Votre mot de passe doit être identique !");
			RequestDispatcher rd = request.getRequestDispatcher("inscription");
			rd.forward(request, response);
		}
	}
}
