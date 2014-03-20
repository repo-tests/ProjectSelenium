<%@page import="Model.entities.Tache"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Control.tache"%>
<%@page import="java.util.List"%>
<%@page import="Model.entities.Personnel"%>
<jsp:include page="header1.jsp"></jsp:include>
      <div id="content">
      <%Personnel p=(Personnel)session.getAttribute("personnel");%>
  <h1><%=p.getRole()%></h1><%
      if(p!=null && p.getRole().equals("developpeur")){
    	  if(request.getAttribute("tacheaffecte")!=null){
      List<Tache>tache=(ArrayList<Tache>)request.getAttribute("tacheaffecte");
      %> <form action="tache" method="post">
      
		<table>
       
		     <tr><th>Nom de la tache</th><th> Date début</th><th> Date fin</th></tr>
		<%for(int i=0;i<tache.size();i++){ %>
	<tr>
	
<td><%=tache.get(i).getNom_tache() %>  </td>
<td><%=tache.get(i).getDate_debut() %>  </td>
<td><%=tache.get(i).getDate_fin() %>  </td>
<td><input type="radio" name="tache" value="<%=tache.get(i).getId_tache() %>">
	
	</td>
</tr>
		<%} %>
		<div class="form_settings">
		<tr><td></td><td><input class="submit" type="submit" name="en cours de traitement" value="Marque comme Reçu" /><input class="submit" type="reset" name="reset" value="Annuler" /></td></tr>
		</div>
		</table>
	
        




	</form>
 
    <%}
    	  
      
      
      
      
      
      
      }
  if(p!=null && !p.getRole().equals("developpeur")){
	  
	  response.sendRedirect(p.getRole()+".jsp");
	  
  }
      
    else if(p==null){ response.sendRedirect("index.jsp");
       
       } %>
      </div>
    </div>
   
    <jsp:include page="Footer.jsp"></jsp:include>
  