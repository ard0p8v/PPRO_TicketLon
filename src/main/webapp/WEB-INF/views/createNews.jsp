<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="container">
    <hr>
    <div class="row">
        <div class="col-xs-12">
            <div class="text-primary">
                <h2>
                    Vytvoření novinky:
                </h2>
            </div>
            <br />

            <form:form method="POST" modelAttribute="newsForm" class="form-horizontal">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="name">Název novinky:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="name" class="form-control" placeholder="Název novinky" autofocus="true"></form:input>
                        <form:errors path="name"></form:errors>
                    </div>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="added">Datum přidání novinky:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="added" class="form-control" placeholder="Datum přidání novinky (dd.MM.yyyy HH:mm)" autofocus="true"></form:input>
                        <form:errors path="added"></form:errors>
                    </div>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="text">Vlastní text novinky:</label>
                    <div class="col-sm-10">
                        <form:textarea path="text" rows="8" cols="30" id="description"/>
                        <form:errors path="text"></form:errors>
                    </div>
                </div>
                <br />
                <div class="form-group">
                    <div class="col-sm-offset-1 col-xs-1 pull-right">
                        <button class="btn btn-primary" type="submit">Vytvořit událost</button>
                    </div>
                </div>
            </form:form>

        </div>
    </div>
</div>
