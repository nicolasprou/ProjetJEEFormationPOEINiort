<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<header>
	<nav id="navbarMenu" class="navbar navbar-expand-sm">
	  <a class="navbar-brand" href="accueil"><img id="logo" src="resources/logo.png" alt="logo"> 101 Recettes gourmandes</a>
	  <div id="menu" class="d-flex justify-content-between">
		<div id="listeMenu" class="navbar-nav">
		   <a class="nav-item nav-link active" href="accueil">Accueil</a>
		   <a class="nav-item nav-link" href="#">Nos Plats</a>
		   <a class="nav-item nav-link" href="#">Forum</a>
		</div>
		<div id="loginMenu" class="navbar-nav justify-content-end">
		  <c:if test = "${sessionScope.mail == null}">
	         <a class="nav-item nav-link" href="Login">Connexion</a>
		   	 <a class="nav-item nav-link" href="inscription">Inscription</a>
	      </c:if>
	      <c:if test = "${sessionScope.mail != null}">
	      	 <a class="nav-item nav-link active">Bonjour, ${sessionScope.prenom}</a>
	      	 <a class="nav-item nav-link" href="mon_compte">Mon compte</a>
	      	 <form action="Logout">
	         <a class="nav-item nav-link" href="Logout">Déconnexion</a>
	    	 </form>	
	      </c:if>
		</div>
	  </div>
	</nav>
	<img class="img-fluid" src="resources/banner.jpg" alt="Bannière des restaurants">
</header>