package dangserver.controller;

import dangserver.common.JSONResult;
import dangserver.service.GoodsService;
import dangserver.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
    ShoppingCartService shoppingCartService;
    GoodsService goodsService;

    @Autowired
    public void setShoppingCartService(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @Autowired
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping("/")
    public String shoppingCart() {
        return "ShoppingCart";
    }

    @RequestMapping("/{tel}/addGoods")
    public JSONResult addGoods(@PathVariable String tel, @RequestParam int id, @RequestParam int num) {
        // 1.Add to shopping cart
        if (shoppingCartService.addOneGoods(tel, id, num)) {
            // 2.Search goods by id
            return JSONResult
                    .ok()
                    .data("name", goodsService.getByField("id", id)[0].getName()) // search
                    .data("num", num);
        }
        return JSONResult
                .err()
                .setMsg("添加失败");
    }
}