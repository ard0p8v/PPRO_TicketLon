<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">

                    <a class="navbar-brand" href="/">
                        <div class="text-primary">TicketLon</div>
                    </a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a href="/events">Události</a></li>
                        <li><a href="/news">Novinky</a></li>
                        <li><a href="/types">Typy událostí</a></li>
                        <li><a href="/places">Místa událostí</a></li>
                        <security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_MANAGER')">
                        <li><a href="/users">Uživatelé</a></li>
                        </security:authorize>
                        <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN','ROLE_USER')">
                        <li><a href="/reservations">${pageContext.request.userPrincipal.name}: Rezervace</a></li>
                        </security:authorize>

                        <li><a href="/login"><div class="text-primary">Přihlásit se</div></a></li>

                        <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN','ROLE_USER')">
                        <li><a href="/logout"><div class="text-danger">Odhlásit se</div></a></li>
                        </security:authorize>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <!-- Image Background Page Header -->
        <!-- Note: The background image is set within the business-casual.css file. -->
