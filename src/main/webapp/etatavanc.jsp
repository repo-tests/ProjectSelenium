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
    	  if(request.getAttribute("tacheencours")!=null){
      List<Tache>tache=(ArrayList<Tache>)request.getAttribute("tacheencours");
      %> 
      
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
	
        




	</form>
 
    <%} else   if(request.getAttribute("acheve")!=null){
        List<Tache>tache=(ArrayList<Tache>)request.getAttribute("acheve");
        %> 
        
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
  