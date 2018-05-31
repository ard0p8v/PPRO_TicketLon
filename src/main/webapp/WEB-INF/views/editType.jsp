<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="container">
    <hr>
    <div class="row">
        <div class="col-xs-12">
            <div class="text-primary">
                <h2>
                    Editace typu události:
                </h2>
            </div>
            <br />

            <form:form method="POST" modelAttribute="typeForm" class="form-horizontal">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="name">Název:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="name" class="form-control" placeholder="Název typu události" autofocus="true"></form:input>
                        <form:errors path="name"></form:errors>
                    </div>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="description">Popis typu události:</label>
                    <div class="col-sm-10">
                        <form:textarea path="description" rows="8" cols="30" id="description"/>
                        <form:errors path="description"></form:errors>
                    </div>
                </div>
                <br />
                <div class="form-group">
                    <div class="col-sm-offset-1 col-xs-2 pull-right">
                        <form:hidden path="idType" />
                        <button class="btn btn-primary" type="submit">Upravit typ události</button>
                    </div>
                </div>
            </form:form>

        </div>
    </div>
</div>
