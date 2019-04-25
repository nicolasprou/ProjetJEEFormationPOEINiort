package fr.eni.ecole.projet.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Application;
import fr.eni.ecole.projet.bo.Reservation;
import fr.eni.ecole.projet.bo.Table;
import fr.eni.ecole.projet.dal.ReservationDAO;
import fr.eni.ecole.projet.dal.TableDAO;

@Path("/RestService")
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
	
	//http://localhost:8080/ProjetJEE/rest/RestService/reservation/{idTable}
	@GET
	@Path("/reservation/{idTable}")
	public String selectNomReservation(@PathParam("idTable") int id) 
	{
		ReservationDAO reservDAO = new ReservationDAO();
		String nomReserv = reservDAO.selectNomResa(id);

		return nomReserv;
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
	public List<Table> selectTableONC() 
	{
		List<Table> listeTables = new ArrayList<>();
		TableDAO tableDAO = new TableDAO();
		listeTables = tableDAO.selectTableONC();

		return listeTables;
	}
	
	//http://localhost:8080/ProjetJEE/rest/RestService/paiement
	@GET
	@Path("/paiement")
	public List<Table> selectTableOC() 
	{
		List<Table> listeTables = new ArrayList<>();
		TableDAO tableDAO = new TableDAO();
		listeTables = tableDAO.selectTableOC();
		
		return listeTables;
	}

	@POST
	@Path("/reservation")
	public Reservation ajouterReservation(@FormParam("nom") String nom,
							  			  @FormParam("nbrePersonne") String nbrePersonne,
							  			  @FormParam("telPersonne") String telPersonne,
							  			  @FormParam("id") String id)
	{
		int idTable = Integer.valueOf(id);
		int nbPersonne = Integer.valueOf(nbrePersonne);
		ReservationDAO reservationDAO = new ReservationDAO();
		TableDAO tableDAO = new TableDAO();
		Table table = new Table(idTable, 2);
		Reservation reservation = new Reservation(idTable, nbPersonne, nom, telPersonne);
		reservationDAO.ajouterResa(reservation);
		tableDAO.libreToResa(table);
		
		return reservation;		
	}
	
	
}
