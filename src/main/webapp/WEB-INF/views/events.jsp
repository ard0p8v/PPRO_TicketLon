<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="container">
    <hr>
    <div class="row">
        <div class="col-xs-12">

            <div class="text-primary"> <h2>Seznam událostí:</h2> </div>

            <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')">
            <br /> <a class="btn btn-primary btn-sm"  href="/manage/event/create" role="button">Vytvořit událost</a>
            </security:authorize>

            <br />

            <table class="table table-striped table-bordered" style="margin-top: 15px">
                <thead class="thead-inverse">
                <tr>
                    <th>Datum</th>
                    <th>Název</th>
                    <th>Délka</th>
                    <th>Cena</th>
                    <th>Typ události</th>
                    <th>Místo konání</th>
                    <th>Počet volných vstupenek</th>
                    <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN','ROLE_USER')">
                    <th>Rezervovat</th>
                    </security:authorize>
                    <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')">
                    <th>Akce</th>
                    </security:authorize>
                </tr>
                </thead>
                <c:forEach items="${listEvents}" var="event">
                    <tr>
                        <td><fmt:formatDate value="${event.date}" pattern="dd.MM.yyyy HH:mm"/></td>
                        <td><a href="<c:url value='/event/detail/${event.idEvent}' />" >${event.title}</a></td>
                        <td>${event.duration}min.</td>
                        <td>${event.priceOfOneTicket}Kč</td>
                        <td><a href="<c:url value='/type/detail/${event.type.idType}' />" >${event.type.name}</a></td>
                        <td><a href="<c:url value='/place/detail/${event.place.idPlace}' />" >${event.place.name}</a></td>
                        <td>${event.numberOfFreeTickets}</td>
                        <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN','ROLE_USER')">
                        <td><a class="btn btn-default btn-md" href="<c:url value='/events/${event.idEvent}/manage/reservation/create' />">Rezervovat</a></td>
                        </security:authorize>
                        <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')">
                        <td>
                            <a class="btn btn-info btn-block btn-sm" href="<c:url value='/manage/event/edit/${event.idEvent}' />" role="button">Upravit</a>
                            <a class="btn btn-danger btn-block btn-sm" href="<c:url value='/manage/event/remove/${event.idEvent}' />" role="button">Smazat</a>
                        </td>
                        </security:authorize>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>