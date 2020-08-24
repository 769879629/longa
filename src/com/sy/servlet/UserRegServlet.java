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
 * 用户注册
 */
public class UserRegServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //非空校验
        if(username==null || password==null){
            req.setAttribute("mess", "用户名或密码不能为空");
            req.getRequestDispatcher("/reg.jsp").forward(req, resp);
        }else{
            //用户名重复性校验
            UserDao dao = new UserDaoImpl();
            User user = dao.selectByUsername(username);
            if(user !=null){
                req.setAttribute("mess", "用户名已被注册，请重新输入");
                req.getRequestDispatcher("/reg.jsp").forward(req, resp);
            }else{
                //注册
                user = new User();
                user.setUsername(username);
                user.setPassword(password);
                int insert = dao.insert(user);
                if(insert!=0){
                    resp.sendRedirect("/login.jsp");
                }else{
                    req.setAttribute("mess", "注册失败！");
                    req.getRequestDispatcher("/reg.jsp").forward(req, resp);
                }
            }
        }
    }
}
