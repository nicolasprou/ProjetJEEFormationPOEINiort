<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Inscription</title>
		<link rel="stylesheet" href="css/inscription.css">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	</head>
	<body>
		<%@include file="header.jsp"%>
        <div class="shadow bg-white rounded card text-center">
		  <h1 class="card-header">Inscription</h1>
		  <div class="card-body">
		    <form action="Register" method="post">
		    	<div class="input-group mb-3 col-12">
				  <div class="input-group-prepend">
				    <span class="input-group-text">Nom</span>
				  </div>
				  <input type="text" name="nom" class="form-control" placeholder="Nom" required>
				</div>
				
		    	<div class="input-group mb-3 col-12">
				  <div class="input-group-prepend">
				    <span class="input-group-text">Prénom</span>
				  </div>
				  <input type="text" name="prenom" class="form-control" placeholder="Prénom" required>
				</div>
				
		    	<div class="input-group mb-3 col-12">
				  <div class="input-group-prepend">
				    <span class="input-group-text">@</span>
				  </div>
				  <input type="email" name="email" class="form-control" placeholder="Email" required>
				</div>
				
		    	<div class="input-group mb-3 col-12">
				  <div class="input-group-prepend">
				    <span class="input-group-text">&#128274</span>
				  </div>
				  <input type="password" name="mdp" class="form-control" placeholder="Mot de passe" required>
				</div>
				
				<div class="input-group mb-3 col-12">
				  <div class="input-group-prepend">
				    <span class="input-group-text">&#128274</span>
				  </div>
				  <input type="password" name="mdpConf" class="form-control" placeholder="Retapez votre mot de passe" required>
				</div>
				
			  	<div class="input-group mb-3 col-12">
				  <div class="input-group-prepend">
				    <span class="input-group-text">Commentaire</span>
				  </div>
				  <input type="text" name="com" class="form-control" placeholder="Comment avez-vous connu le site ?">
				</div>

				<div class="col-12">
			      <button type="submit" class="btn btn-primary">S'inscrire</button>
			    </div>
			</form>
		  </div>
		</div>
	</body>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</html>