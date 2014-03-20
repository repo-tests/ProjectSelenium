<%@page import="java.util.ArrayList"%>
<%@page import="Model.entities.Personnel"%>
<%@page import="java.util.List"%>
<jsp:include page="header.jsp"></jsp:include>
<div id="content">
  <%Personnel p=(Personnel)session.getAttribute("personnel");%>
<%
      if(p!=null && p.getRole().equals("manager")){
      
     %>
<%if(request.getAttribute("listepersonnel")!=null){
	List<Personnel> pr=(ArrayList)request.getAttribute("listepersonnel");
	
	
	%>

	<h1>Affetcer Une tache</h1>
	<form action="personnel" method="post" >
	 <div class="form_settings">
		<table style="background-color: white; width: 100%">
			<tr>
			<td>Nom de la tache:</td>
				<td><input type="text" name="nom_tache"
					 required="required"></td>
			</tr>
			<tr>
				<td>Date début:</td>
				<td><input type="date" name="ddebut" 
					required="required"></td>
			</tr>
				<tr>
				<td>Date fin:</td>
				<td><input type="date" name="dfin" 
					required="required"></td>
			</tr>
				<tr>
				<td>Nom du Personnel:</td>
				<td><select name="personnel" sTYLE="width:300" >
				<option>Nom du Personnel:</option>
				<%for(int i=0;i<pr.size();i++){ %>
				<option value="<%=pr.get(i).getId_pers()%>"> <%=pr.get(i).getNom_pers()%> <%=pr.get(i).getPrenom_pers()%></option>
				
				<%} %>
				  </select> </td>
			</tr>
			
			
			<tr><td></td><td><input class="submit" type="submit" name="Ajouter" value="Ajouter" /><input class="submit" type="reset" name="reset" value="Annuler" /></td></tr>
		</table>
        


</div>



	</form>
<%} %>

</div>
</div>
<jsp:include page="Footer.jsp"></jsp:include>
 <%} if(p!=null && !p.getRole().equals("manager")){
	  
	  response.sendRedirect(p.getRole()+".jsp");
	  
}
    
  else if(p==null){ response.sendRedirect("index.jsp");
     
     }
  
  
  
  %>
