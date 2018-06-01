<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="container">
    <hr>
    <div class="row">
        <div class="col-xs-12">

            <div class="text-primary"> <h2>Seznam míst pro konání událostí:</h2> </div>

            <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')">
            <br /> <a class="btn btn-primary btn-sm"  href="/manage/place/create" role="button">Vytvořit místo pro konání událostí</a>
            </security:authorize>

            <br />

            <table class="table table-striped table-bordered" style="margin-top: 15px">
                <thead class="thead-inverse">
                <tr>
                    <th>Název</th>
                    <th>Ulice</th>
                    <th>Město</th>
                    <th>PSČ</th>
                    <th>Počet míst</th>
                    <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')">
                    <th>Akce</th>
                    </security:authorize>
                </tr>
                </thead>
                <c:forEach items="${listPlaces}" var="place">
                    <tr>
                        <td><a href="<c:url value='/place/detail/${place.idPlace}' />" >${place.name}</a></td>
                        <td>${place.street}</td>
                        <td>${place.city}</td>
                        <td>${place.zipCode}</td>
                        <td>${place.numberOfPlaces}</td>
                        <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')">
                        <td>
                            <a class="btn btn-info btn-block btn-sm" href="<c:url value='/manage/place/edit/${place.idPlace}' />" role="button">Upravit</a>
                            <a class="btn btn-danger btn-block btn-sm" href="<c:url value='/manage/place/remove/${place.idPlace}' />" role="button">Smazat</a>
                        </td>
                        </security:authorize>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>