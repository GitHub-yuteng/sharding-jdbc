package com.shardingjdbc.sharding.controller;

import com.shardingjdbc.sharding.entity.Goods;
import com.shardingjdbc.sharding.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/" + "goods")
public class GoodsController {

    @Autowired
    GoodsService goodsService;

    @PostMapping
    public String saveGoods() {
       goodsService.saveGoods();
        return "success";
    }

    @GetMapping
    public List<Goods> listGoods() {
        return goodsService.listAllGoods();
    }

    @DeleteMapping
    public String deleteAllGoods() {
        goodsService.deleteAllGoods();
        return "delete success";
    }

    @GetMapping("/betweenGoodsId")
    public List<Goods> queryBetweenGoodsIds() {
        // 单行表达式不支持 范围查询 Inline strategy cannot support range sharding
        return goodsService.listAllByGoodsIdBetween(2L, 2L);
    }

    @GetMapping("/inGoodsId")
    public List<Goods> queryInGoodsIds() {
        List<Long> goodsIds = new ArrayList<>();
        goodsIds.add(3L);
        goodsIds.add(6L);
        return goodsService.listAllByGoodsIdIn(goodsIds);
    }
}
