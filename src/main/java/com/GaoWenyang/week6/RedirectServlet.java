package com.GaoWenyang.week6;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet(name="RedirectServlet",value ="/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     //redirect -same server -Relative URL
     //1.start without "/"
       /* System.out.println("before redirect ");
        //http://localhost:8080/2022211001000404GaoWenyang_war_exploded/redirect
        response.sendRedirect("index.jsp");//URL -change to index.jsp
        System.out.println("after redirect ");*/
        //http://localhost:8080/2022211001000404GaoWenyang_war_exploded/index.jsp


     /*2.start with "/"
        response.sendRedirect("/2022211001000404GaoWenyang_war_exploded/index.jsp"); HTTP Status 404 -Not Found
        http://localhost:8080/2022211001000404GaoWenyang_war_exploded/
        http://localhost:8080/index.jsp
         URL change after 8080 means tomcat */


        //redirect -another server -Absolute URL
        //full URL https://www.baidu.com/
        response.sendRedirect("http://www.baidu.com");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
/*重定位到同一个tomcat:用相对路径,重定位到不同tomcat:用绝对路径 */