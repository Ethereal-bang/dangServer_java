package dangserver.service;

import dangserver.mapper.GoodsMapper;
import dangserver.pojo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.regex.Pattern;

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
        switch (filedName) {
            case "type":
                if (Objects.equals(fieldVal, "bookRanking"))
                    return goodsMapper.getRanking();
                return goodsMapper.getByType(fieldVal);
            case "id":
                return goodsMapper.getById(fieldVal);
            default:
                throw new IllegalStateException("Unexpected value: " + filedName);
        }
    }

    @Override
    public Goods[] searchByName(String name) {
        if (!Pattern.matches("/[\\u4e00-\\u9fa5\\w]/", name)) {
            return new Goods[]{};
        }
        return goodsMapper.searchByName(name);
    }
}


