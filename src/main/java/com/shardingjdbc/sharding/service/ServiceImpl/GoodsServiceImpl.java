package com.shardingjdbc.sharding.service.ServiceImpl;

import com.shardingjdbc.sharding.entity.Goods;
import com.shardingjdbc.sharding.repository.GoodsRepository;
import com.shardingjdbc.sharding.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Override
    @Transactional
    public void saveGoods() {
        Goods goods = new Goods();
        for (int i = 1; i <= 40; i++) {
            goods.setGoodsId((long) i);
            goods.setGoodsName("shangpin" + i);
            goods.setGoodsType((long) (i + 1));
            goodsRepository.save(goods);
        }
    }

    @Override
    public List<Goods> listAllGoods() {
        return goodsRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteAllGoods() {
        goodsRepository.deleteAll();
    }

    @Override
    public List<Goods> listAllByGoodsIdBetween(long start, long end) {
        return goodsRepository.findAllByGoodsIdBetween(start, end);
    }

    @Override
    public List<Goods> listAllByGoodsIdIn(List<Long> goodsIds) {
        return goodsRepository.findAllByGoodsIdIn(goodsIds);
    }
}
