<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Ajouter un plat</title>
		<link rel="stylesheet" href="css/ajouterPlat.css">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	</head>
	<body>
		<%@include file="header.jsp"%>
        <div class="shadow bg-white rounded card text-center">
		  <h1 class="card-header">Ajouter un plat</h1>
		  <div class="card-body">
		    <form>
		    	<div class="input-group mb-3 col-12">
				  <div class="input-group-prepend">
				    <span class="input-group-text">Nom</span>
				  </div>
				  <input type="text" class="form-control" placeholder="Nom" required>
				</div>
				
		    	<div class="input-group mb-3 col-12">
				  <div class="input-group-prepend">
				    <span class="input-group-text">Description</span>
				  </div>
				  <textarea class="form-control" aria-label="With textarea" placeholder="Décrivez le plat"></textarea>
				</div>
				
				<div class="input-group mb-3 col-12">
				  <div class="input-group-prepend">
				    <span class="input-group-text">Ingrédients</span>
				  </div>
				  <textarea class="form-control" aria-label="With textarea" placeholder="Quels sont les ingrédients ?"></textarea>
				</div>
				
		    	<div class="input-group mb-3 col-12">
				  <div class="input-group-prepend">
				    <span class="input-group-text">€</span>
				  </div>
				  <input type="text" class="form-control" placeholder="Prix" required>
				</div>

				<div class="input-group mb-3 col-12">
				  <div class="input-group-prepend">
				    <span class="input-group-text" id="inputGroupFileAddon01">Image</span>
				  </div>
				  <div class="custom-file">
				    <input type="file" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
				    <label class="custom-file-label" for="inputGroupFile01">Choisissez une image à importer ...</label>
				  </div>
				</div>
				<div class="col-12">
			      <button type="submit" class="btn btn-primary">Ajouter le plat</button>
			    </div>
			</form>
		  </div>
		</div>
	</body>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</html>