##Servlet学习记录：
###1.WEB.XML标准格式
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
         http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"  
         version="4.0" metadata-complete="true">
</web-app>
```
###解决无法导出xml
```xml
<build>
        <resources>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>
```

##2.ServletContext对象：
 * 启动的时候回创建几个Context对象，代表当前web应用
 * 1.共享数据：可以在另外一个servlet中拿到。需要先存后读，先执行数据存入的Servlet，在执行读取数据的Servlet；
 * 2.重定向；
