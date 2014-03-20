   <%@page import="Model.entities.Personnel"%>
<%Personnel p=(Personnel)session.getAttribute("personnel");%>
<%
      if(p!=null && p.getRole().equals("manager")){
if(request.getParameter("add")!=null) {%>
<jsp:include page="header.jsp"></jsp:include>
      <div id="content">
      <h2>Ajout d'un Personnel</h2>
<form action="addpersonnel" method="post" >
	 <div class="form_settings">
		<table style="background-color: white; width: 100%">
			<tr>
			<td>Nom:</td>
				<td><input type="text" name="nom"
					 required="required"></td>
			</tr>
			<tr>
				<td>Prénom:</td>
				<td><input type="text" name="prenom" 
					required="required"></td>
			</tr>
				<tr>
				<td>Date d'embauche:</td>
				<td><input type="date" name="dem" 
					required="required"></td>
			</tr>
			
			
			<tr><td></td><td><input class="submit" type="submit" name="Ajouter" value="Ajouter" /><input class="submit" type="reset" name="reset" value="Annuler" /></td></tr>
		</table>
        
</div>



	</form>


</div>
</div>


        <%}else if(request.getParameter("update")!=null)
        	{%>
        	<jsp:include page="header.jsp"></jsp:include>
      <div id="content">
        	Modification
        	
        	
        	
      </div>



	



</div>
   
    <jsp:include page="Footer.jsp"></jsp:include>
  <%}else
        	{%>	<jsp:include page="header.jsp"></jsp:include>
      <div id="content">
        	Partie Personnel
        	
        	
        	
      </div>



	



</div>
   
    <jsp:include page="Footer.jsp"></jsp:include><%}
} if(p!=null && !p.getRole().equals("manager")){
  	  
  	  response.sendRedirect(p.getRole()+".jsp");
  	  
  }
      
    else if(p==null){ response.sendRedirect("index.jsp");
       
       }
  %>
         
         

        
        
        
       
         
       