package dangserver.controller;

import dangserver.common.JSONResult;
import dangserver.pojo.Goods;
import dangserver.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goods")
public class GoodsController {
    GoodsService goodsService;

    @Autowired
    public void setGoodsService(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @RequestMapping("/")
    public String goods() {
        return "Goods";
    }

    @RequestMapping("/showAll")
    public JSONResult showAll() {
        Goods[] res = goodsService.showAll();
        return JSONResult
                .ok()
                .data("list", res)
                .data("count", res.length);
    }

    @RequestMapping("/getByType")
    public JSONResult getByType(@RequestParam String type) {
        Goods[] res = goodsService.getByField("type", type);
        return JSONResult
                .ok()
                .data("count", res.length)
                .data("list", res);
    }

}