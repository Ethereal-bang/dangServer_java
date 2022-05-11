package dangserver.controller;

import dangserver.common.JSONResult;
import dangserver.pojo.Goods;
import dangserver.pojo.ShoppingCart;
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

    @Autowired
    public void setShoppingCartService(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @RequestMapping("/")
    public String shoppingCart() {
        return "ShoppingCart";
    }

//    @RequestMapping("/{tel}/addGoods")
//    public JSONResult addGoods(@PathVariable String tel, @RequestParam String id, @RequestParam int num) {
//        // 1.Search goods by id
//
//        ShoppingCartGoods shoppingCartGoods = new ShoppingCartGoods(id, num);
////        shoppingCartService.addGoods(new ShoppingCart(tel));
////
////        JSONResult jsonResult = new JSONResult();
////        return ;
//    }

}