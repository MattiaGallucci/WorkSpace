

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <title>SwaGGed | Accedi</title>

      <link rel="shortcut icon" href="<%=request.getContextPath()%>/assets/images/favicon.ico" />
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/libs.min.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/socialv.css?v=4.0.0">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/remixicon/fonts/remixicon.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/vanillajs-datepicker/dist/css/datepicker.min.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/font-awesome-line-awesome/css/all.min.css">
      <link rel="stylesheet" href="<%=request.getContextPath()%>/assets/vendor/line-awesome/dist/line-awesome/css/line-awesome.min.css">

  </head>
  <body class=" ">
    <!-- loader Start -->
    <div id="loading">
          <div id="loading-center">
          </div>
    </div>
    <!-- loader END -->
    
      <div class="wrapper">
    <section class="sign-in-page">
        <div id="container-inside">
            <div id="circle-small"></div>
            <div id="circle-medium"></div>
            <div id="circle-large"></div>
            <div id="circle-xlarge"></div>
            <div id="circle-xxlarge"></div>
        </div>
        <div class="container p-0">
            <div class="row no-gutters">
                <div class="col-md-6 text-center pt-5">
                    <div class="sign-in-detail text-white">
                        <a class="sign-in-logo mb-5" href="#"><img src="<%=request.getContextPath()%>/assets/images/logo-full.png" class="img-fluid" alt="logo"></a>
                    </div>
                </div>
                <div class="col-md-6 bg-white pt-5 pt-5 pb-lg-0 pb-5">
                    <div class="sign-in-from">
                        <h1 class="mb-0">Accedi</h1>
                        <form class="mt-4" action="login" method="post">
                            <div class="form-group">
                                <%
                                    String error = (String) session.getAttribute("error");
                                    if (error != null) {
                                %>
                                <p style="color: #ff9b8a;" id="error-login">Username e/o password non validi</p>
                                <%
                                        session.removeAttribute("error");
                                    }
                                %>
                                <label class="form-label" for="username">Username</label>
                                <input type="text" class="form-control mb-0" id="username" name ="username" placeholder="Inserisci username">
                            </div>
                            <div class="form-group">
                                <label class="form-label" for="password">Password</label>
                                <input type="password" class="form-control mb-0" id="password" name ="password" placeholder="Password">
                            </div>
                            <div class="d-inline-block w-100">
                                <button type="submit" class="btn btn-primary float-end">Accedi</button>
                            </div>
                            <div class="sign-info">
                                <span class="dark-color d-inline-block line-height-2">Non hai un account? <a href="<%=request.getContextPath()%>/registrazione.jsp">Registrati</a></span>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </section>   
      </div>

    <!-- Backend Bundle JavaScript -->
    <script src="<%=request.getContextPath()%>/assets/js/libs.min.js"></script>
    <!-- Slider JavaScript -->
    <script src="<%=request.getContextPath()%>/assets/js/slider.js"></script>
    <!-- Masonry JavaScript -->
    <script src="<%=request.getContextPath()%>/assets/js/masonry.pkgd.min.js"></script>
    <!-- SweetAlert JavaScript -->
    <script src="<%=request.getContextPath()%>/assets/js/enchanter.js"></script>
    <!-- SweetAlert JavaScript -->
    <script src="<%=request.getContextPath()%>/assets/js/sweetalert.js"></script>
    <!-- Weather Chart JavaScript -->
    <script src="<%=request.getContextPath()%>/assets/js/charts/weather-chart.js"></script>
    <!-- App JavaScript -->
    <script src="<%=request.getContextPath()%>/assets/js/app.js"></script>
    <!-- Datepicker JavaScript -->
    <script src="<%=request.getContextPath()%>/assets/vendor/vanillajs-datepicker/dist/js/datepicker.min.js"></script>
    <!-- Lottie JavaScript -->
    <script src="<%=request.getContextPath()%>/assets/js/lottie.js"></script>

  </body>
</html>