package com.GaoWenyang.week6;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String txt=request.getParameter("txt");
      String search=request.getParameter("search");
      if(txt==null){
          response.sendRedirect("index.jsp");
      }else {
          if("baidu".equals(search)){
              response.sendRedirect("https://www.baidu.com");
          }

          if("bing".equals(search)){
              response.sendRedirect("https://cn.bing.com");
          } else if ("google".equals(search)) {
              response.sendRedirect("https://www.google.com");
          }
      }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
