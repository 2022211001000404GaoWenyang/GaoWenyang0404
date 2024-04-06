package com.GaoWenyang.week5.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name="LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    ServletContext context=null;
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        context = getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("连接mysql数据库成功!" + con);
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

       String username=request.getParameter("username");
       String password=request.getParameter("password");
        PrintWriter out=response.getWriter();
        String sql="select *from usertable where username='GaoWenyang' and password='135'";
        try {
            /*PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);*/
            Statement sm=con.createStatement();
            sm.executeQuery(sql);
            try (ResultSet rs = sm.executeQuery(sql)) {
                if (rs.next()) {
                    out.println("Login success!!!");
                    out.println("Welcome " + username);
                } else {
                    out.println("Username or Password Error!!!");
                }
                rs.close();
                sm.close();
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("An error occurred during login.");
        }


    }
}
