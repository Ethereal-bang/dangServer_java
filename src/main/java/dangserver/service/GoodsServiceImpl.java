package dangserver.service;

import dangserver.mapper.GoodsMapper;
import dangserver.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    public void setGoodsMapper(GoodsMapper userMapper) {
        this.goodsMapper = userMapper;
    }

    @Override
    public Goods showAll() {
        return goodsMapper.getAll();
    }

}
