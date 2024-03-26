package com.GaoWenyang.week4;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@WebServlet(name="ConfigDemoServlet",value = "/config",
     initParams ={
             @WebInitParam(name="name1",value="GaoWenyang"),
             @WebInitParam(name="studentID1",value = "2022211001000404")
     }

)
// use @web-servlet -no web.xml code
/*@WebServlet(
        urlPatterns = {"/configdemo"},
        initParams = {
                @WebInitParam(name = "driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name = "url",value ="jdbc:sqlserver://localhost;databaseName=userdb;encrypt=false;trustServerCertificate=false;"
                        ),
                @WebInitParam(name = "username",value = "sa"),
                @WebInitParam(name = "password",value = "admin123456789")
        }

) // end of web-servlet 直接在servlet里用web-servlet注释*/
public class ConfigDemoServlet extends HttpServlet {
    Connection con=null;
    ServletConfig config=null;

   @Override
    public void init() throws ServletException {
          config=getServletConfig();

        //only one connection
      /* String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
       String url="jdbc:sqlserver://localhost;databaseName=userdb;encrypt=false;trustServerCertificate=false";
       String username="sa";
       String password="admin123456789";
       // code like this is a bad way -- because change is not easy
       // for example change password of db --need to change in java code

       //  get servletconfig-->getInitParameters   no change
       //在web.xml中设置如下配置信息
       String driver=config.getInitPrameter("driver");    // <param-name>driver</param-name>
       String url=config.getInitParameter("url");          // <param-name>url</param-name>
       String username=config.getInitParameter("username");// <param-name>username</param-name>
       String password=config.getInitParameter("password");// <param-name>password</param-name>
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("init()--> "+con);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name= config.getInitParameter("name");
        String id= config.getInitParameter("studentID");
        String name1=config.getInitParameter("name1");
        String id1=config.getInitParameter("studentID1");
        PrintWriter writer=response.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>" + "Task 1-Get init parameters from web.xml" + "</h1>");
        writer.println("<br>name: "+name);
        writer.println("<br>studentID: "+id);
        writer.println("<br><h1>"+"Task 2-Get init parameters from @WebServlet"+"</h1>");
        writer.println("<br>name1:"+name1);
        writer.println("<br>studentID1:"+id1);
        writer.println("</body></html>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
// conclusion:4种连接数据库的方法:
// 1.在init()里写java code: driver url username password
// 2.在web.xml中配置init-param  <init-param>name</init-param>  <init-param>value</init-param>
// 3.在servlet中用web-servlet注释文档 @WebServlet( urlPattern={""},  InitParam={ } )
// 4.在web.xml中配置 <context-param> 可做到同一个数据库连接所有的servlet和jsp,方便更改数据库
//                   <param-name></param-name>
//                   <param-value></param-value>
//               </context-param>