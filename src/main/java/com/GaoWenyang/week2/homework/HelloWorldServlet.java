package com.GaoWenyang.week2.homework;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
          PrintWriter writer=response.getWriter();
          writer.println("Name:Gao Wenyang");
          writer.println("ID:2022211001000404");
          writer.println("Date and Time: Tue Mar 12 13:20:45 CST 2024");

        }
    }

