<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="cs">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>TicketLon - Home page</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="<spring:url value="/static/css/bootstrap.min.css" htmlEscape="true" />"
          type="text/css"/>
    <!--<link rel="stylesheet" href="<spring:url value="/static/css/bootstrap1.min.css" htmlEscape="true" />" type="text/css"/>

    <!-- Custom CSS -->
    <link rel="stylesheet" href="<spring:url value="/static/css/business-frontpage.css" htmlEscape="true" />"
          type="text/css"/>

</head>

<body>
<div class="navbar-wrapper">
    <div class="container">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">

                    <a class="navbar-brand" href="<spring:url value="/" htmlEscape="true" />">
                        <div class="text-primary">TicketLon</div>
                    </a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="<spring:url value="/events/list" htmlEscape="true" />">Události</a></li>
                        <li><a href="<spring:url value="/news/list" htmlEscape="true" />">Novinky</a></li>
                        <li><a href="<spring:url value="/places/list" htmlEscape="true" />">Místa</a></li>
                        <li><a style="margin-left: 14cm"
                               href="<spring:url value="/reservation/list" htmlEscape="true" />">Moje rezervace</a></li>
                        <li><a href="/login.jsp">
                            <div class="text-primary">Přihlásit se</div>
                        </a></li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>
    </div>
</div>

<!-- Image Background Page Header -->
<!-- Note: The background image is set within the business-casual.css file. -->
<header class="business-header">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h1 class="tagline"></h1>
            </div>
        </div>
    </div>
</header>