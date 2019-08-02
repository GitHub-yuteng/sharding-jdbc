package com.shardingjdbc.sharding.service;

import com.shardingjdbc.sharding.entity.Goods;
import java.util.List;

public interface GoodsService {

   void saveGoods();

    List<Goods> listAllGoods();

    void deleteAllGoods();

    List<Goods> listAllByGoodsIdBetween(long start, long end);

    List<Goods> listAllByGoodsIdIn(List<Long> goodsIds);
}
