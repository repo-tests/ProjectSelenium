<%@page import="Model.entities.Personnel"%>
<jsp:include page="header1.jsp"></jsp:include>
      <div id="content">
       <%Personnel p=(Personnel)session.getAttribute("personnel");%>
  <h1><%=p.getRole()%></h1><%
      if(p!=null && p.getRole().equals("developpeur")){%>

Partie Developpeur
      </div>
    </div>
   
    <jsp:include page="Footer.jsp"></jsp:include>
  <%}if(p!=null && !p.getRole().equals("developpeur")){
	  
	  response.sendRedirect(p.getRole()+".jsp");
	  
}
    
  else if(p==null){ response.sendRedirect("index.jsp");
     
     }
%>
       
       