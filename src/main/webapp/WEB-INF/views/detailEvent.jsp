<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../layouts/taglibs.jsp"%>


<div class="container">
	<hr>
	<div class="row">
    	<div class="col-sm-8">
    	 <table class="table table-striped table-condensed" style="margin-top: 15px">
      		<tbody>
        		<div class="text-primary"><h2>${eventForm.title}</h2></div>
      			<tr>
      			  	<th><b>Místo konání události:</b></th>
      			  		<td>${eventForm.place.name}</td>
      			</tr>
				<tr>
					<th><b>Typ události:</b></th>
					<td>${eventForm.type.name}</td>
				</tr>
        		<tr>
            		<th><b>Čas konání události:</b></th> 
            			<td><fmt:formatDate value="${eventForm.date}" pattern="dd.MM.yyyy HH:mm"/></td>
        		</tr>
        		<tr>
            		<th><b>Délka trvání:</b></th>  
            			<td>${eventForm.duration} min.</td>
				</tr>
        		<tr>
            		<th><b>Základní popis události:</b></th>   
            			<td>${eventForm.description}</td>
        		</tr>
        		<tr>
            		<th><b>Počet volných vstupenek:</b></th>   
            			<td>${eventForm.numberOfFreeTickets}</td>
        		</tr>
        		<tr>
            		<th><b>Cena za lístek:</b></th>  
            			<td><div class="text-primary"><b> ${eventForm.priceOfOneTicket} Kč </b></div></td>
        		</tr>
			</tbody>
			</table>
        </div>
	</div>
</div>