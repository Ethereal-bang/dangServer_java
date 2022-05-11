package dangserver.service;

import dangserver.mapper.GoodsMapper;
import dangserver.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

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
    public Goods[] getByField(String filedName, Object fieldVal) {
        if (Objects.equals(filedName, "type")) {
            return goodsMapper.getByType(fieldVal);
        }

        return goodsMapper.getAll();
    }
}


