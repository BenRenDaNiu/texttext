package com.taobao.service;

import com.taobao.dao.DBOper;
import com.taobao.model.Account;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login2 extends HttpServlet {
  /*  @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<!doctyper html5>");
        out.println("<html><head><title>登录界面</title></head>");

        out.println("<body><fieldset><form action='/test/login2' method='post'>");

        out.println("账号<input type='test' name='account'>");
        out.println("<br/>密码<input type='password' name='password'>" +"<br/>"+
                "<input type='submit' value='登录'></form></fieldset><hr/><" +
                "/body></html>");
        out.flush();
        out.close();
    }*/

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        Account acc=null;
        String name=req.getParameter("account");
        String password=req.getParameter("password");
        acc=new Account();
        acc.setAccount(Integer.parseInt(name));
        acc.setPasswprd(password);
        DBOper a=new DBOper();

        a.login(acc);
        if (acc.getStatus()==1){
               /*     PrintWriter printWriter=resp.getWriter();
                  //  printWriter.println("登陆成功");
                    printWriter.flush();
                    printWriter.close();*/
            resp.sendRedirect("/moban/index.html");
            //   req.getRequestDispatcher("/test/test123").forward(req,resp) ;
            return ;
        }else{
            PrintWriter printWriter=resp.getWriter();
            printWriter.println("登录失败");
            printWriter.flush();
            printWriter.close();
        }

    }
}
