<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="container">
    <hr>
    <div class="row">
        <div class="col-xs-12">

            <div class="text-primary"> <h2>Seznam typů událostí:</h2> </div>

            <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')">
            <br /> <a class="btn btn-primary btn-sm"  href="/manage/type/create" role="button">Vytvořit nový typ události</a>
            </security:authorize>

            <br />

            <table class="table table-striped table-bordered" style="margin-top: 15px">
                <thead class="thead-inverse">
                <tr>
                    <th>Název</th>
                    <th>Popis</th>
                    <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')">
                    <th>Akce</th>
                    </security:authorize>
                </tr>
                </thead>
                <c:forEach items="${listTypes}" var="type">
                    <tr>
                        <td><a href="<c:url value='/type/detail/${type.idType}' />" >${type.name}</a></td>
                        <td>${type.description}</td>
                        <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')">
                        <td>
                            <a class="btn btn-info btn-block btn-sm" href="<c:url value='/manage/type/edit/${type.idType}' />" role="button">Upravit</a>
                            <a class="btn btn-danger btn-block btn-sm" href="<c:url value='/manage/type/remove/${type.idType}' />" role="button">Smazat</a>
                        </td>
                        </security:authorize>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>