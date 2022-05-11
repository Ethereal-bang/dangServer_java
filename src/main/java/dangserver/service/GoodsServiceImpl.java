package dangserver.service;

import dangserver.mapper.GoodsMapper;
import dangserver.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    private GoodsMapper goodsMapper;

    @Autowired
    public void setGoodsMapper(GoodsMapper userMapper) {
        this.goodsMapper = userMapper;
    }

    @Override
    public Goods[] showAll() {
        return goodsMapper.getAll();
    }

    @Override
    public int getCount() {
        return goodsMapper.getCount();
    }
}


