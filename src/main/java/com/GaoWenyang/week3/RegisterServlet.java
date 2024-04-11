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

@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)

public class RegisterServlet extends HttpServlet {
    Connection con=null;
    //ServletContext context=null;
    @Override
    public void init() throws ServletException {
        super.init();
        /*context=getServletContext();
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

        }*/
        con= (Connection) getServletContext().getAttribute("con");//name of attribute
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
        String birthdate =request.getParameter("birth");
        PrintWriter out=response.getWriter();
        try {
            Statement ps=con.createStatement();
            String sql="insert into usertable(username,password,email,gender,birthdate)"+"values('"+username+"','"+password+"','"+email+"','"+gender+"','"+birthdate+"')";
            //执行SQL 返回影响的行数
            int rows=ps.executeUpdate(sql);
            if(rows>0){
                System.out.println("成功添加了 "+rows+"条数据");
            }
             sql="select id,username,password,email,gender,birthdate from usertable";
            ResultSet rs=ps.executeQuery(sql);
            // 构建html表格
            //here is html code --move these html code in a jsp page -userList.jsp
            /*out.println("<html><title></title><body><table border='1'>");
            out.println("<tr><th>UserName</th><th>Password</th><th>Email</th><th>Gender</th><th>Birthdate</th></tr>");
            while (rs.next()){
            out.println("<tr>");
            out.println("<td>"+rs.getString("username")+"</td>");
            out.println("<td>"+rs.getString("password")+"</td>");
            out.println("<td>"+rs.getString("email")+"</td>");
            out.println("<td>"+rs.getString("gender")+"</td>");
            out.println("<td>"+rs.getString("birthdate")+"</td>");
            out.println("</tr>");
            }
            out.println("</table></body></html>");*/
            /*//use request attribute
            //set rs into request attribute
            request.setAttribute("rsname",rs); // name -string,value -any type(object)
            request.getRequestDispatcher("userList.jsp").forward(request,response);
             //at this point request given to userList.jsp but url does-not change
             //no more here
            System.out.println("I am in RegisterServlet -->doPost() -->after forward()");//no see this line*/
            response.sendRedirect("login.jsp");
            out.close();
            rs.close();
            ps.close();
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
