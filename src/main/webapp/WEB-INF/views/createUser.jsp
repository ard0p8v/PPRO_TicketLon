<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="container">
    <hr>
    <div class="row">
        <div class="col-xs-12">
            <div class="text-primary">
                <h2>
                    Vytvoření nového uživatele:
                </h2>
            </div>
            <br />

            <form:form method="POST" modelAttribute="userForm" class="form-horizontal">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="name">Jméno:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="name" class="form-control" placeholder="Jméno uživatele" autofocus="true"></form:input>
                        <form:errors path="name"></form:errors>
                    </div>
                </div>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="surname">Příjmení:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="surname" class="form-control" placeholder="Příjmení uživatele" autofocus="true"></form:input>
                        <form:errors path="surname"></form:errors>
                    </div>
                </div>
                <spring:bind path="username">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="username">Uživatelské jméno:</label>
                    <div class="col-sm-10">
                        <form:input type="text" path="username" class="form-control" placeholder="Zadejte uživalteské jméno" autofocus="true"></form:input>
                        <form:errors path="username"></form:errors>
                    </div>
                </div>
                </spring:bind>
                <spring:bind path="password">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" for="password">Heslo:</label>
                    <div class="col-sm-10">
                        <form:input type="password" path="password" class="form-control" placeholder="Zadejte heslo" autofocus="true"></form:input>
                        <form:errors path="password"></form:errors>
                    </div>
                </div>
                </spring:bind>
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <label class="control-label col-xs-2" >Role:</label>
                    <div class="col-sm-10">
                        <form:select path="role.idRole">
                            <form:options items="${rolesList}" itemValue="idRole" itemLabel="roleName"/>
                        </form:select>
                    </div>
                </div>
                <br />
                <div class="form-group">
                    <div class="col-sm-offset-1 col-xs-1 pull-right">
                        <button class="btn btn-primary" type="submit">Vytvořit uživatele</button>
                    </div>
                </div>
            </form:form>

        </div>
    </div>
</div>
