<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="container">
    <hr>
    <div class="row">
        <div class="col-xs-12">
            <div class="text-primary">
                <h2>
                    Vytvoření nového místa pro konání události:
                </h2>
            </div>
            <br />

            <form:form method="POST" modelAttribute="placeForm" class="form-horizontal">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="name">Název:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="name" class="form-control" placeholder="Název typu události" autofocus="true"></form:input>
                        <form:errors path="name"></form:errors>
                    </div>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="street">Ulice:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="street" class="form-control" placeholder="Název typu události" autofocus="true"></form:input>
                        <form:errors path="street"></form:errors>
                    </div>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="city">Město:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="city" class="form-control" placeholder="Název typu události" autofocus="true"></form:input>
                        <form:errors path="city"></form:errors>
                    </div>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="zipCode">PSČ:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="zipCode" class="form-control" placeholder="Název typu události" autofocus="true"></form:input>
                        <form:errors path="zipCode"></form:errors>
                    </div>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="numberOfPlaces">Počet míst:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="numberOfPlaces" class="form-control" placeholder="Název typu události" autofocus="true"></form:input>
                        <form:errors path="numberOfPlaces"></form:errors>
                    </div>
                </div>
                <br />
                <div class="form-group">
                    <div class="col-sm-offset-1 col-xs-1 pull-right">
                        <form:hidden path="idPlace" />
                        <button class="btn btn-primary" type="submit">Upravit místo pro konání události</button>
                    </div>
                </div>
            </form:form>

        </div>
    </div>
</div>
