package dangserver.service;

import dangserver.pojo.Goods;

public interface GoodsService {

    Goods[] showAll();

    Goods[] getByField(String fieldName, Object fieldVal);
}
