package com.sunrise.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 继承HttpServlet-->继承GenericServlet-->实现Servlet接口；
 * 在HttpServlet类中重写service()方法
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入doGet方法**********！");
        //super.doGet(req, resp);
        //HttpServletResponse响应，向外写东西
        PrintWriter writer = resp.getWriter();
        writer.println("Hello Servlet!!!");
        System.out.println("结束doGet方法**********！");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
