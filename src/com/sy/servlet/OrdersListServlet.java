package com.sy.servlet;

import com.sy.dao.Impl.OrdersDaoImpl;
import com.sy.dao.OrdersDao;

import com.sy.model.Orders;
import com.sy.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 显示用户对应的订单列表
 */
public class OrdersListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //当前登录的用户
        User loginUser = (User)req.getAttribute("loginUser");
        //对应的订单
        OrdersDao dao = new OrdersDaoImpl();
        List<Orders> list = dao.selectByUid(loginUser.getId());
        req.setAttribute("list", list);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
