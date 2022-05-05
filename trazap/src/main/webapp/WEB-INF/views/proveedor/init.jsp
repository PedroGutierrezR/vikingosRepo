<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>Trazap - Admin</title>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.0/font/bootstrap-icons.css">

<!-- <script src="https://code.jquery.com/jquery-3.5.1.js"></script> -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>

<link rel="stylesheet" href="../assets/css/cssadmin/bootstrap.min.css">
<link rel="stylesheet"
	href="../assets/css/cssadmin/font-awesome.min.css">
<link rel="stylesheet" href="../assets/css/cssadmin/aos.css">

<!-- MAIN CSS -->
<link rel="stylesheet"
	href="../assets/css/cssadmin/tooplate-gymso-style.css">
<link rel="stylesheet"
	href="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.css">
<script
	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table.min.js"></script>
<script
	src="https://unpkg.com/bootstrap-table@1.19.1/dist/bootstrap-table-locale-all.min.js"></script>
</head>
<body data-spy="scroll" data-target="#navbarNav" data-offset="50">

	<!-- MENU BAR -->
	<nav class="navbar navbar-expand-lg fixed-top">
		<div class="container">

			<a class="navbar-brand" href="#">Trazap</a>

			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ml-lg-auto">
					<li class="nav-item"><a href="#home"
						class="nav-link smoothScroll">Home</a></li>

					<li class="nav-item"><a href="#about"
						class="nav-link smoothScroll">Productos</a></li>

					<li class="nav-item"><a href="#class"
						class="nav-link smoothScroll">Proveedor</a></li>

					<li class="nav-item"><a href="#contact"
						class="nav-link smoothScroll">Trazabilidad</a></li>
				</ul>

				<ul class="social-icon ml-lg-3">
					<li><a href="#" class="fa fa-facebook"></a></li>
					<li><a href="#" class="fa fa-twitter"></a></li>
					<li><a href="#" class="fa fa-instagram"></a></li>
				</ul>
			</div>
			<div class="ms-5">
				<form action="/logout" method="get">
					<input style="border-radius: 8px;" id="btnLogout" class="btn-white px-3 py-1" type="submit"
						value="salir">
				</form>
			</div>
		</div>
	</nav>


	<!-- HERO -->
	<section
		class="hero d-flex flex-column justify-content-center align-items-center"
		id="home">

		<div class="bg-overlay"></div>

		<div class="container">
			<div class="row">

				<div class="col-lg-8 col-md-10 mx-auto col-12">
					<div class="hero-text mt-5 text-center">

						<h6 data-aos="fade-up" data-aos-delay="300">Bienvenidos a:</h6>

						<h1 class="text-white" data-aos="fade-up" data-aos-delay="500">Trazap
							- Vikingos</h1>

						<a href="#about" class="btn custom-btn bordered mt-3"
							data-aos="fade-up" data-aos-delay="700">Comencemos</a>

					</div>
				</div>

			</div>
		</div>
	</section>


	<section class="feature" id="feature">
		<div class="container">
			<h2 class="mb-3 text-white" data-aos="fade-up">Área de
				administración</h2>
		</div>
	</section>


	<!-- ABOUT -->
	<section class="about section" id="about">
		<div class="container">
			<div class="row">
				<h2 class="mb-3 text-dark" data-aos="fade-up">Productos</h2>
				<div class="container">
					<table class="table table-hover" id="idTblUsuarios"
						name="tblUsuarios">
					</table>
					<button type="button" id="idBtnAgregarUsuario"
						class="btn btn-outline-danger btn-lg">Agregar Usuario</button>
				</div>
			</div>
		</div>
	</section>


	<!-- CLASS -->
	<section class="class section" id="class">
		<div class="container">
			<div class="row">

				<div class="col-lg-12 col-12 text-center mb-5">
					<h6 data-aos="fade-up">Get A Perfect Body</h6>

					<h2 data-aos="fade-up" data-aos-delay="200">Our Training
						Classes</h2>
				</div>

				<div class="col-lg-4 col-md-6 col-12" data-aos="fade-up"
					data-aos-delay="400">
					<div class="class-thumb">
						<img src="../assets/images/class/yoga-class.jpg" class="img-fluid"
							alt="Class">

						<div class="class-info">
							<h3 class="mb-1">Yoga</h3>

							<span><strong>Trained by</strong> - Bella</span> <span
								class="class-price">$50</span>

							<p class="mt-3">Lorem ipsum dolor sit amet, consectetur
								adipiscing</p>
						</div>
					</div>
				</div>

				<div class="mt-5 mt-lg-0 mt-md-0 col-lg-4 col-md-6 col-12"
					data-aos="fade-up" data-aos-delay="500">
					<div class="class-thumb">
						<img src="../assets/images/class/crossfit-class.jpg"
							class="img-fluid" alt="Class">

						<div class="class-info">
							<h3 class="mb-1">Areobic</h3>

							<span><strong>Trained by</strong> - Mary</span> <span
								class="class-price">$66</span>

							<p class="mt-3">Lorem ipsum dolor sit amet, consectetur
								adipiscing</p>
						</div>
					</div>
				</div>

				<div class="mt-5 mt-lg-0 col-lg-4 col-md-6 col-12"
					data-aos="fade-up" data-aos-delay="600">
					<div class="class-thumb">
						<img src="../assets/images/class/cardio-class.jpg"
							class="img-fluid" alt="Class">

						<div class="class-info">
							<h3 class="mb-1">Cardio</h3>

							<span><strong>Trained by</strong> - Cathe</span> <span
								class="class-price">$75</span>

							<p class="mt-3">Lorem ipsum dolor sit amet, consectetur
								adipiscing</p>
						</div>
					</div>
				</div>

			</div>
		</div>
	</section>


	<!-- CONTACT -->
	<section class="contact section" id="contact">
		<div class="container">
			<div class="row">

				<div class="ml-auto col-lg-5 col-md-6 col-12">
					<h2 class="mb-4 pb-2" data-aos="fade-up" data-aos-delay="200">Feel
						free to ask anything</h2>

					<form action="#" method="post" class="contact-form webform"
						data-aos="fade-up" data-aos-delay="400" role="form">
						<input type="text" class="form-control" name="cf-name"
							placeholder="Name"> <input type="email"
							class="form-control" name="cf-email" placeholder="Email">

						<textarea class="form-control" rows="5" name="cf-message"
							placeholder="Message"></textarea>

						<button type="submit" class="form-control" id="submit-button"
							name="submit">Send Message</button>
					</form>
				</div>

				<div class="mx-auto mt-4 mt-lg-0 mt-md-0 col-lg-5 col-md-6 col-12">
					<h2 class="mb-4" data-aos="fade-up" data-aos-delay="600">
						Where you can <span>find us</span>
					</h2>

					<p data-aos="fade-up" data-aos-delay="800">
						<i class="fa fa-map-marker mr-1"></i> 120-240 Rio de Janeiro -
						State of Rio de Janeiro, Brazil
					</p>
					<!-- How to change your own map point
	1. Go to Google Maps
	2. Click on your location point
	3. Click "Share" and choose "Embed map" tab
	4. Copy only URL and paste it within the src="" field below
