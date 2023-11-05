<jsp:useBean class="model.User" id="u"/>
<jsp:setProperty name="u" property="*"/>
<%@page import="dao.UserDao" %>

<% 
int result=UserDao.login(u);

if(result>0){
    response.sendRedirect("viewAllUser.jsp");
    }
    else{
    response.sendRedirect("error.jsp");
    }    

%>