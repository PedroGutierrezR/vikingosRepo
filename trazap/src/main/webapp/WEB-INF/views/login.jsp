<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="assets/css/login.css" />
<!-- Font Awesome -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
  rel="stylesheet"
/>
<!-- Google Fonts -->
<link
  href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
  rel="stylesheet"
/>
<!-- MDB -->
<link
  href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.0.0/mdb.min.css"
  rel="stylesheet"
/>
<title>Login</title>
</head>
<body style="background-color: #F0F8FF;" >
	<!-- Section: Design Block -->
<section class="">
  <!-- Jumbotron -->
  <div id="main-div" class="m-5 text-center shadow-sm rounded" style="background-color: #B0C4DE; padding-top: 100px; padding-bottom: 100px;">
    <div class="container">
      <div class="row gx-lg-5 align-items-center">
        <div class="col-lg-6 mb-5 mb-lg-0">
          <h1 class="my-1 display-2 fw-bold ls-tight text-primary">
            TRAZAP
          </h1>
          <h2 class="fw-bold display-4" style="color: #F8F8FF;">Sistema de administración</h2>
          <h3 class="text-center text-primary">Proyecto Vikingos</h3>
        </div>

        <div class="col-lg-6 mb-5 mb-lg-0">
          <div class="card shadow" style="background-color: #F0F8FF;">
            <div class="card-body py-5 px-md-5">
              <form method="post" action="login">
                <!-- Email input -->
                <div class="form-outline mb-4">
                  <input type="email" id="form3Example3" class="form-control" name="username" style="background-color: #F8F8FF;"/>
                  <label class="form-label" for="form3Example3">Email address</label>
                </div>

                <!-- Password input -->
                <div class="form-outline mb-4">
                  <input type="password" id="form3Example4" class="form-control" name="password" style="background-color: #F8F8FF;"/>
                  <label class="form-label" for="form3Example4">Password</label>
                </div>

                <!-- Submit button -->
                <button type="submit" class="btn btn-primary btn-block mb-4">
                  Sign up
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <!-- Jumbotron -->
</section>

<!-- Section: Design Block -->
<!-- MDB -->
<script
  type="text/javascript"
  src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/4.0.0/mdb.min.js"
></script>
</body>
</html>