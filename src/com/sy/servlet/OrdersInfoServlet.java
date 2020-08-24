package com.sy.servlet;

import com.sy.dao.Impl.OrdersDaoImpl;
import com.sy.dao.Impl.UserDaoImpl;
import com.sy.dao.OrdersDao;
import com.sy.model.Orders;
import com.sy.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 订单详情
 */
public class OrdersInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //查询当前用户
        String uid = req.getParameter("uid");
        User loginUser = null;
        if(uid !=null){
            int userId = Integer.parseInt(uid);
            loginUser = new UserDaoImpl().selectById(userId);
        }
        req.setAttribute("loginUser", loginUser);

        String id = req.getParameter("id");
        int ordersId = 0;
        if(id !=null){
            ordersId = Integer.parseInt(id);
        }
        //查询单个订单
        OrdersDao dao = new OrdersDaoImpl();
        Orders orders = dao.selectById(ordersId);
        req.setAttribute("orders", orders);
        req.getRequestDispatcher("/ordersform.jsp").forward(req,resp);
    }
}
