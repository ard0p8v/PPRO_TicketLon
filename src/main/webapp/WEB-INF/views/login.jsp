<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<style>
body {
  padding-top: 40px;
  padding-bottom: 40px;
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

	<div class="container">

    	<form method="POST" action="${contextPath}/login" class="form-signin">
            <div class="form-group ${error != null ? 'has-error' : ''}">
                <div class="text-primary" style="text-align: center"><h1>TicketLon</h1></div>
                <h2 class="form-signin-text">Přihlášení</h2>

                <label for="inputEmail" class="sr-only">Uživatelské jméno</label>
                <span>${message}</span>
                <input name="username" type="text" id="inputEmail" class="form-control" placeholder="Uživatelské jméno" autofocus="true" required />

                <label for="inputPassword" class="sr-only">Heslo</label>
                <input name="password" type="password" id="inputPassword" class="form-control" placeholder="Heslo" required>
                <span>${error}</span>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Přihlásit</button>
            </div>
        </form>

    </div> 

