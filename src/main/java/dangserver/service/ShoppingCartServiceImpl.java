package dangserver.service;

import dangserver.mapper.ShoppingCartMapper;
import dangserver.pojo.ShoppingCart;
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
    public void addGoods(ShoppingCart shoppingCart) {
        shoppingCartMapper.add(shoppingCart);
    }
}
