package dangserver.controller;

import dangserver.common.JSONResult;
import dangserver.pojo.Goods;
import dangserver.pojo.User;
import dangserver.service.GoodsService;
import dangserver.service.ShoppingCartService;
import dangserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    ShoppingCartService shoppingCartService;
    GoodsService goodsService;
    UserService userService;

    @Autowired
    public void setShoppingCartService(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Autowired
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String shoppingCart() {
        return "ShoppingCart";
    }

    @RequestMapping("/{tel}/addGoods")
    public JSONResult addGoods(@PathVariable String tel, @RequestParam int id, @RequestParam int num) {
        // 1.Add to shopping cart
        if (shoppingCartService.addOneGoods(tel, id, num)) {
            // 3.Search goods by id
            return JSONResult
                    .ok()
                    .data("name", goodsService.getByField("id", id)[0].getName()) // search
                    .data("num", num);
        }
        return JSONResult
                .err()
                .setMsg("添加失败");
    }

    @RequestMapping("/{shoppingCartId}/show")
    public JSONResult showCart(@PathVariable int shoppingCartId) {
        // 1.获取数量、总价（这里shoppingCartId同tel
        User user = userService.getUser(String.valueOf(shoppingCartId));
        // 2.获取商品列表
        // 获取该tel对应商品goodsId列表
        int[] goodsIdList = shoppingCartService.getGoodsIdList(String.valueOf(shoppingCartId));
        // 依次由goodsId获取商品
        ArrayList<Goods> goodsList = new ArrayList<>();
        for (int id : goodsIdList) {
            goodsList.add(goodsService.getByField("id", id)[0]);
        }
        return JSONResult
                .ok()
                .data("count", user.getCart_count())
                .data("price", user.getCart_price())
                .data("goodsList", goodsList);
    }
}