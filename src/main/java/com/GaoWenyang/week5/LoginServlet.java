package com.GaoWenyang.week5;

import com.GaoWenyang.dao.UserDao;
import com.GaoWenyang.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name="LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    //ServletContext context=null;
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        /*context = getServletContext();
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
        }*/
        con= (Connection) getServletContext().getAttribute("con");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out=response.getWriter();
       String username=request.getParameter("username");
       String password=request.getParameter("password");
        UserDao userDao=new UserDao();
        try {
           User user= userDao.findByUsernamePassword(con,username,password);
           if(user!=null){
               //set user into request
               request.setAttribute("user",user);
               //get user info in jsp
               request.getRequestDispatcher("WEB-INF/views/userinfo.jsp").forward(request,response);
           }
           else {
               request.setAttribute("message","Username or Password Error!!!");
               request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
           }
        } catch (SQLException e) {
            out.println("An error occurred during login.");
            throw new RuntimeException(e);

        }

        /*String sql="select id,username,password,email,gender,birthdate from usertable where username='"+username+"'+ and password='"+password+"'";

            *//*PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);*//*
            try{
                *//*PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1, username);
                statement.setString(2, password);
                ResultSet rs = statement.executeQuery();*//*
                ResultSet rs=con.createStatement().executeQuery(sql);
                if (rs.next()) {
                    //out.println("Login success!!!");
                    //out.println("Welcome " + username);
                    request.setAttribute("id",rs.getInt("id"));
                    request.setAttribute("username",rs.getString("username"));
                    request.setAttribute("password",rs.getString("password"));
                    request.setAttribute("email",rs.getString("email"));
                    request.setAttribute("gender",rs.getString("gender"));
                    request.setAttribute("birthDate",rs.getString("birthdate"));
                    //forward to user info jsp
                    request.getRequestDispatcher("userinfo.jsp").forward(request,response);


                } else {
                    //out.println("Username or Password Error!!!");
                    request.setAttribute("message","Username or Password Error!!!");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }
                rs.close();
                con.close();

            }
         catch (SQLException e) {
            e.printStackTrace();
            out.println("An error occurred during login.");
        }*/



    }
}