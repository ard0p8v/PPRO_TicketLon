<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>


<div class="container">
    <hr>
    <div class="row">
        <div class="col-sm-8">
            <table class="table table-striped table-condensed" style="margin-top: 15px">
                <tbody>
                <div class="text-primary"><h2>${placeForm.name}</h2></div>
                <tr>
                    <th><b>Ulice:</b></th>
                    <td>${placeForm.street}</td>
                </tr>
                <tr>
                    <th><b>Město:</b></th>
                    <td>${placeForm.city}</td>
                </tr>
                <tr>
                    <th><b>PSČ:</b></th>
                    <td>${placeForm.zipCode}</td>
                </tr>
                <tr>
                    <th><b>Počet míst:</b></th>
                    <td>${placeForm.numberOfPlaces}</td>
                </tr>
                </tbody>
            </table>
            <security:authorize access="hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')">
            <br /> <a class="btn btn-primary col-sm-offset-1 col-xs-1t"  href="/manage/place/create" role="button">Vytvořit nové místo pro konání událostí</a>
            <br />
            </security:authorize>
        </div>
    </div>
</div>