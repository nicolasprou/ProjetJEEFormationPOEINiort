<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		<c:if test = "${sessionScope.mail == null}">
	         <meta http-equiv="refresh" content="0; url=accueil" />
	    </c:if>
		<title>Mon compte</title>
		<link rel="stylesheet" href="css/monCompte.css">
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	</head>
	<body>
		<%@include file="header.jsp"%>
		<h1 class="text-center">Mon compte</h1>
        <div id="accordion" class="container">
        <hr>
		  <div class="card">
		    <div class="card-header" id="headingOne">
		      <h5 class="mb-0">
		        <button class="btn btn-link" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
		          Modifier mon adresse mail
		        </button>
		      </h5>
		    </div>
		
		    <div id="collapseOne" class="collapse" aria-labelledby="headingOne" data-parent="#accordion">
		      <div class="card-body">
		        <form action="UpdateMail" method="post">
		        	<div class="input-group mb-3 col-12">
					  <div class="input-group-prepend">
					    <span class="input-group-text">Adresse actuelle</span>
					  </div>
					  <input type="text" readonly class="form-control" id="staticEmail" value="${sessionScope.mail}">
					</div>
		        	<div class="input-group mb-3 col-12">
					  <div class="input-group-prepend">
					    <span class="input-group-text">@</span>
					  </div>
					  <input type="email" name="email" class="form-control" placeholder="Email" required>
					</div>
					<div class="col-12 text-right">
				      <button type="submit" class="btn btn-primary">Modifier mon email</button>
				    </div>
		        </form>
		      </div>
		    </div>
		  </div>
		  <div class="card">
		    <div class="card-header" id="headingTwo">
		      <h5 class="mb-0">
		        <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
		          Modifier mon mot de passe
		        </button>
		      </h5>
		    </div>
		    <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordion">
		      	<div class="card-body">
			      	<form action="UpdateMdp" method="post">
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
						<div class="col-12 text-right">
					      <button type="submit" class="btn btn-primary">Modifier mon mot de passe</button>
					    </div>
			      	</form>
		    	</div>
		    </div>
		  </div>
		  <div class="card">
		    <div class="card-header" id="headingThree">
		      <h5 class="mb-0">
		        <button class="btn btn-link collapsed" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
		          Importer une image comme avatar
		        </button>
		      </h5>
		    </div>
		    <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordion">
		      <div class="card-body">
		      	<form action="./UploadPhoto" method="post" enctype="multipart/form-data">
			      	<div class="input-group mb-3 col-12">
					  <div class="input-group-prepend">
					    <span class="input-group-text" id="inputGroupFileAddon01">Image</span>
					  </div>
					  <div class="custom-file">
					    <input type="file" name="file" class="custom-file-input" id="inputGroupFile01" aria-describedby="inputGroupFileAddon01">
					    <label class="custom-file-label" for="inputGroupFile01">Choisissez une image à importer ...</label>
					  </div>
					</div>
					<div class="col-12 text-right">
				      <button type="submit" class="btn btn-primary">Importer mon image</button>
				    </div>	
				</form>
		      </div>
		    </div>
		  </div>
		  <c:choose>
	         <c:when test = "${valideMail != null }">
	            <div class="alert alert-success m-3" role="alert">
					${valideMail}  
			  	</div>
	         </c:when>	         
	         <c:when test = "${erreurMail != null }">
	            <div class="alert alert-danger m-3" role="alert">
					${erreurMail}  
			  	</div>
	         </c:when>
	         <c:when test = "${valideMdp != null }">
	            <div class="alert alert-success m-3" role="alert">
					${valideMdp}  
			  	</div>
	         </c:when>	         
	         <c:when test = "${erreurMdp != null }">
	            <div class="alert alert-danger m-3" role="alert">
					${erreurMdp}  
			  	</div>
	         </c:when>
	         <c:when test = "${validePhoto != null }">
	            <div class="alert alert-success m-3" role="alert">
					${validePhoto}  
			  	</div>
	         </c:when>	         
	         <c:when test = "${erreurPhoto != null }">
	            <div class="alert alert-danger m-3" role="alert">
					${erreurPhoto}  
			  	</div>
	         </c:when>
	      </c:choose>
		  <h1 class="text-center">Mes commentaires</h1>
		  <hr>
		  <div id="commentaires" class="row align-items-center justify-content-around">
			  <c:forEach items="${listeCom}" var="com">		    
			    <div class="col-5 m-3 card text-center">
				  <div class="card-header">
				    <h3>${com.nomPlat}</h3>
				  </div>
				  <div class="card-body">
				    ${com.contenu}
				  </div>
				  <div class="card-footer text-muted">
				    <div class="d-flex justify-content-between">
				    	<div>Noté ${com.note}/5</div>
				    	<div><fmt:formatDate value="${com.dateCom}" pattern="dd MMMM yyyy"/></div>
				    </div>
				  </div>
			  	</div>			
			  </c:forEach>
		  </div>
		</div>
	</body>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</html>