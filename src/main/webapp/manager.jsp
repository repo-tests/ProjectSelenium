<%@page import="Model.entities.Personnel"%>
<jsp:include page="header.jsp"></jsp:include>
      <div id="content">
   <%Personnel p=(Personnel)session.getAttribute("personnel");%>
<%
      if(p!=null && p.getRole().equals("manager")){
      
     %>
        bienvenue TP N°14 ( Etat D'avancement dans une équipe)
      </div>
    </div>
   
    <jsp:include page="Footer.jsp"></jsp:include>
  <%} if(p!=null && !p.getRole().equals("manager")){
	  
	  response.sendRedirect(p.getRole()+".jsp");
	  
}
    
  else if(p==null){ response.sendRedirect("index.jsp");
     
     }
  
  
  
  %>
  