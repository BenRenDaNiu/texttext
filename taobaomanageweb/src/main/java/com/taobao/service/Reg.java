package com.taobao.service;



import com.taobao.dao.DBOper;
import com.taobao.model.Account;
import org.mortbay.util.ajax.JSON;


import javax.jws.WebService;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static java.awt.SystemColor.window;

/*@WebServlet(name="login", urlPatterns = "test/login1")*/

public class Reg extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /*  resp.setCharacterEncoding("UTF-8");
      resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<!doctyper html5>");
        out.println("<html><head><title>注册界面</title></head>");

        out.println("<body><fieldset><form action='/test/login1' method='post'>");

        out.println("账号<input type='test' name='account' >");
        out.println("<br/>密码<input type='password' name='pswd'>" +"<br/>"+
                "<input type='submit' value='注册'></form></fieldset><hr/><" +
                "/body></html>");
        out.flush();
        out.close();*/

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account acc=null;
        acc=new Account();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html");
        String name=req.getParameter("account");
        String password=req.getParameter("pswd");
        DBOper b=new DBOper();
        PrintWriter out=resp.getWriter();
        //  out.println("接受到的账号"+name);
        //out.println("接受到的密码"+password);
        boolean b1=b.isaccountcode(Integer.parseInt(name));
        if (b1){
            System.out.println("注册失败");
           // String str="注册失败";
           /* String jsonString= JSON.toJSONString(str,true);
            out.println(jsonString);*/

        }else {
            String str="Success";
           /* String jsonString= JSON.toJSONString(str,true);
            //   window.alert("");*/
            acc.setAccount(Integer.parseInt(name));
            acc.setPasswprd(password);

            b.addUser(acc);
            resp.sendRedirect("/Login2.html");
        }
        out.flush();
        out.close();

      /*  RequestDispatcher dispatcher=req.getRequestDispatcher("/test/calc");
        dispatcher.forward(req,resp);
        */








    }
}
