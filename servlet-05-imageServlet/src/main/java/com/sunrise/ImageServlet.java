package com.sunrise;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置浏览器3秒刷新一次
        resp.setHeader("refresh", "3");
        //内存中创建一个图片
        BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_3BYTE_BGR);
        //得到一个图片
        Graphics2D g = (Graphics2D) image.getGraphics();
        //设置图片背景颜色，大小
        g.setColor(Color.white);
        g.fillRect(0, 0, 80, 20);
        //给图片写入数据
        g.setColor(Color.BLUE);
        g.setFont(new Font(null, Font.ITALIC, 20));
        g.drawString(makeNum(), 0, 20);

        //告诉浏览器，这个请求用图片方式
        resp.setContentType("image/jpg");
        //浏览器有缓存，设置浏览器不进行缓存
        resp.setDateHeader("expires", -1);
        resp.setHeader("Cache-Control", "no-cache");
        resp.setHeader("Pragma", "no-cache");

        //图片写给浏览器
        boolean write = ImageIO.write(image, "jpg", resp.getOutputStream());

    }

    //生成随机数字
    public String makeNum() {
        Random random = new Random();
        //加空字符串，强制转换成字符串
        String num = random.nextInt(999999) + "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 6 - num.length(); i++) {
            stringBuilder.append("0");
        }
        return num = stringBuilder.toString() + num;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}
