<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="container">
    <hr>
    <div class="row">
        <div class="col-xs-12">

            <div class="text-primary"> <h2>Moje rezervace:</h2> </div>

            <br /> <a class="btn btn-primary btn-sm"  href="/events" role="button">Vytvořit novou rezervaci</a>

            <br />

            <table class="table table-striped table-bordered table-condensed" style="margin-top: 15px">
                <thead class="thead-inverse">
                <tr>
                    <th>Datum vytvoření rezervace</th>
                    <th>Název události</th>
                    <th>Počet rezervací</th>
                    <th>Akce</th>
                </tr>
                </thead>
                <c:forEach items="${listReservations}" var="reservation">
                    <tr>
                        <td><fmt:formatDate value="${reservation.added}" pattern="dd.MM.yyyy HH:mm"/></td>
                        <td><a href="<c:url value='/event/detail/${reservation.event.idEvent}' />" >${reservation.event.title}</a></td>
                        <td>${reservation.numberOfTickets}</td>
                        <td>
                            <a class="btn btn-info btn-block btn-sm" href="<c:url value='/manage/reservation/edit/${reservation.idReservation}' />" role="button">Upravit</a>
                            <a class="btn btn-danger btn-block btn-sm" href="<c:url value='/manage/reservation/remove/${reservation.idReservation}' />" role="button">Smazat</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>