package dangserver.service;

import dangserver.mapper.ShoppingCartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    ShoppingCartMapper shoppingCartMapper;

    GoodsService goodsService;

    UserService userService;

    @Autowired
    public void setShoppingCartMapper(ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @Autowired
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean addOneGoods(String tel, int goodsId, int num) {
        // 1.由goodsId查找购物车是否已存在
        int uniqueNum  = num;   // 同种商品算一个
        for (int id : shoppingCartMapper.getGoodsIdList(tel)) {
            if (id == goodsId) {    // 已存在
                uniqueNum = 0;
                break;
            }
        }
        for (int i = 0; i < num; i++) {
            // 2.更新 shoppingCart表
            if (1 != shoppingCartMapper.addOne(tel, goodsId)) {
                return false;
            }
        }
        // 3.由goodsId获取price
        float price = goodsService.getByField("id", goodsId)[0].getPrice_now();

        // 3.更新user中购物车字段
        userService.updateCartInfo(uniqueNum, price, tel);
        return true;
    }

    @Override
    public int[] getGoodsIdList(String tel) {
        return shoppingCartMapper.getGoodsIdList(tel);
    }
}
