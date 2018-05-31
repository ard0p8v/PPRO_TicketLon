<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>

<div class="container">
    <hr>
    <div class="row">
        <div class="col-xs-12">

            <div class="text-primary"> <h2>Novinky:</h2> </div>

            <br /> <a class="btn btn-primary btn-sm"  href="/manage/news/create" role="button">Vytvořit novinku</a>

            <br />

            <table class="table table-striped table-bordered" style="margin-top: 15px">
                <thead class="thead-inverse">
                <tr>
                    <th>Datum přidání</th>
                    <th>Název</th>
                    <th>Text</th>
                    <th>Akce</th>
                </tr>
                </thead>
                <c:forEach items="${listNews}" var="news">
                    <tr>
                        <td><fmt:formatDate value="${news.added}" pattern="dd.MM.yyyy HH:mm"/></td>
                        <td><a href="<c:url value='/news/detail/${news.idNews}' />" >${news.name}</a></td>
                        <td>${news.text}</td>
                        <td>
                            <a class="btn btn-info btn-block btn-sm" href="<c:url value='/manage/news/edit/${news.idNews}' />" role="button">Upravit</a>
                            <a class="btn btn-danger btn-block btn-sm" href="<c:url value='/manage/news/remove/${news.idNews}' />" role="button">Smazat</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</div>