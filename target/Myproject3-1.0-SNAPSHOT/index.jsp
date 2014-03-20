<!DOCTYPE HTML>
<html>
<head>
<title>Step to Info</title>
<meta charset="UTF-8" />
<meta name="Designer" content="PremiumPixels.com">
<meta name="Author" content="$hekh@r d-Ziner, CSSJUNTION.com">
<link rel="stylesheet" type="text/css" href="css/reset.css">
<link rel="stylesheet" type="text/css" href="css/structure.css">
</head>

<body>  
<form class="box login" method="post" action="authentification">
	<fieldset class="boxBody">
	  <label>Login</label>
	  <input type="text" tabindex="1" placeholder=" Ex:Samir@steptoinfo.com"  name="login">
	  <label>Password</label>
	  <input type="password" tabindex="2" required name="pass">
	</fieldset>
	<footer>
	 
	  <input type="submit" class="btnLogin" value="Login" tabindex="4">
	</footer>
</form>
<footer id="main">
<%if(request.getAttribute("erreur")!=null){ %>
<p   style="size: 500cm ;background-color: #F7230C">Combinaison adresse &eacute;lectronique/mot de passe incorrecte
Les mots de passe Step to Info sont sensibles &agrave; la hauteur de casse. Veuillez v&eacute;rifier que la touche de verrouillage des majuscules n'est pas activ&eacute;e. </p>

<%} %>
  </footer>
</body>
</html>
