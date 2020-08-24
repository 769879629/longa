package com.sy.servlet;

import com.sy.dao.Impl.OrdersDaoImpl;
import com.sy.dao.Impl.UserDaoImpl;
import com.sy.dao.OrdersDao;
import com.sy.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除订单
 */
public class OrdersDelServlet extends HttpServlet {
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
        if(id !=null){
            int ordersId = Integer.parseInt(id);
            //根据订单ID删除订单
            OrdersDao dao = new OrdersDaoImpl();
            int i = dao.deleteById(ordersId);
            if(i!=0){
                //删除成功
                //重新查询订单列表
                req.getRequestDispatcher("/orderslist.do").forward(req, resp);
            }else{
                req.setAttribute("mess", "删除失败");
                req.getRequestDispatcher("/orderslist.do").forward(req, resp);
            }
        }
        req.setAttribute("mess", "删除失败");
        req.getRequestDispatcher("/orderslist.do").forward(req, resp);

    }
}
