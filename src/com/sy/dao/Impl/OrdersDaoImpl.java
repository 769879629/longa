package com.sy.dao.Impl;

import com.sy.dao.OrdersDao;
import com.sy.model.Orders;
import com.sy.util.DBUtil;

import java.util.List;

public class OrdersDaoImpl implements OrdersDao {
    @Override
    public List<Orders> selectByUid(int uid) {
        String sql = "select * from orders where uid = ?";
        List<Orders> list = DBUtil.executeQuery(sql, Orders.class, uid);
        return list;
    }

    @Override
    public int deleteById(int id) {
        String sql = "delete from orders where id = ?";
        int i = DBUtil.executeUpdate(sql, id);
        return i;
    }

    @Override
    public int update(Orders orders) {
        String sql = "update orders set oname=?,price=? where id = ?";
        int i = DBUtil.executeUpdate(sql, new Object[]{orders.getOname(), orders.getPrice(), orders.getId()});
        return i;
    }

    @Override
    public Orders selectById(int id) {
        String sql = "select * from orders where id = ?";
        List<Orders> list = DBUtil.executeQuery(sql, Orders.class, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);

    }
    }

