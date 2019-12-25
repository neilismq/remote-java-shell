<%@ page import="java.io.*" %>
<%@ page import="com.bj.zzq.jd.remoteShell.*" %>
<%@ page import="javax.servlet.jsp.JspWriter" %>
<%
    //todo:这个路径需要自定义 自己的测试class文件路径
    String path = "D:\\MyIdeaWorkspace\\testProject\\remote-java-shell\\target\\classes\\com\\bj\\zzq\\jd\\remoteShell\\test\\TestClass.class";
    InputStream is = new FileInputStream(path);
    byte[] b = new byte[is.available()];
    is.read(b);
    is.close();

    out.println("<div style='width:1000;heigth=2000'>");
    out.println(JavaClassExecuter.execute(b));
    out.println("</div>");
%>

