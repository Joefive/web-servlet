package com.sunrise;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** ServletContext对象：
 * 启动的时候回创建几个Context对象，代表当前web应用
 * 1.共享数据：可以在另外一个servlet中拿到。
 * 2.
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行了doGet方法...!");
        //获取上下文
        ServletContext servletContext = this.getServletContext();
        String userName = "韩三狗";
        servletContext.setAttribute("userName",userName);
        String initParameter = servletContext.getInitParameter("url");
        resp.getWriter().println(initParameter);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
