<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>


<div class="container">
    <hr>
    <div class="row">
        <div class="col-sm-8">
            <table class="table table-striped table-condensed" style="margin-top: 15px">
                <tbody>
                <div class="text-primary"><h2>${typeForm.name}</h2></div>
                <tr>
                    <th><b>Popis typu události:</b></th>
                    <td>${typeForm.description}</td>
                </tr>
                </tbody>
            </table>
            <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')">
            <br /> <a class="btn btn-primary col-sm-offset-1 col-xs-1t"  href="/manage/type/create" role="button">Vytvořit nový typ události</a>
            <br />
            </security:authorize>
        </div>
    </div>
</div>