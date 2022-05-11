package dangserver.service;

import dangserver.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    ShoppingCartMapper shoppingCartMapper;

    @Autowired
    public void setShoppingCartMapper(ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @Override
    public boolean addOneGoods(String tel, int goodsId, int num) {
        for (int i = 0; i < num; i++) {
            if (1 != shoppingCartMapper.addOne(tel, goodsId)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int[] getGoodsIdList(String tel) {
        return shoppingCartMapper.getGoodsIdList(tel);
    }
}
