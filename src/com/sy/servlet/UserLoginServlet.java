package com.sy.servlet;

import com.sy.dao.Impl.UserDaoImpl;
import com.sy.dao.UserDao;
import com.sy.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户登录
 */
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username = req.getParameter("username");
       String password = req.getParameter("password");
       //非空校验
        if(username==null || password==null){
            req.setAttribute("mess", "用户或密码不能为空");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }else{
            //用户名不存在
            UserDao dao = new UserDaoImpl();
            User user = dao.selectByUsername(username);
            if(user==null){
                req.setAttribute("mess", "用户名不存在，请注册");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }else if(user.getPassword().equals(password)){
               //密码校验成功
                req.setAttribute("loginUser", user);
                req.getRequestDispatcher("/orderslist.do").forward(req, resp);
            }else{
                //密码校验失败
                req.setAttribute("mess", "用户名或密码错误，请重新输入");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }
        }
    }
}
