<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="" />
    <meta name="keywords" content="" />
	<title>SwaGGed</title>
    <link rel="icon" href="images/fav.png" type="image/png" sizes="16x16"> 
    
    <link rel="stylesheet" href="css/main.min.css">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/color.css">
    <link rel="stylesheet" href="css/responsive.css">

</head>
<body>
<!--<div class="se-pre-con"></div>-->
<div class="theme-layout">
	<div class="container-fluid pdng0">
		<div class="row merged">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="land-featurearea">
					<div class="land-meta">
						<h1>SwaGGed</h1>
						<p>
							Winku is free to use for as long as you want with two active projects.
						</p>
						<div class="friend-logo">
							<span><img src="images/wink.png" alt=""></span>
						</div>
						<a href="#" title="" class="folow-me">Follow Us on</a>
					</div>	
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="login-reg-bg">
					<div class="log-reg-area sign">
						<h2 class="log-title">Login</h2>

						<form action="login" method="post">
							<div class="form-group">
								<input type="text" id="usernameLogin" name="usernameLogin" required/>
							  <label class="control-label" >Username</label><i class="mtrl-select"></i>
							</div>
							<div class="form-group">
								<input type="password" id="passwordLogin" name="passwordLogin" required/>
							  <label class="control-label" >Password</label><i class="mtrl-select"></i>
							</div>

							<a href="#" title="" class="forgot-pwd">Forgot Password?</a>
							<div class="submit-btns">
								<button class="mtr-btn signin" type="submit"><span>Login</span></button>
								<button class="mtr-btn signup" type="button"><span>Registrati</span></button>
							</div>
						</form>
					</div>
					<div class="log-reg-area reg">
						<h2 class="log-title">Registrati</h2>

						<form action="registrazione" id="registrazione" method="post">
							<input type="hidden" name="mode" value="register">
							<div class="form-group">	
							  <input type="text" required="required" name="email" id="email"/>
							  <label class="control-label" >Email</label><i class="mtrl-select"></i>
							</div>
							<div class="form-group">	
							  <input type="text" required="required" id="username" name="username"/>
							  <label class="control-label" >Username</label><i class="mtrl-select"></i>
							</div>
							<div class="form-group">	
							  <input type="password" required="required" id="password" name="password"/>
							  <label class="control-label" >Password</label><i class="mtrl-select"></i>
							</div>
							<div class="form-group">
								<input type="password" required="required" id="passwordCheck" name="passwordCheck"/>
								<label class="control-label" >Ripeti Password</label><i class="mtrl-select"></i>
							</div>

							<a href="#" title="" class="already-have">Ho gi&agrave; un account</a>
							<div class="submit-btns">
								<button class="mtr-btn signup" type="submit"><span>Registrati</span></button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
	
	<script data-cfasync="false" src="../../cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script><script src="js/main.min.js"></script>
	<script src="js/script.js"></script>

</body>	

</html>