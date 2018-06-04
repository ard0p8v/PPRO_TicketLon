<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="container">
    <hr>
    <div class="row">
        <div class="col-xs-12">

            <div class="text-primary"> <h2>Seznam míst pro konání událostí:</h2> </div>

            <br /> <a class="btn btn-primary btn-sm"  href="/manage/place/create" role="button">Vytvořit místo pro konání událostí</a>

            <br />

            <table class="table table-striped table-bordered" style="margin-top: 15px">
                <thead class="thead-inverse">
                <tr>
                    <th>Uživatelské jméno</th>
                    <th>Jméno</th>
                    <th>Příjmení</th>
                    <th>Role</th>
                    <th>Akce</th>
                </tr>
                </thead>
                <c:forEach items="${listUsers}" var="user">
                    <tr>
                        <td>${user.username}</td>
                        <td>${user.name}</td>
                        <td>${user.surname}</td>
                        <td>${user.role.roleName}</td>
                        <td>
                            <a class="btn btn-info btn-block btn-sm" href="<c:url value='/manage/place/edit/${place.idPlace}' />" role="button">Upravit</a>
                            <a class="btn btn-danger btn-block btn-sm" href="<c:url value='/manage/place/remove/${place.idPlace}' />" role="button">Smazat</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>