package fr.eni.ecole.projet.dal;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;

import fr.eni.ecole.projet.bo.Table;

@Path("/RestService")
@ApplicationPath("/rest")
public class RestService extends Application
{
	//http://localhost:8080/ProjetJEE/rest/RestService/recapitulatif
	@GET
	@Path("/recapitulatif")
	public List<Table> listerTable() 
	{
		List<Table> listeTables = new ArrayList<>();
		TableDAO tableDAO = new TableDAO();
		listeTables = tableDAO.selectAll();

		return listeTables;
	}
	
	//http://localhost:8080/ProjetJEE/rest/RestService/reservation
	@GET
	@Path("/reservation")
	public List<Table> selectTableLibre() 
	{
		List<Table> listeTables = new ArrayList<>();
		TableDAO tableDAO = new TableDAO();
		listeTables = tableDAO.selectTableLibre();

		return listeTables;
	}
	
	//http://localhost:8080/ProjetJEE/rest/RestService/occupation
	@GET
	@Path("/occupation")
	public List<Table> selectTableLibreOuReservee() 
	{
		List<Table> listeTables = new ArrayList<>();
		TableDAO tableDAO = new TableDAO();
		listeTables = tableDAO.selectTableLibreouReservee();

		return listeTables;
	}
	
	//http://localhost:8080/ProjetJEE/rest/RestService/commande
		@GET
		@Path("/commande")
		public List<Table> selectTableONCetOC() 
		{
			List<Table> listeTables = new ArrayList<>();
			TableDAO tableDAO = new TableDAO();
			listeTables = tableDAO.selectTableONCetOC();

			return listeTables;
		}
}
