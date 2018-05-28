<%@ include file="/WEB-INF/layouts/includes.jsp"%>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>TicketLon - Home page</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="<spring:url value="/static/styles/bootstrap.min.css" htmlEscape="true" />" type="text/css"/>
    <!--<link rel="stylesheet" href="<spring:url value="/static/styles/bootstrap1.min.css" htmlEscape="true" />" type="text/css"/>

    <!-- Custom CSS -->
    <link rel="stylesheet" href="<spring:url value="/static/styles/business-frontpage.css" htmlEscape="true" />" type="text/css"/>

<style>
body {
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #333;
}

.form-signin {
  max-width: 330px;
  padding: 15px;
  margin: 0 auto;
}
.form-signin .form-signin-heading,
.form-signin .checkbox {
  margin-bottom: 10px;
}
.form-signin .checkbox {
  font-weight: normal;
}
.form-signin .form-control {
  position: relative;
  height: auto;
  -webkit-box-sizing: border-box;
     -moz-box-sizing: border-box;
          box-sizing: border-box;
  padding: 10px;
  font-size: 16px;
}
.form-signin .form-control:focus {
  z-index: 2;
}
.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
.form-signin-text {
  color: #ddd;
  text-align: center;
}
</style>

</head>


<body>
	<div class="container">

    	
    	<form class="form-signin">
        	<div class="text-primary" style="text-align: center"><h1>TicketLon</h1></div>
        	<h2 class="form-signin-text">Přihlášení</h2>
        	
        	<label for="inputEmail" class="sr-only">Uživatelské jméno</label>
        	<input type="email" id="inputEmail" class="form-control" placeholder="Uživatelské jméno" required autofocus>
        	
        	<label for="inputPassword" class="sr-only">Heslo</label>
        	<input type="password" id="inputPassword" class="form-control" placeholder="Heslo" required>
        	
        <button class="btn btn-lg btn-primary btn-block" type="submit">Přihlásit</button>
      </form>

    </div> 
    
</body>