-->
					<div class="google-map" data-aos="fade-up" data-aos-delay="900">
						<iframe src="" width="1920" height="250" frameborder="0"
							style="border: 0;" allowfullscreen=""></iframe>
					</div>
				</div>

			</div>
		</div>
	</section>


	<!-- FOOTER -->
	<footer class="site-footer">
		<div class="container">
			<div class="row">

				<div class="ml-auto col-lg-4 col-md-5">
					<p class="copyright-text">Copyright &copy; 2022 Trazap</p>
				</div>

				<div
					class="d-flex justify-content-center mx-auto col-lg-5 col-md-7 col-12">
					<p class="mr-4">
						<i class="fa fa-envelope-o mr-1"></i> <a href="#">vikingos@trazap.com</a>
					</p>

					<p>
						<i class="fa fa-phone mr-1"></i> 010-020-0840
					</p>
				</div>

			</div>
		</div>
	</footer>

	<!-- Modal -->
	<div class="modal fade" id="membershipForm" tabindex="-1" role="dialog"
		aria-labelledby="membershipFormLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">

			<div class="modal-content">
				<div class="modal-header">

					<h2 class="modal-title" id="membershipFormLabel">Membership
						Form</h2>

					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<div class="modal-body">
					<form class="membership-form webform" role="form">
						<input type="text" class="form-control" name="cf-name"
							placeholder="John Doe"> <input type="email"
							class="form-control" name="cf-email"
							placeholder="Johndoe@gmail.com"> <input type="tel"
							class="form-control" name="cf-phone" placeholder="123-456-7890"
							pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required>

						<textarea class="form-control" rows="3" name="cf-message"
							placeholder="Additional Message"></textarea>

						<button type="submit" class="form-control" id="submit-button"
							name="submit">Submit Button</button>

						<div class="custom-control custom-checkbox">
							<input type="checkbox" class="custom-control-input"
								id="signup-agree"> <label
								class="custom-control-label text-small text-muted"
								for="signup-agree">I agree to the <a href="#">Terms
									&amp;Conditions</a>
							</label>
						</div>
					</form>
				</div>

				<div class="modal-footer"></div>

			</div>
		</div>
	</div>

	<!-- SCRIPTS -->
	<script src="../assets/js/jsadmin/aos.js"></script>
	<script src="../assets/js/jsadmin/smoothscroll.js"></script>
	<script src="../assets/js/jsadmin/custom.js"></script>
	<script type="text/javascript" src="../assets/js/producto.js"></script>
</body>
</html>