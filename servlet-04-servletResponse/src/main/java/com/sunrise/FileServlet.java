package com.sunrise;

import sun.net.www.content.image.png;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Set;

public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过上下文获取文件绝对路径
        //String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/1.jpg");
        String realPath ="D:\\MyWork\\web-servlet\\servlet-04-servletResponse\\target\\classes\\图片.png";
        //D:\MyWork\web-servlet\servlet-04-servletResponse\target\classes\1. png
        System.out.println("要下载文件路径：" + realPath);
        //2.获取下载文件名称，截取斜杠以后的
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        System.out.println("要下载文件名：" + fileName);
        //3.让浏览器能够支持下载我们需要的东西,WEB下载文件头信息
        resp.setHeader("Content-disposition","attachment;fileName="+ URLEncoder.encode(fileName,"utf-8"));
        //4.获取文件下载输入流
        FileInputStream in = new FileInputStream(realPath);
        //5.创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024*512];
        //6.获取outputStream对象
        ServletOutputStream out = resp.getOutputStream();
        //7.将获取的FileOutputStream流写入到buffer缓冲区，使用OutputStream将缓冲区中的数据写入到客户端；
        while ((len=in.read(buffer))!=-1){
            out.write(buffer,0,len);
        }
        //8.关闭流
        in.close();
        out.close();



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
