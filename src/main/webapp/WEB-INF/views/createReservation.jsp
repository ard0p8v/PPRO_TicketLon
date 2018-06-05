<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="container">
    <hr>
    <div class="row">
        <div class="col-xs-12">
            <div class="text-primary">
                <h2>
                    Rezervování:
                </h2>
            </div>
            <br />

            <form:form method="POST" modelAttribute="reservationForm" class="form-horizontal">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="numberOfTickets">Zadejte počet rezervací:</label>
                    <div class="col-sm-10">
                        <form:input type="number" min="1" max="100" path="numberOfTickets" class="form-control" placeholder="Zadejte počet rezervací" autofocus="true"></form:input>
                        <form:errors path="numberOfTickets"></form:errors>
                    </div>
                </div>

                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2">Zadejte počet rezervací:</label>
                    <div class="col-sm-10">
                        <form:select class="form-control" id="event_id" path="event.idEvent" >
                            <c:forEach items="${eventReservation}" var="event">
                                <form:option value="${event.idEvent}" label="${event.title}"></form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>

                <br />
                <div class="form-group">
                    <div class="col-sm-offset-1 col-xs-1 pull-right">
                        <button class="btn btn-primary" type="submit">Vytvořit rezervaci</button>
                    </div>
                </div>
            </form:form>

        </div>
    </div>
</div>
