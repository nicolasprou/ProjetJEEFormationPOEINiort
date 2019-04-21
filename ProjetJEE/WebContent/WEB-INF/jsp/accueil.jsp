<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
		<meta http-equiv="Pragma" content="no-cache" />
		<meta http-equiv="Expires" content="0" />
		<meta charset="UTF-8">
		<title>Accueil</title>
		<link rel="stylesheet" href="css/style.css">
		<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
	</head>
	<body>
		<%@include file="header.jsp"%>
        <nav id="lesResto">
          <div class="nav nav-tabs nav-fill" id="nav-tab" role="tablist">
            <a class="tabResto nav-item nav-link active" id="nav-home-tab" data-toggle="tab" href="#nav-home" role="tab" aria-controls="nav-home" aria-selected="true">Restaurant de Rennes</a>
            <a class="tabResto nav-item nav-link" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">Restaurant de Nantes</a>
            <a class="tabResto nav-item nav-link" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">Restaurant de Brest</a>
          </div>
        </nav>
        <div class="tab-content" id="nav-tabContent">
          <div class="tab-pane fade show active" id="nav-home" role="tabpanel" aria-labelledby="nav-home-tab">
            <h1 class="text-center">101 Recettes Gourmandes de Rennes</h1>
            <hr>
            <div class="d-flex align-items-center">
            	<div class="col-6 text-center">
	            	<img class="img-fluid" src="resources/resto.jpg" alt="Photo du restaurant">
	            </div>
	            <div class="col-4">
	            	<h2 class="text-center">Description du restaurant</h2>
	            	<hr>
	            	<p>Ce restaurant est équipé de 15 tables. Il est situé dans le centre de Rennes.</p>
	            	<p>Vous pouvez-vous la géolocalisation de ce restaurant grâce à Google Map ci-dessous</p>
	            </div>
            </div>
            <hr>
            <div class="col-12 embed-responsive embed-responsive-16by9">
            	<iframe class="embed-responsive-item" src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d10655.79647957114!2d-1.688970609751669!3d48.1112172175398!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x480ede34460dbebd%3A0x94763c099a30dddf!2sCentre%2C+35000+Rennes!5e0!3m2!1sfr!2sfr!4v1555785876114!5m2!1sfr!2sfr" allowfullscreen></iframe>
			</div>  
          </div>
          <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">
            <h1 class="text-center">101 Recettes Gourmandes de Nantes</h1>
            <hr>
            <div class="d-flex align-items-center">
            	<div class="col-6 text-center">
	            	<img class="img-fluid" src="resources/resto.jpg" alt="Photo du restaurant">
	            </div>
	            <div class="col-4">
	            	<h2 class="text-center">Description du restaurant</h2>
	            	<hr>
	            	<p>Ce restaurant est équipé de 10 tables. Il est situé dans le centre de Nantes.</p>
	            	<p>Vous pouvez-vous la géolocalisation de ce restaurant grâce à Google Map ci-dessous</p>
	            </div>
            </div>
            <hr>
            <div class="col-12 embed-responsive embed-responsive-16by9">
            	<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d10840.22735592476!2d-1.564453110725367!3d47.21547014159704!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4805eea663672689%3A0x4c1e6fb7f16cccad!2sCentre-Ville%2C+Nantes!5e0!3m2!1sfr!2sfr!4v1555788038453!5m2!1sfr!2sfr" allowfullscreen></iframe>
			</div>  
          </div>
          <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">
            <h1 class="text-center">101 Recettes Gourmandes de Brest</h1>
            <hr>
            <div class="d-flex align-items-center">
            	<div class="col-6 text-center">
	            	<img class="img-fluid" src="resources/resto.jpg" alt="Photo du restaurant">
	            </div>
	            <div class="col-4">
	            	<h2 class="text-center">Description du restaurant</h2>
	            	<hr>
	            	<p>Ce restaurant sera équipé de 10 tables. Il est situé dans le centre de Brest.</p>
	            	<p>Vous pouvez-vous la géolocalisation de ce restaurant grâce à Google Map ci-dessous</p>
	            </div>
            </div>
            <hr>
            <div class="col-12 embed-responsive embed-responsive-16by9">
            	<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d84752.07281716053!2d-4.569640345509937!3d48.40850075129713!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x4816bbe1d9925b93%3A0xc6488358179c30ab!2sBrest!5e0!3m2!1sfr!2sfr!4v1555788314318!5m2!1sfr!2sfr" allowfullscreen></iframe>
			</div> 
          </div>
        </div>
	</body>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="bootstrap/js/bootstrap.min.js"></script>
</html>