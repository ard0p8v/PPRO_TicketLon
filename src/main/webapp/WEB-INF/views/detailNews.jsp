<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>


<div class="container">
    <hr>
    <div class="row">
        <div class="col-sm-8">
            <table class="table table-striped table-condensed" style="margin-top: 15px">
                <tbody>
                <div class="text-primary"><h2>${newsForm.name}</h2></div>
                <tr>
                    <th><b>Datum přidání novinky:</b></th>
                    <td>${newsForm.added}</td>
                </tr>
                <tr>
                    <th><b>Vlastní text novinky:</b></th>
                    <td>${newsForm.text}</td>
                </tr>
                </tbody>
            </table>
            <br /> <a class="btn btn-primary col-sm-offset-1 col-xs-1t"  href="/manage/news/create" role="button">Vytvořit novinku</a>

            <br />
        </div>
    </div>
</div>