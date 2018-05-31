<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="container">
    <hr>
    <div class="row">
        <div class="col-xs-12">
            <div class="text-primary">
                <h2>
                    Editace události:
                </h2>
            </div>
            <br />

            <form:form method="POST" modelAttribute="eventForm" class="form-horizontal">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="title">Název:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="title" class="form-control" placeholder="Název události" autofocus="true"></form:input>
                        <form:errors path="title"></form:errors>
                    </div>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="date">Datum konání:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="date" class="form-control" placeholder="Datum konání události (dd.MM.yyyy HH:mm)" autofocus="true"></form:input>
                        <form:errors path="date"></form:errors>
                    </div>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="duration">Doba trvání:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="duration" class="form-control" placeholder="Doba trvání události" autofocus="true"></form:input>
                        <form:errors path="duration"></form:errors>
                    </div>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="numberOfFreeTickets">Počet volných vstupenek:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="numberOfFreeTickets" class="form-control" placeholder="Počet volných vstupenek" autofocus="true"></form:input>
                        <form:errors path="numberOfFreeTickets"></form:errors>
                    </div>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="priceOfOneTicket">Cena vstupenky:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="priceOfOneTicket" class="form-control" placeholder="Cena jedné vstupenky" autofocus="true"></form:input>
                        <form:errors path="priceOfOneTicket"></form:errors>
                    </div>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="type_id">Typ události:</label>
                    <div class="col-sm-10">
                        <form:select class="form-control" id="type_id" path="type.idType" >
                            <c:forEach items="${typeList}" var="type">
                                <form:option value="${type.idType}" label="${type.name}"></form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="place_id">Místo konání události:</label>
                    <div class="col-sm-10">
                        <form:select class="form-control" id="place_id" path="place.idPlace" >
                            <c:forEach items="${placeList}" var="place">
                                <form:option value="${place.idPlace}" label="${place.name}"></form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="description">Popis události:</label>
                    <div class="col-sm-10">
                        <form:textarea path="description" rows="8" cols="30" id="description"/>
                        <form:errors path="description"></form:errors>
                    </div>
                </div>
                <br />
                <div class="form-group">
                    <div class="col-sm-offset-1 col-xs-2 pull-right">
                        <form:hidden path="idEvent" />
                            <button class="btn btn-primary" type="submit">Upravit událost</button>
                    </div>
                </div>
            </form:form>

        </div>
    </div>
</div>
