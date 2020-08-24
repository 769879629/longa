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
 * 更新订单
 */
public class OrdersUpdateServlet extends HttpServlet {
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


        //获取要更新的订单信息
        String id = req.getParameter("id");
        int ordersId = 0;
        if(id !=null){
            ordersId = Integer.parseInt(id);
        }
        String oname = req.getParameter("oname");
        String price = req.getParameter("price");
        double ordersPrice = 0.0;
        if(price !=null){
            ordersPrice = Double.parseDouble(price);
        }

        //更新操作
        OrdersDao dao = new OrdersDaoImpl();
        Orders orders = new Orders();
        orders.setId(ordersId);
        orders.setOname(oname);
        orders.setPrice(ordersPrice);
        int update = dao.update(orders);
        if(update==0){
            //更新失败
            req.setAttribute("mess", "更新订单失败");
            req.getRequestDispatcher("/ordersinfo.do").forward(req, resp);
        }else{
            req.getRequestDispatcher("/orderslist.do").forward(req, resp);
        }
    }
}
