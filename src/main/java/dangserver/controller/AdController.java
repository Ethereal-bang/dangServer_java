package dangserver.controller;

import dangserver.common.JSONResult;
import dangserver.pojo.Ad;
import dangserver.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ad")
public class AdController {

    private AdService adService;

    @Autowired
    public void setAdService(AdService adService) {
        this.adService = adService;
    }

    @RequestMapping("")
    public String Ad() {
        return "Ad";
    }

    @RequestMapping("/getByPos/{pos}")
    public JSONResult getByPos(@PathVariable String pos) {
        Ad[] res = adService.getByPos(pos);
        return JSONResult
                .ok()
                .data("count", res.length)
                .data("list", res);
    }
}
