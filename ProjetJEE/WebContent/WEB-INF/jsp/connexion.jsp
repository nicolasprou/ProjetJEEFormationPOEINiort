<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		<meta charset="UTF-8">
		<title>Connexion</title>
		<link rel="stylesheet" href="css/login.css">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	</head>
	<body>
		<%@include file="header.jsp"%>
        <div class="shadow bg-white rounded card text-center">
		  <h1 class="card-header">Connexion</h1>
		  <div class="card-body">
		    <form action="Login" method="post">
			  	<div class="input-group mb-3 col-12">
				  <div class="input-group-prepend">
				    <span class="input-group-text">@</span>
				  </div>
				  <input type="email" name="mail" class="form-control" placeholder="Email">
				</div>
				
				<div class="input-group mb-3 col-12">
				  <div class="input-group-prepend">
				    <span class="input-group-text">&#128274</span>
				  </div>
				  <input type="password" name="mdp" class="form-control" placeholder="Mot de passe">
				</div>
				<div class="col-12">
			      <button type="submit" class="btn btn-primary">Se connecter</button>
			    </div>
			</form>
		  </div>
		</div>
	</body>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</html>