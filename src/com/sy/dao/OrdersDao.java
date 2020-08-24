package com.sy.dao;

import com.sy.model.Orders;

import java.util.List;

public interface OrdersDao {


    List<Orders> selectByUid(int uid);
    int deleteById(int id);
    int update(Orders orders);
    Orders selectById(int id);

}
