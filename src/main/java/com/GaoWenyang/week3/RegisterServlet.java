package com.GaoWenyang.week3;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(
        name = "RegisterServlet",urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    ServletContext context=null;
    @Override
    public void init() throws ServletException {
        context=getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("username");
        String password = context.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("mysql连接成功" + con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("birth");
        PrintWriter out=response.getWriter();
        try {
            String sql="insert into usertable(id,username,password,email,gender,birthdate)default values (?,?,?,?,?,?)";
            // 创建PreparedStatement;执行SQL
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,2);
            ps.setString(2,username);
            ps.setString(3,password);
            ps.setString(4,email);
            ps.setString(5,gender);
            ps.setString(6,birthdate);
            ps.executeUpdate(sql);
            //执行SQL 返回影响的行数
            int rows=ps.executeUpdate(sql);
            if(rows>0){
                System.out.println("成功添加了 "+rows+"条数据");
            }
            String selectsql="select *from usertable";
            PreparedStatement selectps=con.prepareStatement(selectsql);
            ResultSet rs=selectps.executeQuery(selectsql);
            // 构建html表格
            out.println("<table border='1'>");
            out.println("<tr><th>ID</th><th>UserName</th><th>Password</th><th>Email</th><th>Gender</th><th>Birthdate</th></tr>");
            while (rs.next()){
            out.println("<tr>");
            out.println("<td>"+rs.getInt(2)+"</td>");
            out.println("<td>"+rs.getString(username)+"</td>");
            out.println("<td>"+rs.getString(password)+"</td>");
            out.println("<td>"+rs.getString(email)+"</td>");
            out.println("<td>"+rs.getString(gender)+"</td>");
            out.println("<td>"+rs.getString(birthdate)+"</td>");
            out.println("</tr>");
            }
            out.println("</table>");
            out.close();
            rs.close();
            ps.close();
            selectps.close();
            con.close();
        } catch (SQLException e) {
            out.println("数据添加失败!");
            e.printStackTrace();

        }

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
