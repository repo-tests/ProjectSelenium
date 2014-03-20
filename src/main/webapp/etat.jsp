
      
<%@page import="Model.entities.Personnel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.entities.Tache"%>
<%@page import="java.util.List"%>

 <%Personnel p=(Personnel)session.getAttribute("personnel");%>
<%
      if(p!=null && p.getRole().equals("manager")){
if(request.getParameter("e")!=null) {
	 if(request.getAttribute("tacheencours")!=null){
	      List<Tache>tache=(ArrayList<Tache>)request.getAttribute("tacheencours");
	     if(tache.size()!=0){
	      %> 
	      
		 <jsp:include page="header.jsp"></jsp:include>
		      <div id="content">
  		<table>
	       
			     <tr><th>Personnel</th><th>Nom de la tache</th><th> Date début</th><th> Date fin</th></tr>
			<%for(int i=0;i<tache.size();i++){ %>
		<tr>
		<td><%=tache.get(i).getPr().getNom_pers() %> <%=tache.get(i).getPr().getPrenom_pers() %> </td>
	<td><%=tache.get(i).getNom_tache() %>  </td>
	<td><%=tache.get(i).getDate_debut() %>  </td>
	<td><%=tache.get(i).getDate_fin() %>  </td>

	</tr>
			<%} %>
			
	 		</table>
  		  </div>
		    </div>
		   
		    
   
    <jsp:include page="Footer.jsp"></jsp:include>
  
 <%}else if(tache.size()==0){
	 
	 %> 
     
	 <jsp:include page="header.jsp"></jsp:include>
	      <div id="content">
		Pour l'instant ,il n'existe pas des  taches en cours de traitement
		  </div>
	    </div>
	   
	    

<jsp:include page="Footer.jsp"></jsp:include>
<%
 }
 }
	     else   if(request.getAttribute("acheve")!=null){
        List<Tache>tache=(ArrayList<Tache>)request.getAttribute("acheve");
        %> 
        <jsp:include page="header.jsp"></jsp:include>
		      <div id="content">
  		<table>
        
  		     <tr><th>Personnel</th><th>Nom de la tache</th><th> Date début</th><th> Date fin</th></tr>
  		<%for(int i=0;i<tache.size();i++){ %>
  	<tr>
  	<td><%=tache.get(i).getPr().getNom_pers() %> <%=tache.get(i).getPr().getPrenom_pers() %> </td>
  <td><%=tache.get(i).getNom_tache() %>  </td>
  <td><%=tache.get(i).getDate_debut() %>  </td>
  <td><%=tache.get(i).getDate_fin() %>  </td>

  </tr>
  		<%} %>
  		</table>
  		  </div>
		    </div>
		   
		    <jsp:include page="Footer.jsp"></jsp:include>
      <%}
	    
	 else if(request.getAttribute("affecte")!=null){
		List<Tache> tache=(ArrayList)request.getAttribute("affecte");
		%>
		<jsp:include page="header.jsp"></jsp:include>
		      <div id="content">
		      <table>
		     <tr><th> Personnel</th><th>Nom de la tache</th><th> Date début</th><th> Date fin</th></tr>
		<%for(int i=0;i<tache.size();i++){ %>
	<tr><td><%=tache.get(i).getPr().getNom_pers() %> <%=tache.get(i).getPr().getPrenom_pers() %> </td>
<td><%=tache.get(i).getNom_tache() %>  </td>
<td><%=tache.get(i).getDate_debut() %>  </td>
<td><%=tache.get(i).getDate_fin() %>  </td>
</tr>
		<%} %>
		</table>
		  </div>
		    </div>
		   
		    <jsp:include page="Footer.jsp"></jsp:include>
		<%}

}
else if(request.getParameter("e")==null) {
       %><jsp:include page="header.jsp"></jsp:include>
      <div id="content">
Bienvenue Dans La page de suivi
  </div>
    </div>
   
    <jsp:include page="Footer.jsp"></jsp:include>
  
       <%}

} if(p!=null && !p.getRole().equals("manager")){
	  
	  response.sendRedirect(p.getRole()+".jsp");
	  
}
    
  else if(p==null){ response.sendRedirect("index.jsp");
     
     }
%>
       
       

      
      
      
     
       
    